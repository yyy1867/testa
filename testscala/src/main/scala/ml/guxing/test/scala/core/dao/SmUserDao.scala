package ml.guxing.test.scala.core.dao

import java.math.BigInteger

import ml.guxing.test.scala.core.domain.SmUser
import org.springframework.data.jpa.repository.JpaRepository

trait SmUserDao extends JpaRepository[SmUser, BigInteger] {

}
