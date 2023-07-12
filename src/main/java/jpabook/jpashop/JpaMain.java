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

            Team team1 = new Team();
            team1.setName("teamB");
            em.persist(team1);

            MemberTest member = new MemberTest();
            member.setName("memberA");
            member.setTeam(team);
            em.persist(member);

            MemberTest member2 = new MemberTest();
            member2.setName("memberB");
            member2.setTeam(team1);
            em.persist(member2);

            em.flush();
            em.clear();

            List<MemberTest> results = em.createQuery("select m from MemberTest m", MemberTest.class)
                    .getResultList(); // N+1 이슈
            System.out.println("results = " + results);
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
