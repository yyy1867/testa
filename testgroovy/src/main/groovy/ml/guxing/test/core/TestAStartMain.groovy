package ml.guxing.test.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
//@EnableEurekaClient
class TestAStartMain {

    static void main(String[] args) {
//        args = ["--spring.config.location=D:\\source\\testa\\testgroovy\\src\\test\\resources\\dev.properties"]
        def application = new SpringApplication()
        application.run(TestAStartMain.class, args)
    }
}
