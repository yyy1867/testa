package ml.guxing.test.core.action

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonSlurper
import org.activiti.bpmn.converter.BpmnXMLConverter
import org.activiti.editor.language.json.converter.BpmnJsonConverter
import org.activiti.engine.*
import org.activiti.engine.history.HistoricActivityInstance
import org.activiti.engine.impl.ProcessEngineImpl
import org.activiti.engine.impl.context.Context
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity
import org.activiti.engine.impl.pvm.PvmTransition
import org.activiti.engine.impl.pvm.process.ActivityImpl
import org.activiti.engine.repository.Model
import org.activiti.image.ProcessDiagramGenerator
import org.apache.commons.lang3.StringUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("/act")
class ActivitiService {

    final def PROCESS_KEY = "timesheetApprove"
    final def Logger logger = LoggerFactory.getLogger(ActivitiService.class)

    @Autowired
    def ProcessEngine processEngine
    @Autowired(required = false)
    def ProcessEngineImpl processEngineImpl
    def RepositoryService repositoryService
    def TaskService taskService
    def RuntimeService runtimeService
    def HistoryService historyService
    @Autowired
    def ObjectMapper objectMapper
    def JsonSlurper jsonSlurper
    def ProcessDiagramGenerator diagramGenerator

    @PostConstruct
    def init() {
        if (!processEngineImpl) {
            processEngineImpl = processEngine
            logger.info("初始化processEngineImpl完毕!!!")
        }
        repositoryService = processEngineImpl.getRepositoryService()
        taskService = processEngineImpl.getTaskService()
        runtimeService = processEngineImpl.getRuntimeService()
        historyService = processEngineImpl.getHistoryService()
        jsonSlurper = JsonSlurper.newInstance()

        def configuration = processEngineImpl.getProcessEngineConfiguration()
        Context.setProcessEngineConfiguration(configuration)
        diagramGenerator = configuration.getProcessDiagramGenerator()


    }

    @RequestMapping("")
    @ResponseBody
    def Object home() {
        def String BASE_URL = "http://127.0.0.1:8081"
        def list = []
        list += [name: "所有流程", url: "${BASE_URL}/act/listdev".toString()]
        list += [name: "所有模型", url: "${BASE_URL}/act/listModel".toString()]
        list += [name: "所有任务", url: "${BASE_URL}/act/listTask".toString()]
        list += [name: "清空流程", url: "${BASE_URL}/act/delAll".toString()]
        return list
    }

    @RequestMapping("/listdev")
    @ResponseBody
    def Object listDeployment() {
        def String BASE_URL = "http://127.0.0.1:8081"
        def list = repositoryService.createProcessDefinitionQuery().list()
        return list?.collect {
            ["id"      : it["id"], "name": it["name"], "key": it["key"],
             "startUrl": "${BASE_URL}/act/startProcess?processKey=${it.key}".toString()]
        }
    }

    @RequestMapping("/listModel")
    @ResponseBody
    def Object listModel() {
        def String BASE_URL = "http://127.0.0.1:8081"
        def editUrl = "${BASE_URL}/process-editor/modeler.html"
        def deployUrl = "${BASE_URL}/act/deployModel"
        def downUrl = "${BASE_URL}/act/downloadModel"
        def list = repositoryService.createModelQuery().list()
        return list?.collect {
            ["id"       : it.id, "name": it.name, "key": it.key,
             "editUrl"  : "${editUrl}?modelId=${it.id}".toString(),
             "deployUrl": "${deployUrl}?modelId=${it.id}".toString(),
             "downUrl"  : "${downUrl}?modelId=${it.id}".toString()]
        }
    }

    @RequestMapping("/delAll")
    @ResponseBody
    def Object deployDeployment() {
        def deployments = repositoryService.createDeploymentQuery().list()
        def rest = []
        deployments?.each {
            repositoryService.deleteDeployment(it.id, true)
            rest += ["id": it.id, "name": it.name]
        }
        return rest
    }

    @RequestMapping("/listTask")
    @ResponseBody
    def Object listTask() {
        def String BASE_URL = "http://127.0.0.1:8081"
        def String viewUrl = "${BASE_URL}/diagram-viewer/index.html"
        def String pngUrl = "${BASE_URL}/act/queryTask?taskId="
        def list = taskService.createTaskQuery().list()
        return list?.collecot({
            [id                 : it.id, name: it.name, processInstanceId: it.processInstanceId, executionId: it.executionId,
             processDefinitionId: it.processDefinitionId,
             viewUrl            : "${viewUrl}?processInstanceId=${it.processInstanceId}&processDefinitionId=${it.processDefinitionId}".toString(),
             pngUrl             : pngUrl + it.id]
        })
    }

