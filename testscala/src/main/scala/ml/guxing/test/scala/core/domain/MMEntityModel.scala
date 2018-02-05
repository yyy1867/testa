package ml.guxing.test.scala.core.domain

import javax.persistence.{Id, MappedSuperclass}

import tk.mybatis.mapper.annotation.Version

import scala.beans.BeanProperty

@MappedSuperclass
trait MMEntityModel extends Serializable {

  @BeanProperty
  @Id
  var id: java.math.BigDecimal = null
  @BeanProperty
  var code: String = null
  @BeanProperty
  var name: String = null
  @BeanProperty
  var creatorId: java.math.BigDecimal = null
  @BeanProperty
  var createDate: java.util.Date = null
  @BeanProperty
  var modifierId: java.math.BigDecimal = null
  @BeanProperty
  var modifyDate: java.util.Date = null

  @BeanProperty
  @Version
  var version: java.math.BigDecimal = null

}
