package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
@Table(name = "LOCKER")
public class Locker {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
