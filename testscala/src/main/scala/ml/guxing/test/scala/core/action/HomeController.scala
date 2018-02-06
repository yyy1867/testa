package ml.guxing.test.scala.core.action

import java.math.BigInteger

import ml.guxing.test.scala.core.dao.TmCoolmenuDao
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController(val tmCoolmenuDao: TmCoolmenuDao) {

  @RequestMapping(Array(""))
  def list(model: Model): String = {
    val list = tmCoolmenuDao.findByIds(Array(BigInteger.valueOf(1)))
    model.addAttribute("aaaa", "aaaasada")
    model.addAttribute("menus", list)
    "base"
  }

}
