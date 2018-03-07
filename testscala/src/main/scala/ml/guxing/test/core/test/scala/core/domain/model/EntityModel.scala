package ml.guxing.test.core.test.scala.core.domain.model

import java.math.BigInteger
import javax.persistence.{Id, MappedSuperclass, Version}

import scala.beans.BeanProperty

@MappedSuperclass
abstract class EntityModel {

  @Id
  @BeanProperty
  var id: BigInteger = null
  @Version
  @BeanProperty
  var version: Integer = null

}
