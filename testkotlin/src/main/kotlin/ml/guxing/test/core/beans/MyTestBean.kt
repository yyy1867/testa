package ml.guxing.test.core.beans

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class MyTestBean : CommandLineRunner {

    override fun run(vararg p0: String?) {
        var i = 0
        while (i < 3) {
            println(" 成功开启测试 ${p0 ?: "没有值"} i:${i++}")
            Thread.sleep(3000)
        }
    }

    @PostConstruct
    fun init() {
        println("bean 初始化完成 ")
    }

}