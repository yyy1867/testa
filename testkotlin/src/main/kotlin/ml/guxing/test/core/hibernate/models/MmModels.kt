package ml.guxing.test.core.hibernate.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigInteger
import java.util.*
import java.util.List
import javax.persistence.*
import javax.persistence.Table

@MappedSuperclass
open class MetaModel : EntityModel() {
    var code: String? = null
    var name: String? = null
    var createorId: BigInteger? = null
    var createorDate: Date? = null
    var modifierId: BigInteger? = null
    var modifierDate: Date? = null
}

@Entity
@Table(name = "MM_TABLE")
open class Table : MetaModel() {
    var tableTypeId: BigInteger? = null
    var pkFieldName: String? = null
    var entityFieldName: String? = null
    var keyFieldName: String? = null
    var valueFieldName: String? = null
    var isValid: BigInteger? = null
    var notes: String? = null
    var parentId: BigInteger? = null
    var useScopeId: BigInteger? = null
    @ManyToOne(cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "parentId", insertable = false, updatable = false)
    var parentTable: ml.guxing.test.core.hibernate.models.Table? = null
    @OneToMany(cascade = [CascadeType.REFRESH], mappedBy = "parentTable")
    @JsonIgnore
    var childTables: List<ml.guxing.test.core.hibernate.models.Table>? = null
}