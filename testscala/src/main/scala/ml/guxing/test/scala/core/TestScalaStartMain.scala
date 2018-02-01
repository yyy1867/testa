package ml.guxing.test.scala.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import scala.collection.JavaConversions._

@SpringBootApplication
class MyConfig

object TestScalaStartMain {

  def main(args: Array[String]): Unit = {
    val app = new SpringApplication(classOf[MyConfig])
    app.run(args: _*)
  }

}
