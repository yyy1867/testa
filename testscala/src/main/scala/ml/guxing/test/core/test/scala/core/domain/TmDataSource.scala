package ml.guxing.test.core.test.scala.core.domain

import javax.persistence.Entity

import com.fasterxml.jackson.annotation.JsonIgnore
import ml.guxing.test.scala.core.domain.model.SystemModel

import scala.beans.BeanProperty

@Entity
class TmDataSource extends SystemModel {

  @BeanProperty
  var name: String = _
  @BeanProperty
  var code: String = _
  @BeanProperty
  var memo: String = _
  @BeanProperty
  var url: String = _
  @BeanProperty
  var driverClass: String = _
  @BeanProperty
  var username: String = _
  @JsonIgnore
  @BeanProperty
  var password: String = _

}
