package ml.guxing.test.core.hibernate.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.Entity
import javax.persistence.MappedSuperclass
import javax.persistence.Table

@MappedSuperclass
open class SystemModel : EntityModel() {
    var createor: String? = null
    var createDate: Date? = null
    var updater: String? = null
    var updateDate: Date? = null
}

@MappedSuperclass
open class SystemEntity : SystemModel() {
    var code: String? = null
    var name: String? = null
    var memo: String? = null
}

@Entity
@Table(name = "TM_DATASOURCE")
open class DataSource : SystemEntity() {
    var url: String? = null
    var driverClass: String? = null
    var username: String? = null
    @JsonIgnore
    var password: String? = null
}