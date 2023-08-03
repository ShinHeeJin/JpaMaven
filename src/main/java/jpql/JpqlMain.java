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

            String query = "select m from Member m join fetch m.team";
            List<Member> members = em.createQuery(query, Member.class).getResultList();
            for (Member each : members) {
                System.out.println("each = " + each);
            }

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
