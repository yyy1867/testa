package ml.guxing.test.core.action

import ml.guxing.test.core.repository.CoolMenuRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class BaseAction {

    def final Logger logger = LoggerFactory.getLogger(BaseAction.class)

    @Autowired
    CoolMenuRepository coolMenuRepository

    @Autowired
    DiscoveryClient discoveryClient

    @RequestMapping(path = ["", "/"])
    def String index() {
        return "home.html"
    }

    @RequestMapping(path = ["/getMenus"])
    def String getRootmenus(Map map) {
        map.rootmenus = coolMenuRepository.findByChildmenusIsNotNull()
        return "menu"
    }

    @RequestMapping("/GetMyMenus")
    @ResponseBody
    def Object getRootmenus() {
        return coolMenuRepository.findByChildmenusIsNotNull()
    }

    @RequestMapping("/listServices")
    @ResponseBody
    def Object listServices() {
        def instance = discoveryClient.localServiceInstance
        return discoveryClient.getServices()
    }

}
