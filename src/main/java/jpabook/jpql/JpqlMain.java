package jpabook.jpql;
import javax.persistence.*;
import java.util.List;

public class JpqlMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("memberA");
            member.setAge(31);
            em.persist(member);

            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
            Query query3 = em.createQuery("select m.username, u.age from Member m");

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
