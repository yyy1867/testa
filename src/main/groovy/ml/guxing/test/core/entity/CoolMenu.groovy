package ml.guxing.test.core.entity

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.*

@Entity
@Table(name = "TM_COOLMENU")
class CoolMenu extends BaseEntity {
//    BigDecimal parentmenuId
    String url
    String icon
    Integer enable
    Integer ordinal
    String parameters
    @ManyToOne(cascade = [CascadeType.REFRESH, CascadeType.REMOVE], optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENTMENU_ID", referencedColumnName = "ID")
    CoolMenu parentmenu
    @OneToMany(cascade = [CascadeType.REFRESH], mappedBy = "parentmenu", fetch = FetchType.EAGER)
    @JsonIgnore
    List<CoolMenu> childmenus
}
