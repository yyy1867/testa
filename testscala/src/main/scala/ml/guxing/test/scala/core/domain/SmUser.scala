package ml.guxing.test.scala.core.domain

import javax.persistence.Entity

import ml.guxing.test.scala.core.domain.model.SystemModel

import scala.beans.BeanProperty

@Entity
class SmUser extends SystemModel {

  @BeanProperty
  var name: String = null
  @BeanProperty
  var code: String = null
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
