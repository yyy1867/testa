package ml.guxing.test.core.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {

    @RequestMapping("/helloword")
    public String helloword() {
        return "Hello Word";
    }

}
