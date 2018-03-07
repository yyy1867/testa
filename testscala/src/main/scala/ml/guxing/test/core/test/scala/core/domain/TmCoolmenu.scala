package ml.guxing.test.core.test.scala.core.domain

import java.util
import javax.persistence._

import com.fasterxml.jackson.annotation.JsonIgnore
import ml.guxing.test.scala.core.domain.model.SystemModel

import scala.beans.BeanProperty

@Entity
class TmCoolmenu extends SystemModel {

  @BeanProperty
  var name: String = _
  @BeanProperty
  var code: String = _
  @BeanProperty
  var memo: String = _
  @BeanProperty
  var parentmenuId: java.math.BigDecimal = _
  @BeanProperty
  var url: String = _
  @BeanProperty
  var icon: String = _
  @BeanProperty
  var enable: java.math.BigDecimal = _
  @BeanProperty
  var ordinal: java.math.BigDecimal = _
  @BeanProperty
  var parameters: String = _
  @ManyToOne(cascade = Array(CascadeType.REFRESH))
  @JoinColumn(name = "parentmenuId", insertable = false, updatable = false)
  @BeanProperty
  @JsonIgnore
  var parentmenu: TmCoolmenu = _
  @OneToMany(cascade = Array(CascadeType.REFRESH), mappedBy = "parentmenu")
  @BeanProperty
  var childmenus: util.List[TmCoolmenu] = _
}
