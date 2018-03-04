package ml.guxing.activiti.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import groovy.json.JsonSlurper;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.rest.editor.model.ModelSaveRestResource;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/act")
public class ModelSaveRestResourceBak extends ModelSaveRestResource {


    protected static final Logger LOGGER = LoggerFactory.getLogger(ModelSaveRestResourceBak.class);
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(
            value = {"/model/{modelId}/save"}
    )
    @ResponseStatus(HttpStatus.OK)
    public void saveModel(@PathVariable String modelId, @RequestBody String json) {
        try {
            Map<String, String> map = (Map<String, String>) new JsonSlurper().parseText(json);
            Model model = this.repositoryService.getModel(modelId);
            ObjectNode modelJson = (ObjectNode) this.objectMapper.readTree(model.getMetaInfo());
            modelJson.put("name", map.get("name"));
            modelJson.put("description", map.get("description"));
            model.setMetaInfo(modelJson.toString());
            model.setName(map.get("name"));
            this.repositoryService.saveModel(model);
            this.repositoryService.addModelEditorSource(model.getId(), (map.get("json_xml")).getBytes("utf-8"));
            InputStream svgStream = new ByteArrayInputStream((map.get("svg_xml")).getBytes("utf-8"));
            TranscoderInput input = new TranscoderInput(svgStream);
            PNGTranscoder transcoder = new PNGTranscoder();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            TranscoderOutput output = new TranscoderOutput(outStream);
            transcoder.transcode(input, output);
            byte[] result = outStream.toByteArray();
            this.repositoryService.addModelEditorSourceExtra(model.getId(), result);
            outStream.close();
        } catch (Exception var11) {
            LOGGER.error("Error saving model", var11);
            throw new ActivitiException("Error saving model", var11);
        }
    }

    @GetMapping("/model/{modelId}/delpoy")
    public String delpoyModel(@PathVariable String modelId) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            Model model = this.repositoryService.getModel(modelId);
            JsonNode jsonNode = objectMapper.readTree(repositoryService.getModelEditorSource(model.getId()));
            BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(jsonNode);
            byte[] bytes = new BpmnXMLConverter().convertToXML(bpmnModel);
            String processName = model.getName() + ".bpmn20.xml";
            saveFile(processName, bytes);
            Deployment deployment = repositoryService.createDeployment()
                    .name(model.getName())
                    .addString(processName, new String(bytes)).deploy();
        } catch (Exception var11) {
            LOGGER.error("Error saving model", var11);
            throw new ActivitiException("Error saving model", var11);
        }
        return "部署成功";
    }

    private void saveFile(String fileName, byte[] bytes) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(bytes);
            stream.close();
            System.out.println(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
