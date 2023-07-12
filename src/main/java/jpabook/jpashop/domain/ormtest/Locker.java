package jpabook.jpashop.domain.ormtest;

import javax.persistence.*;

@Entity
@Table(name = "LOCKER")
public class Locker {

    @Id @GeneratedValue
    private Long id;
    private String name;
}
