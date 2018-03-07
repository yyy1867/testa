package ml.guxing.test.core.home.action

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


@RestController("/hystrix")
open class HystrixController {

    @Autowired
    var baseActionController: BaseActionController? = null
    @Autowired
    var restTemplate: RestTemplate? = null

    @RequestMapping("/")
    fun home(): String {
        return "该接口处理熔断器逻辑,同时使用Feign作为服务调用"
    }

    @RequestMapping("/list")
    @HystrixCommand(fallbackMethod = "error")
    fun clientListServicce(): String? {
//        var services = baseActionController?.getListServices()
        var services = restTemplate?.getForObject("http://GROOVY/listServices", String::class.java)
        return services
    }

    fun error(): String {
        println("请求失败")
        return "请求失败,服务可能失效"
    }

}

@FeignClient("test-groovy")
interface BaseActionController {
    @GetMapping("")
    fun index(): String

    @GetMapping("/getMenus")
    fun getRootmenus(): String

    @GetMapping("/listServices")
    fun getListServices(): String
}
