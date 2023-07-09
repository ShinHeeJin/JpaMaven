package jpabook.jpashop.domain.ormtest;

import jpabook.jpashop.domain.ormtest.Locker;
import jpabook.jpashop.domain.ormtest.MemberProduct;
import jpabook.jpashop.domain.ormtest.Team;
import jpabook.jpashop.domain.shop.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER_TEST")
public class MemberTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "name")
    private String name;

    private String city;
    private String street;
    private String zipcode;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "memberTest")
    private List<MemberProduct> memberProducts;

    public void changeTeam(Team team) {
        this.team = team;
        team.getMemberTests().add(this);
    }

}
