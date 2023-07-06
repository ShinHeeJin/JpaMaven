package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER_PRODUCT")
public class MemberProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

}
