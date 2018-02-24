package ml.guxing.test.core.hibernate.dao

import ml.guxing.test.core.hibernate.models.DataSource
import ml.guxing.test.core.hibernate.models.Table
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.math.BigInteger

@RepositoryRestResource(path = "/table")
interface TableDao : JpaRepository<Table, BigInteger>

@RepositoryRestResource(path = "/dataSource")
interface DataSourceDao : JpaRepository<DataSource, BigInteger>