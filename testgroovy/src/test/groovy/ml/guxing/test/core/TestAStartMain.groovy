package ml.guxing.test.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class TestAStartMain {

    static void main(String[] args) {
        def application = new SpringApplication()
        application.run(TestAStartMain.class, args)
    }
}
