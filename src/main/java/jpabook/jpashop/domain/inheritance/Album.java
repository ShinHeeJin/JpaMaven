package jpabook.jpashop.domain.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ALBUM")
public class Album extends MasterItem {

    private String artist;

}
