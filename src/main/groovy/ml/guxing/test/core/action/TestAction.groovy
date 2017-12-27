package ml.guxing.test.core.action

import ml.guxing.test.core.repository.CoolMenuRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class TestAction {

    @Autowired
    CoolMenuRepository coolMenuRepository

    @RequestMapping("")
    def String index(Map<String, Object> map) {
        map.put("rootmenus",coolMenuRepository.findAll())
        return "index"
    }

}
