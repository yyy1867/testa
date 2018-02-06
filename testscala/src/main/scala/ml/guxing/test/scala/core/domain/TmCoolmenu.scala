package ml.guxing.test.scala.core.domain

import java.util
import javax.persistence._

import com.fasterxml.jackson.annotation.JsonIgnore
import ml.guxing.test.scala.core.domain.model.SystemModel

import scala.beans.BeanProperty

@Entity
class TmCoolmenu extends SystemModel {

  @BeanProperty
  var name: String = null
  @BeanProperty
  var code: String = null
  @BeanProperty
  var memo: String = null
  @BeanProperty
  var parentmenuId: java.math.BigDecimal = null
  @BeanProperty
  var url: String = null
  @BeanProperty
  var icon: String = null
  @BeanProperty
  var enable: java.math.BigDecimal = null
  @BeanProperty
  var ordinal: java.math.BigDecimal = null
  @BeanProperty
  var parameters: String = null
  @ManyToOne(cascade = Array(CascadeType.REFRESH))
  @JoinColumn(name = "parentmenuId", insertable = false, updatable = false)
  @BeanProperty
  @JsonIgnore
  var parentmenu: TmCoolmenu = null
  @OneToMany(cascade = Array(CascadeType.REFRESH), mappedBy = "parentmenu")
  @BeanProperty
  var childmenus: util.List[TmCoolmenu] = null
}
