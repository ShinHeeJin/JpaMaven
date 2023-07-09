package jpabook.jpashop.domain.ormtest;

import jpabook.jpashop.domain.inheritance.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<MemberTest> memberTests = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberTest> getMemberTests() {
        return memberTests;
    }

    public void setMemberTests(List<MemberTest> memberTests) {
        this.memberTests = memberTests;
    }
}
