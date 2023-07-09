package jpabook.jpashop;

import jpabook.jpashop.domain.inheritance.Movie;
import jpabook.jpashop.domain.shop.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();

            member.setName("member");
            member.setCity("cityA");
            member.setStreet("street");
            member.setZipcode("1111");
            
            member.setCreateMember("memberA");
            member.setCreatedAt(LocalDateTime.now());
            member.setLastModifiedBy("memberB");
            member.setLastModifiedAt(LocalDateTime.now());

            em.persist(member);
            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e) {
            System.out.println("e : " + e.toString());
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
