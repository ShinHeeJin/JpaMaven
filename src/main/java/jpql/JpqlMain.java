package jpql;
import javax.persistence.*;
import java.util.List;

public class JpqlMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("teamA");
            member.setAge(30);
            member.changeTeam(team);
            em.persist(member);

            String query = "SELECT m FROM Member m left join Team t on t.name = m.username";
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
