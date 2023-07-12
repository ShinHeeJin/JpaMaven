package jpabook.jpashop.domain.shop;

import jpabook.jpashop.domain.inheritance.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "DELIVERY")
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Order order;

}

