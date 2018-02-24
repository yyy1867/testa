package ml.guxing.test.scala.core.dao

import java.math.BigInteger

import ml.guxing.test.scala.core.domain.TmDataSource
import org.springframework.data.jpa.repository.JpaRepository

trait TmDataSourceDao extends JpaRepository[TmDataSource, BigInteger] {

}