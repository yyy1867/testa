package ml.guxing.test.scala.core.domain

import javax.persistence.Entity

import ml.guxing.test.scala.core.domain.model.SystemModel

import scala.beans.BeanProperty

@Entity
class SmGroup extends SystemModel{

 @BeanProperty
 var name:String = null
 @BeanProperty
 var code:String = null
 @BeanProperty
 var memo:String = null
 @BeanProperty
 var locationId:java.math.BigDecimal = null

}
