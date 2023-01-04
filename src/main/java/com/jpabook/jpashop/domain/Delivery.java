package com.jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY) //주문 - 배송 (1:1)
    private Order order;

    @Embedded // 내장타입 어노테이션
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //배송상태 [READY, COMP]

}
