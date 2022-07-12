package aptech.t2010a.assignmentspringboot.entity;
import javax.persistence.*;

import aptech.t2010a.assignmentspringboot.entity.base.BaseEntity;
import aptech.t2010a.assignmentspringboot.entity.enums.ProductStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Id
    private String id;
    private String name;
    private String detail;
    private String thumbnails;
    private BigDecimal price;
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
}
