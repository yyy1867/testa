package ml.guxing.test.core.test.scala.core.gridpage.vo

import scala.beans.BeanProperty

class ColumnInfo {

  @BeanProperty
  var radio: Boolean = false // 是否显示单选框
  @BeanProperty
  var checkbox: Boolean = false // 是否显示多选框
  @BeanProperty
  var field: String = _ // 映射的字段名
  @BeanProperty
  var title: String = _ // 显示的列名
  @BeanProperty
  var titleTooltip: String = _ // 列介绍

}
