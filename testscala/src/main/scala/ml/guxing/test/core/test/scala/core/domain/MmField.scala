package ml.guxing.test.core.test.scala.core.domain

import javax.persistence.Entity

import ml.guxing.test.scala.core.domain.model.MetaModel

import scala.beans.BeanProperty

@Entity
class MmField extends MetaModel{

 @BeanProperty
 var code:String = _
 @BeanProperty
 var name:String = _
 @BeanProperty
 var tableId:java.math.BigDecimal = _
 @BeanProperty
 var dataTypeId:java.math.BigDecimal = _
 @BeanProperty
 var length:java.math.BigDecimal = _
 @BeanProperty
 var pprecision:java.math.BigDecimal = _
 @BeanProperty
 var isNull:java.math.BigDecimal = _
 @BeanProperty
 var defaultValue:String = _
 @BeanProperty
 var fieldRoleId:java.math.BigDecimal = _
 @BeanProperty
 var isValid:java.math.BigDecimal = _
 @BeanProperty
 var notes:String = _
 @BeanProperty
 var seq:java.math.BigDecimal = _
 @BeanProperty
 var kvColumnCluster:String = _
 @BeanProperty
 var useScopeId:java.math.BigDecimal = _

}
