package ml.guxing.test.scala.core.dao

import java.math.BigInteger

import ml.guxing.test.scala.core.domain.MmField
import org.springframework.data.repository.CrudRepository

trait MmFieldDao extends CrudRepository[MmField, BigInteger] {

}
