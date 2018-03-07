package ml.guxing.test.core

import org.springframework.boot.SpringApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
//@SpringBootApplication
@SpringCloudApplication
open class MyConfig {

    @Bean
    @LoadBalanced
    open fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}

object TestKotlinMain {

    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(MyConfig::class.java, *args)
    }

}