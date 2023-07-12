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

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            MemberTest member = new MemberTest();
            member.setName("memberA");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            MemberTest findMember = em.find(MemberTest.class, member.getId());

            System.out.println("findMember.getTeam().getClass() = " + findMember.getTeam().getClass()); // proxy

            findMember.getTeam().getName();

            System.out.println("findMember.getTeam().getClass() = " + findMember.getTeam().getClass()); // proxy

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
