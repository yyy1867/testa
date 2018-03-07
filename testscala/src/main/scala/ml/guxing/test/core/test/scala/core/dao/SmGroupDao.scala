package ml.guxing.test.core.test.scala.core.dao

import java.math.BigInteger

import ml.guxing.test.core.test.scala.core.domain.SmGroup
import ml.guxing.test.scala.core.domain.SmGroup
import org.springframework.data.jpa.repository.JpaRepository

trait SmGroupDao extends JpaRepository[SmGroup, BigInteger] {

}
