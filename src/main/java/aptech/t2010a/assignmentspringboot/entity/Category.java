package aptech.t2010a.assignmentspringboot.entity;

import aptech.t2010a.assignmentspringboot.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "categories")
public class Category extends BaseEntity {

    @Id
    private String id;
    private String name;

}
