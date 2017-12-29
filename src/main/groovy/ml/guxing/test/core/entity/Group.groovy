package ml.guxing.test.core.entity

import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "SM_GROUP")
class Group extends BaseEntity {

    @OneToMany
    Set<User> users;

}
