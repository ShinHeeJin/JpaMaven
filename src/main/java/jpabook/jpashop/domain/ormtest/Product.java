package jpabook.jpashop.domain.ormtest;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "product")
    private List<MemberProduct> memberProducts;
}
