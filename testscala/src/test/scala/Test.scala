import ml.guxing.test.scala.core.MyConfig
import ml.guxing.test.scala.core.mapper.MmTableMapper
import org.junit
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import scala.beans.BeanProperty
import scala.collection.JavaConversions._
import scala.util.parsing.json.JSON

@RunWith(classOf[SpringRunner])
@SpringBootTest(classes = Array(classOf[MyConfig]))
class Test() {

  @Autowired val mmTableMapper: MmTableMapper = null

  @junit.Test
  def test1(): Unit = {
    val tables = mmTableMapper.selectAll()
    tables.map((it) => println(it.name))
  }

}
