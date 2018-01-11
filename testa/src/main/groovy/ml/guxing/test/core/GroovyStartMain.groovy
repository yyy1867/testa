package ml.guxing.test.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class GroovyStartMain {

    static void main(String[] args) {
        def application = new SpringApplication()
        application.run(GroovyStartMain.class, args)
    }
}
