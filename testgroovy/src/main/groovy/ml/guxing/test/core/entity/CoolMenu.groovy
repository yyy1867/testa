package ml.guxing.test.core.entity
import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.*

@Entity
@Table(name = "TM_COOLMENU")
class CoolMenu extends BaseEntity {
    String url
    String icon
    Integer enable
    Integer ordinal
    String parameters
    @ManyToOne(cascade = [CascadeType.REFRESH, CascadeType.REMOVE], optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENTMENU_ID", referencedColumnName = "ID")
    @JsonIgnore
    CoolMenu parentmenu
    @OneToMany(cascade = [CascadeType.REFRESH], mappedBy = "parentmenu", fetch = FetchType.EAGER)
    List<CoolMenu> childmenus
}
