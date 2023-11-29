package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING) //ORDINAL이면 숫자로 들어감(절대 쓰면 안됨) 꼭 STRING으로 써야 함
    private DeliveryStatus status; // READY, COMP
}
