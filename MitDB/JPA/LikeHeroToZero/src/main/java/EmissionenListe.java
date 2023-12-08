import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named
@ApplicationScoped
public class EmissionenListe
{
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeherotozero");
    private int size;
    private boolean isEmpty;
    private EmissionDAO emissionDAO = new EmissionDAO();
    List<Emission> emissionenListe = new ArrayList<Emission>();

    
    public EmissionenListe()
    {
        emissionenListe = emissionDAO.loadList();
        size = emissionenListe.size();
        isEmpty = emissionenListe.isEmpty();
    }

    public List<Emission> getEmissionenListe()
    {
        Collections.sort(emissionenListe, Comparator.comparing(Emission::getCountry));
        return emissionenListe;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean getIsEmpty() {
        return isEmpty;
    }
}