package ml.guxing.test.core.repository

import ml.guxing.test.core.entity.CoolMenu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoolMenuRepository extends JpaRepository<CoolMenu, BigDecimal> {

}