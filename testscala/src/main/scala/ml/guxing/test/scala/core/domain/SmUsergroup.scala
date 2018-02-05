package ml.guxing.test.scala.core.domain

import scala.beans.BeanProperty

class SmUsergroup extends SMEntityModel {

  @BeanProperty
  var memo: String = null
  @BeanProperty
  var userId: java.math.BigDecimal = null
  @BeanProperty
  var groupId: java.math.BigDecimal = null

}
