package ml.guxing.test.core.home.action

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class RestHomeController {

    private val logger: Logger = LoggerFactory.getLogger(RestHomeController::class.java)

    @Autowired
    var client: DiscoveryClient? = null
    @Autowired
    var restTemplate: RestTemplate? = null

    @RequestMapping("")
    fun home(): String {
        return "test ---  ---"
    }

    @RequestMapping("/hello")
    fun helloword(): String {
        var instance = client?.localServiceInstance
        logger.info("/hello,host:${instance?.host},serviceId:${instance?.serviceId}")
        println("====test-kotlin")
        val body = restTemplate?.getForEntity("http://test-kotlin", String::class.java)?.body
        return "Hello Word!!!"
    }

}