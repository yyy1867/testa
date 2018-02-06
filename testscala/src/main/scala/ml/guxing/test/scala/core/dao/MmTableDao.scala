package ml.guxing.test.scala.core.dao

import java.math.BigInteger

import ml.guxing.test.scala.core.domain.MmTable
import org.springframework.data.repository.CrudRepository

trait MmTableDao extends CrudRepository[MmTable, BigInteger] {

}
