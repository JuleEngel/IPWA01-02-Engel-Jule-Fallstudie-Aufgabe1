import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmissionDAO {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeherotozero");
    
    public List<Emission> loadList() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select e from Emission e");
        return q.getResultList();
    }
    
    public void deleteEmission(Emission emission) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
            Emission entityToDelete = em.find(Emission.class, emission.getCountry());
            if(entityToDelete != null) {
                em.remove(entityToDelete);
            }
        t.commit();
    }
    
    public void updateEmission(Emission emission) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
            Emission entityToUpdate = em.find(Emission.class, emission.getCountry());
            if(entityToUpdate != null) {
                em.merge(emission);
            }
        t.commit();
    }
    
    public void createEmission(Emission neueEmission) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
            Emission neueEmissionEntity = new Emission();

            neueEmissionEntity.setCountry(neueEmission.getCountry());
            neueEmissionEntity.setYear2018(neueEmission.getYear2018());
            neueEmissionEntity.setYear2019(neueEmission.getYear2019());
            neueEmissionEntity.setYear2020(neueEmission.getYear2020());
            neueEmissionEntity.setYear2021(neueEmission.getYear2021());
            em.persist(neueEmissionEntity);
        t.commit();
    }
}
