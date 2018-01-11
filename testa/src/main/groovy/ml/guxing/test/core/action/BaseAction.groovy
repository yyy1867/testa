package ml.guxing.test.core.action

import ml.guxing.test.core.repository.CoolMenuRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class BaseAction {

    @Value("\${testname}")
    String testname;

    @Autowired
    CoolMenuRepository coolMenuRepository

    @RequestMapping(path = ["", "/"])
    def String index() {
        return "home.html"
    }

    @RequestMapping(path = ["/getMenus"])
    def String getRootmenus(Map map) {
        map.rootmenus = coolMenuRepository.findByChildmenusIsNotNull()
        return "menu"
    }

    @RequestMapping("/getTestName")
    @ResponseBody
    def String getTestName() {
        return testname
    }
}
