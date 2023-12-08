import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class NutzerDAO {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeherotozero");
    
    public List<Nutzer> loadList() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select n from Nutzer n");
        return q.getResultList();
    }
}
