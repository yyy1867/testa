package ml.guxing.test.core.test.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
//@EnableEurekaClient
class TestAStartMain {

    static void main(String[] args) {
        args = ["--spring.config.location=D:\\source\\testa\\testgroovy\\src\\test\\resources\\dev.properties"]
        def application = new SpringApplication()
        application.run(TestAStartMain.class, args)
    }
}
