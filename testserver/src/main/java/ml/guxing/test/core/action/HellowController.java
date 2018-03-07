package ml.guxing.test.core.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HellowController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/helloword")
    public String helloword() {
        return "Hello Word";
    }

}
