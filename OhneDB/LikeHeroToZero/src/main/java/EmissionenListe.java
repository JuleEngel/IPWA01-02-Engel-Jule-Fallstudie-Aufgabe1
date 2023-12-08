import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class EmissionenListe
{
    private List<Emission> emissionenListe = new ArrayList<Emission>();
    private int size;
    private boolean isEmpty;

    
    public EmissionenListe()
    {
    	emissionenListe.add(new Emission("Afghanistan", "9,123", "8,123", "8,9412", "8,1239"));
    	emissionenListe.add(new Emission("Germany", "753,1235", "701,5234", "629,9213", "665,2134"));
    	emissionenListe.add(new Emission("Russia", "1811,939536", "1881,71206", "1797,595272", "1942,535227"));
        this.size = emissionenListe.size();
        this.isEmpty = emissionenListe.isEmpty();
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

