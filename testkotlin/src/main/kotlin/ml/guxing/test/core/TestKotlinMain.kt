package ml.guxing.test.core

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class MyConfig

object TestKotlinMain {

    @JvmStatic
    fun main(args: Array<String>) {
//        SpringApplication.run(MyConfig::class.java)
        println("===  程序已启动  ===")
    }

}