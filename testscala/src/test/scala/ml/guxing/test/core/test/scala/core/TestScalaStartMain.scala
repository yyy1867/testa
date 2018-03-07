package ml.guxing.test.core.test.scala.core

//import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
//@MapperScan("")
class MyConfig

object TestScalaStartMain {

  def main(args: Array[String]): Unit = {
    val app = new SpringApplication(classOf[MyConfig])
    app.run(args: _*)
  }

}
