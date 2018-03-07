package ml.guxing.test.core.test.scala.core.domain.model

import java.util.Date
import javax.persistence.MappedSuperclass

import scala.beans.BeanProperty

@MappedSuperclass
abstract class SystemModel extends EntityModel {

  @BeanProperty
  var createdate: Date = null
  @BeanProperty
  var creator: String = null
  @BeanProperty
  var updatedate: Date = null
  @BeanProperty
  var updater: String = null

}
