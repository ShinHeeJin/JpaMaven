package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpqlMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Team team1 = new Team();
            team1.setName("teamA");
            em.persist(team1);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Member member = new Member();
            member.setUsername("memberA");
            member.setAge(30);
            member.changeTeam(team1);
            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("memberB");
            member2.setAge(30);
            member2.changeTeam(team2);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("memberC");
            member3.setAge(30);
            member3.changeTeam(team2);
            em.persist(member3);

            Member member4 = new Member();
            member4.setUsername("memberD");
            member4.setAge(30);
            em.persist(member4);

            // FLUSH 자동 호출
            int resultCnt = em.createQuery("update Member m  set m.age = 20")
                    .executeUpdate();
            System.out.println("resultCnt = " + resultCnt);
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            System.out.println("findMember.getAge() = " + findMember.getAge());

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
