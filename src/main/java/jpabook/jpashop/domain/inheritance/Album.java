package jpabook.jpashop.domain.inheritance;

import javax.persistence.Entity;

@Entity
public class Album extends Item {

    private String artist;

}
