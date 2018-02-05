package ml.guxing.test.scala.core.access.mybaits.Impl

import java.math.BigInteger

import ml.guxing.test.scala.core.access.mybaits.BasicAccessService
import tk.mybatis.mapper.common.Mapper

import scala.collection.JavaConversions._

abstract class MyBaitsAccessServiceImpl[T, J <: Mapper[T]] extends BasicAccessService[T] {

  var mapper: J

  override def findById(id: BigInteger): T = mapper.selectByPrimaryKey(id)

  override def findByIds(ids: Array[BigInteger]): Seq[T] = ???

  override def findAll(): Seq[T] = mapper.selectAll()

  override def update(model: T): T = {
    val rst = mapper.updateByPrimaryKey(model)
    if (rst == 0) {
      throw new RuntimeException("修改失败!")
    }
    model
  }

  override def remove(model: T): T = {
    val rst = mapper.deleteByPrimaryKey(model)
    if (rst == 0) {
      throw new RuntimeException("修改失败!")
    }
    model
  }

  override def save(model: T): T = ???

  override def saveList(model: Seq[T]): Seq[T] = ???

  override def removeList(model: Seq[T]): Seq[T] = ???
}
