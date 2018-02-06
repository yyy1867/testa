package ml.guxing.test.scala.core.domain

import javax.persistence.Entity

import ml.guxing.test.scala.core.domain.model.MetaModel

import scala.beans.BeanProperty

@Entity
class MmTable extends MetaModel{

 @BeanProperty
 var code:String = null
 @BeanProperty
 var name:String = null
 @BeanProperty
 var tableTypeId:java.math.BigDecimal = null
 @BeanProperty
 var pkFieldName:String = null
 @BeanProperty
 var entityFieldName:String = null
 @BeanProperty
 var keyFieldName:String = null
 @BeanProperty
 var valueFieldName:String = null
 @BeanProperty
 var isValid:java.math.BigDecimal = null
 @BeanProperty
 var notes:String = null
 @BeanProperty
 var parentId:java.math.BigDecimal = null
 @BeanProperty
 var useScopeId:java.math.BigDecimal = null

}
