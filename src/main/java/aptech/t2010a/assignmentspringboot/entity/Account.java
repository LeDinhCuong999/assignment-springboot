package aptech.t2010a.assignmentspringboot.entity;

import aptech.t2010a.assignmentspringboot.entity.base.BaseEntity;
import aptech.t2010a.assignmentspringboot.entity.enums.AccountStatus;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "accounts")
public class Account extends BaseEntity {
    @Id
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String thumbnail;
    @Lob
    private String detail;
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;
    private String role;//1.user  |  2.admin
}
