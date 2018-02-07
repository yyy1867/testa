package ml.guxing.test.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class MyConfig

object TestKotlinMain {

    @JvmStatic
    fun main(args: Array<String>) {
//        val applicationContext = ClassPathXmlApplicationContext("classpath:application-beans.xml")
        SpringApplication.run(MyConfig::class.java)
        println("===   ===")
    }

}