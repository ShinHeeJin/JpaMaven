package jpabook.jpashop.domain.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie extends MasterItem{

    private String director;
    private String actor;


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
