package ml.guxing.test.scala.core.domain

import scala.beans.BeanProperty

class SmUser extends SMEntityModel {

  @BeanProperty
  var memo: String = null
  @BeanProperty
  var username: String = null
  @BeanProperty
  var password: String = null
  @BeanProperty
  var active: java.math.BigDecimal = null
  @BeanProperty
  var expireddate: java.util.Date = null
  @BeanProperty
  var passwordexpireddate: java.util.Date = null
  @BeanProperty
  var mobilephone: String = null
  @BeanProperty
  var officephone: String = null
  @BeanProperty
  var mailbox: String = null
  @BeanProperty
  var contactaddress: String = null
  @BeanProperty
  var postalcode: String = null
  @BeanProperty
  var detailinformation: String = null

}
