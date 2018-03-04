package ml.guxing.activiti;

import org.activiti.engine.ActivitiException;
import org.activiti.rest.editor.main.StencilsetRestResource;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@RequestMapping("/act")
public class StencilsetRestResourceBak extends StencilsetRestResource {


    @RequestMapping(
            value = {"/editor/stencilset"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public String getStencilset() {
        InputStream stencilsetStream = this.getClass().getClassLoader().getResourceAsStream("stencilset.json");

        try {
            return IOUtils.toString(stencilsetStream, "utf-8");
        } catch (Exception var3) {
            throw new ActivitiException("Error while loading stencil set", var3);
        }
    }

}
