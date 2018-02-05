package ml.guxing.test.scala.core.access.mybaits

import java.math.BigInteger

trait BasicAccessService[T] {

  def findById(id: BigInteger): T

  def findByIds(ids: Array[BigInteger]): Seq[T]

  def findAll(): Seq[T]

  def update(model: T): T

  def remove(model: T): T

  def save(model: T): T

  def saveList(model: Seq[T]): Seq[T]

  def removeList(model: Seq[T]): Seq[T]

}
