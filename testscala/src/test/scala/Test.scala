import ml.guxing.test.scala.core.MyConfig
import ml.guxing.test.scala.core.dao.MmTableDao
import org.junit
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest(classes = Array(classOf[MyConfig]))
class Test() {

  @Autowired val mmTableDao: MmTableDao = null

  @junit.Test
  def test1(): Unit = {
    val tables = mmTableDao.findAll()
//    println(tables.iterator().next())
//    tables.forEach((it) => println(it.name))
  }

}
