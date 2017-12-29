package ml.guxing.test.core.action

import ml.guxing.test.core.entity.CoolMenu
import ml.guxing.test.core.repository.CoolMenuRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.util.CollectionUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.PostConstruct

@Controller
class BaseAction {

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
}
