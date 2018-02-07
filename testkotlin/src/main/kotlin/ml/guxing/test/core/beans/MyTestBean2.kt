package ml.guxing.test.core.beans

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class MyTestBean2 {


    @PostConstruct
    fun init() {
        println("bean2 初始化完成 ")
    }

}