package jpabook.jpashop.domain.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ALBUM")
@DiscriminatorValue("A")
public class Album extends MasterItem {

    private String artist;

}
