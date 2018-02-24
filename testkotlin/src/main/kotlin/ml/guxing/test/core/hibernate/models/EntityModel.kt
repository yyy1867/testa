package ml.guxing.test.core.hibernate.models

import java.math.BigInteger
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
open class EntityModel {

    @Id
    var id: BigInteger? = null
    @Version
    var version: Int? = null

}