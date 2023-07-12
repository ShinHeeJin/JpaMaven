package jpabook.jpashop.domain.ormtest;

import jpabook.jpashop.domain.shop.Member;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER_PRODUCT")
public class MemberProduct {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_TEST_ID")
    private MemberTest memberTest;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

}
