package ml.guxing.test.scala.core.gridpage.vo

import scala.beans.BeanProperty

class TableInfo {

  @BeanProperty
  var classes: String = "table table-hover" //表格的类名称,可以使用table-no-bordered来删除边框样式
  @BeanProperty
  var sortClass: String = _ //排序td的类名称
  @BeanProperty
  var height: Int = _ // 表格的高度
  @BeanProperty
  var undefinedText: String = "-" // 没有内容时显示的字符
  @BeanProperty
  var striped: Boolean = false // 斑马线
  @BeanProperty
  var sortName: String = _ // 排序列的名称
  @BeanProperty
  var sortOrder: String = "asc" // 排序方式
  @BeanProperty
  var sortStable: Boolean = false // 设置为 true 将获得稳定的排序，我们会添加_position属性到 row 数据中
  @BeanProperty
  var columns: Array[ColumnInfo] = Array() // 列配置
  @BeanProperty
  var method: String = "get" // 请求数据的方式
  @BeanProperty
  var url: String = _ // 请求数据的url
  @BeanProperty
  var cache: Boolean = true // 是否禁用缓存
  @BeanProperty
  var queryParams: String = _ // 获取参数的方法
  @BeanProperty
  var queryParamsType: String = "limit" // 设置为 'limit' 则会发送符合 RESTFul 格式的参数
  @BeanProperty
  var pagination: Boolean = false // 显示底部的分页条
  @BeanProperty
  var paginationLoop: Boolean = true // 循环滚动分页
  @BeanProperty
  var onlyInfoPagination: Boolean = false // 只显示总数据数,不显示分页按钮
  @BeanProperty
  var sidePagination: String = "client" // 设置在哪里进行分页,可选值为'client' 和 'server'
  @BeanProperty
  var showHeader: Boolean = true // 是否显示列头
  @BeanProperty
  var showFooter: Boolean = false // 是否显示列脚
  @BeanProperty
  var showRefresh: Boolean = false // 是否显示刷新按钮
  @BeanProperty
  var showToggle: Boolean = false // 是否显示切换视图按钮

}
