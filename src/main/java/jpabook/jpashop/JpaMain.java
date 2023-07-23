package jpabook.jpashop;

import jpabook.jpashop.domain.inheritance.Book;
import jpabook.jpashop.domain.inheritance.Movie;
import jpabook.jpashop.domain.ormtest.MemberTest;
import jpabook.jpashop.domain.ormtest.Team;
import jpabook.jpashop.domain.shop.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setName("memberA");
            member.getFavoriteFoods().add("바나나");
            member.getFavoriteFoods().add("딸기");
            em.persist(member);

            Set<String> favoriteFoods = member.getFavoriteFoods();
            System.out.println("favoriteFoods = " + favoriteFoods);

            em.flush();
            em.clear();

            Member member1 = em.find(Member.class, 1L);
            member1.getFavoriteFoods().remove("딸기");
            Set<String> favoriteFoods1 = member1.getFavoriteFoods();
            System.out.println("favoriteFoods1 = " + favoriteFoods1);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
