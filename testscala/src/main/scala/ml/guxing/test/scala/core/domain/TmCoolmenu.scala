package ml.guxing.test.scala.core.domain

import scala.beans.BeanProperty

class TmCoolmenu extends SMEntityModel {

  @BeanProperty
  var memo: String = null
  @BeanProperty
  var parentmenuId: java.math.BigDecimal = null
  @BeanProperty
  var url: String = null
  @BeanProperty
  var icon: String = null
  @BeanProperty
  var enable: java.math.BigDecimal = null
  @BeanProperty
  var ordinal: java.math.BigDecimal = null
  @BeanProperty
  var parameters: String = null

}
