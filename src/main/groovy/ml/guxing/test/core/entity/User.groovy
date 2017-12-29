package ml.guxing.test.core.entity

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "SM_USER")
class User extends BaseEntity {
    int active;
    Date expireddate;// 用户到期时间
    Date passwordexpireddate;// 密码到期时间
    String mobilephone;// 手机号码
    String officephone;// 座机号码
    String mailbox;// 邮箱
    String contactaddress;// 工作地址
    String postalcode;// 邮政编码
    String detailinformation;// 介绍
}
