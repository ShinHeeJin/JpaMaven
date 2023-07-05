package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("memberA");
            em.persist(member);

            Team team = new Team();
            team.getMembers().add(member);
            em.persist(team);

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
