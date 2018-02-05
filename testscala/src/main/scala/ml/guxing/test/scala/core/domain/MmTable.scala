package ml.guxing.test.scala.core.domain

import javax.persistence.Table

import scala.beans.BeanProperty

@Table(name = "MM_TABLE")
class MmTable extends MMEntityModel {

  @BeanProperty
  var tableTypeId: java.math.BigDecimal = null
  @BeanProperty
  var pkFieldName: String = null
  @BeanProperty
  var entityFieldName: String = null
  @BeanProperty
  var keyFieldName: String = null
  @BeanProperty
  var valueFieldName: String = null
  @BeanProperty
  var isValid: java.math.BigDecimal = null
  @BeanProperty
  var notes: String = null
  @BeanProperty
  var parentId: java.math.BigDecimal = null
  @BeanProperty
  var useScopeId: java.math.BigDecimal = null

}
