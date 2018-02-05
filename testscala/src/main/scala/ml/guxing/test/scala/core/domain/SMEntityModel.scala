package ml.guxing.test.scala.core.domain

import javax.persistence.{Id, MappedSuperclass}

import tk.mybatis.mapper.annotation.Version

import scala.beans.BeanProperty

@MappedSuperclass
trait SMEntityModel extends Serializable {

  @BeanProperty
  @Id
  var id: java.math.BigDecimal = null
  @BeanProperty
  var code: String = null
  @BeanProperty
  var name: String = null
  @BeanProperty
  var createdate: java.util.Date = null
  @BeanProperty
  var creator: String = null
  @BeanProperty
  var updatedate: java.util.Date = null
  @BeanProperty
  var updater: String = null
  @BeanProperty
  @Version
  var version: java.math.BigDecimal = null

}