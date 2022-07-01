package aptech.t2010a.assignmentspringboot.entity;

import aptech.t2010a.assignmentspringboot.entity.base.BaseEntity;
import com.sun.corba.se.spi.activation.InvalidORBidHelper;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

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
    private UUID id;
    private String name;

}
