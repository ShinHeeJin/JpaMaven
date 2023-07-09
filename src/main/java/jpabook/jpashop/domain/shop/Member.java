package jpabook.jpashop.domain.shop;

import jpabook.jpashop.domain.ormtest.Locker;
import jpabook.jpashop.domain.ormtest.MemberProduct;
import jpabook.jpashop.domain.ormtest.Team;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "name")
    private String name;

    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
