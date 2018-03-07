package ml.guxing.test.core.test.scala.core.domain.model

import java.math.BigInteger
import java.util.Date
import javax.persistence.MappedSuperclass

import scala.beans.BeanProperty

@MappedSuperclass
abstract class MetaModel extends EntityModel {

  @BeanProperty
  var creatorId: BigInteger = null
  @BeanProperty
  var createDate: Date = null
  @BeanProperty
  var modifierId: BigInteger = null
  @BeanProperty
  var modifyDate: Date = null

}
