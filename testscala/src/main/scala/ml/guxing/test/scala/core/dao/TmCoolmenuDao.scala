package ml.guxing.test.scala.core.dao

import java.math.BigInteger
import java.util

import ml.guxing.test.scala.core.domain.TmCoolmenu
import org.springframework.data.jpa.repository.{JpaRepository, Query}
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "menus")
trait TmCoolmenuDao extends JpaRepository[TmCoolmenu, BigInteger] {

  @Query(value = "SELECT * FROM TM_COOLMENU WHERE ID IN (?1)", nativeQuery = true)
  def findByIds(ids: Array[BigInteger]): util.List[TmCoolmenu]

}