    @RequestMapping("/deployModel")
    @ResponseBody
    def Object deployModel(@RequestParam String modelId) {
        def model = repositoryService.createModelQuery().modelId(modelId).singleResult()
        if (model) {
            def bpmnModel = new BpmnJsonConverter().convertToBpmnModel(objectMapper.readTree(repositoryService.getModelEditorSource(model.id)))
            def xmlBytes = new BpmnXMLConverter().convertToXML(bpmnModel)
            def deployment = repositoryService.createDeployment()
                    .name(model.name)
                    .addInputStream("${model.name}.bpmn", new ByteArrayInputStream(xmlBytes))
                    .deploy()
            return deployment
        }
        return "不存在的模型Id"
    }

    @RequestMapping("/downloadModel")
    def Object downloadModel(@RequestParam String modelId, HttpServletResponse response) {
        def model = repositoryService.createModelQuery().modelId(modelId).singleResult()
        if (model) {
            def bpmnModel = new BpmnJsonConverter().convertToBpmnModel(objectMapper.readTree(repositoryService.getModelEditorSource(model.id)))
            def xmlBytes = new BpmnXMLConverter().convertToXML(bpmnModel)
            response.getOutputStream().write(xmlBytes)
            response.getOutputStream().flush()
            return "success"
        }
        return "不存在的模型Id"
    }

    @RequestMapping("/startProcess")
    @ResponseBody
    def Object startProcess(@RequestParam String processKey) {
        def processInstance = runtimeService.startProcessInstanceByKey(processKey)
        return processInstance
    }

    @RequestMapping("/queryTask")
    def Object queryTask(@RequestParam String taskId, HttpServletResponse response) {
        def task = taskService.createTaskQuery().taskId(taskId).singleResult()
        def processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(task.processInstanceId).singleResult()
        def bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId())
        def definitionEntity = repositoryService.getProcessDefinition(processInstance.getProcessDefinitionId()) as ProcessDefinitionEntity
        def highLightedActivitList = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstance.getId()).list()
        def highLightedActivitis = new ArrayList()
        def highLightedFlows = getHighLightedFlows(definitionEntity, highLightedActivitList)
        highLightedActivitList.each { tempActivity ->
            highLightedActivitis.add(tempActivity.getActivityId())
        }
        def inputStream = diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis, highLightedFlows, "微软雅黑", "微软雅黑", "微软雅黑", null, 1.0)
//        def inputStream = diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis, highLightedFlows)
        response.getOutputStream().write(inputStream.bytes)
        return "success"
    }


    @RequestMapping("/mytask")
    @ResponseBody
    def Object findAllMyTask() {
        return taskService.createTaskQuery().list()
    }

    @RequestMapping("/startprocess")
    @ResponseBody
    def Object startProcess() {
        runtimeService.startProcessInstanceById(PROCESS_KEY, [userId: 185, pmUserId: 300])
    }

    @RequestMapping(value = "createDey")
    def String create(
            @RequestParam("name") String name,
            @RequestParam("key") String key, @RequestParam(value = "description", required = false) String description,
            HttpServletRequest request, HttpServletResponse response) {
        def parameterMap = request.getParameterMap()
        def Model modelData = null
        try {
            def editorNode = [id: "canvas", resourceId: "canvas", "stencilset": [namespace: "http://b3mn.org/stencilset/bpmn2.0#"]]
            def modelObjectNode = [name: name, "revision": 1, "description": description]
            modelData = repositoryService.newModel()

            modelData.setMetaInfo(objectMapper.writeValueAsString(modelObjectNode))
            modelData.setName(name)
            modelData.setKey(StringUtils.defaultString(key))

            repositoryService.saveModel(modelData)
            repositoryService.addModelEditorSource(modelData.getId(), objectMapper.writeValueAsString(editorNode).getBytes("utf-8"))

        } catch (Exception e) {
            logger.error("创建模型失败：", e);
            return "/error"
        }
        return "redirect:/process-editor/modeler.html?modelId=${modelData.id}"
    }


    private List<String> getHighLightedFlows(
            ProcessDefinitionEntity processDefinitionEntity,
            List<HistoricActivityInstance> historicActivityInstances) {
        List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {// 对历史流程节点进行遍历
            ActivityImpl activityImpl = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i)
                    .getActivityId());// 得到节点定义的详细信息
            List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
            ActivityImpl sameActivityImpl1 = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i + 1)
                    .getActivityId());
            // 将后面第一个节点放在时间相同节点的集合里
            sameStartTimeNodes.add(sameActivityImpl1);
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                HistoricActivityInstance activityImpl1 = historicActivityInstances
                        .get(j);// 后续第一个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances
                        .get(j + 1);// 后续第二个节点
                if (activityImpl1.getStartTime().equals(
                        activityImpl2.getStartTime())) {
                    // 如果第一个节点和第二个节点开始时间相同保存
                    ActivityImpl sameActivityImpl2 = processDefinitionEntity
                            .findActivity(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                } else {
                    // 有不相同跳出循环
                    break;
                }
            }
            List<PvmTransition> pvmTransitions = activityImpl
                    .getOutgoingTransitions();// 取出节点的所有出去的线
            for (PvmTransition pvmTransition : pvmTransitions) {
                // 对所有的线进行遍历
                ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition
                        .getDestination();
                // 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }
        }
        return highFlows;
    }

}
