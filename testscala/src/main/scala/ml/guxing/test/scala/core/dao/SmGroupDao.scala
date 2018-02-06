package ml.guxing.test.scala.core.dao

import java.math.BigInteger

import ml.guxing.test.scala.core.domain.SmGroup
import org.springframework.data.repository.CrudRepository

trait SmGroupDao extends CrudRepository[SmGroup, BigInteger] {

}
