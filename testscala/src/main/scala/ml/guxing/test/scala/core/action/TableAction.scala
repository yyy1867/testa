package ml.guxing.test.scala.core.action

import ml.guxing.test.scala.core.mapper.MmTableMapper
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
class TableAction(val mmTableMapper: MmTableMapper) {

  @RequestMapping(Array("/list"))
  def list(): Any = {
    mmTableMapper.selectAll()
  }

}
