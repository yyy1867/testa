package ml.guxing.test.core.test.scala.core.dao

import java.math.BigInteger

import ml.guxing.test.core.test.scala.core.domain.MmTable
import ml.guxing.test.scala.core.domain.MmTable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "tables")
trait MmTableDao extends JpaRepository[MmTable, BigInteger] {

}
