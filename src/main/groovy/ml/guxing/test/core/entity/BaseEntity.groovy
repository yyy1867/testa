package ml.guxing.test.core.entity

import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
class BaseEntity {
    @Id
    BigDecimal id
    String name
    String code
    String memo
    Integer version
    Date createdate
    String creator
    String updatedate
    String updater
}
