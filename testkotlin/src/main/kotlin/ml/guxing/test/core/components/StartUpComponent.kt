package ml.guxing.test.core.components

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class StartUpComponent : CommandLineRunner {

    @Value("\${server.port}")
    var port: Int = 80

    override fun run(vararg p0: String?) {
        println("http://127.0.0.1:${port}")
    }

}