package ml.guxing.test.core.action

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonSlurper
import org.activiti.bpmn.converter.BpmnXMLConverter
import org.activiti.editor.language.json.converter.BpmnJsonConverter
import org.activiti.engine.*
import org.activiti.engine.impl.ProcessEngineImpl
import org.activiti.engine.repository.Model
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
//        processEngineImpl.getProcessEngineConfiguration().getd
        jsonSlurper = JsonSlurper.newInstance()
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
        def list = repositoryService.createModelQuery().list()
        return list?.collect {
            ["id"       : it.id, "name": it.name, "key": it.key,
             "editUrl"  : "${editUrl}?modelId=${it.id}".toString(),
             "deployUrl": "${deployUrl}?modelId=${it.id}".toString()]
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
        def list = taskService.createTaskQuery().list()
        return list?.collect({
            [id: it.id, name: it.name, processInstanceId: it.processInstanceId, executionId: it.executionId]
        })
//        def types = ["java.lang.String", "int", "boolean", "java.util.Date"]
//        def fields = list[0].getMetaClass().properties.findAll({
//            it["getter"] != null
//        })
//        return list.collect { row ->
//            def map = [:]
//            fields.forEach({
//                try {
//                    map[it.name] = it.getProperty(row)?.toString()
//                } catch (Exception e) {
//
//                }
//            })
//            map
//        }
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

    @RequestMapping("/startProcess")
    @ResponseBody
    def Object startProcess(@RequestParam String processKey) {
        def processInstance = runtimeService.startProcessInstanceByKey(processKey)
        return processInstance
    }

    @RequestMapping("/queryTask")
    @ResponseBody
    def Object queryTask(@RequestParam String taskId) {
        def task = taskService.createTaskQuery().taskId(taskId).singleResult()
        def isFin = historyService.createHistoricProcessInstanceQuery().processDefinitionId(task.processInstanceId).singleResult()
//        if(processInstance.)
        return isFin
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

}
