package aptech.t2010a.assignmentspringboot.entity;

import aptech.t2010a.assignmentspringboot.entity.base.BaseEntity;
import aptech.t2010a.assignmentspringboot.entity.enums.OrderSimpleStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    private String id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_id")
    @JsonManagedReference
    private Account account;
    private BigDecimal totalPrice;
    @Enumerated(EnumType.ORDINAL)
    private OrderSimpleStatus status;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;
    private boolean isShoppingCart;

    public void calculateTotalPrice() {
        this.totalPrice = new BigDecimal(0);
        if (this.orderDetails != null && this.orderDetails.size() > 0) {
            for (OrderDetail orderDetail :
                    orderDetails) {
                BigDecimal orderDetailTotalPrice = orderDetail.getUnitPrice().multiply(new BigDecimal(orderDetail.getQuantity()));
                this.totalPrice = this.totalPrice.add(orderDetailTotalPrice);
            }
        }
    }
}
