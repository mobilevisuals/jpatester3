import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Gunnar");
        person.setAddress("Lofotengatan 22");
        Main main=new Main();
        main.save(person);
    }

    private void save(Person person) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(person);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
