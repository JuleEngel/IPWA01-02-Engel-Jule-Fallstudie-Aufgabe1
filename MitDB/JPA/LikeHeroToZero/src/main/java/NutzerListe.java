import java.util.ArrayList;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named
@ApplicationScoped
public class NutzerListe
{
    private List<Nutzer> nutzerListe = new ArrayList<Nutzer>();
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeherotozero");
    private NutzerDAO nutzerDAO = new NutzerDAO();
    
    public NutzerListe()
    {
    	nutzerListe = nutzerDAO.loadList();
    }

    public List<Nutzer> getNutzerListe()
    {
        return nutzerListe;
    }
}