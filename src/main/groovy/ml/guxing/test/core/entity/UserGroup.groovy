package ml.guxing.test.core.entity

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "SM_USERGROUP")
class UserGroup {

    User user
    Group group

}
