package jpabook.jpashop.domain.shop;

import jpabook.jpashop.domain.inheritance.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;

}
