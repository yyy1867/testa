package ml.guxing.test.scala.core.action

import ml.guxing.test.scala.core.mapper.TmCoolmenuMapper
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController(val tmCoolmenuMapper: TmCoolmenuMapper) {

  @RequestMapping(Array("/home"))
  def home(model: Model): String = {
    // 先判断登录的用户

    // 根据用户查看权限

    // 根据权限搜锁出菜单

    // 添加菜单,用户,权限
    model.addAttribute("menus", tmCoolmenuMapper.selectAll())
    "base"
  }

}
