package jpabook.jpashop.domain.ormtest;

import jpabook.jpashop.domain.shop.Member;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "MEMBER_PRODUCT")
public class MemberProduct {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_TEST_ID")
    private MemberTest memberTest;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

}
