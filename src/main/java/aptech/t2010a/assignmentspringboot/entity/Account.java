package aptech.t2010a.assignmentspringboot.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "accounts")
public class Account {
    @Id
    private int id;
    private String username;
    private String passwordHash;
    private int role; //1.user  |  2.admin
}
