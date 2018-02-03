package ml.guxing.test.scala.core.action

import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
class TestController {

  @RequestMapping(Array(""))
  def test(): String = {
    "test ----"
  }

}
