import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;

import java.io.Serializable;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Named
@SessionScoped
public class EmissionsController implements Serializable
{
    private Emission neueEmission = new Emission();
    private Emission platzhalter = new Emission("Keine Emissionen", "", "", "", "");
    private int index = 0;
    private EmissionDAO emissionDAO = new EmissionDAO();
    
    @Inject
    private EmissionenListe emissionenListe = new EmissionenListe();
    
    private int maxIndex = emissionenListe.getSize() - 1;;
    private boolean isEmpty = emissionenListe.getIsEmpty();
    
    
    
    public Emission getEmissionenListe() {
        return emissionenListe.getEmissionenListe().get(index);
    }
    
    public void vor() {
        if (index < maxIndex) {
            index++;
        }
    }
    
    public void zurueck() {
    	if (index > 0) {
    		index--;
    	}
    }
    
    public int getIndex() {
    	return index;
    }
    
    public int getMaxIndex() {
    	return maxIndex;
    }
    
    public boolean getIsEmpty() {
        return isEmpty;
    }
    
    public Emission getNeueEmission() {

    	return this.neueEmission;
    }
    
    public void createEmission()  {
        if (emissionenListe.getEmissionenListe().contains(platzhalter)) {
            emissionenListe.getEmissionenListe().remove(platzhalter);
            maxIndex = 0;
            isEmpty = false;
            index = 0;
        }
        else {
            maxIndex += 1;
        }
        
        emissionDAO.createEmission(neueEmission);
        
        emissionenListe.getEmissionenListe().add(neueEmission);
        neueEmission = new Emission();

    }
    
    public void updateEmission(Emission emission) {
        emissionDAO.updateEmission(emission);
    }
    
    public void deleteEmission(Emission emission)  {
        
        emissionDAO.deleteEmission(emission);
        emissionenListe.getEmissionenListe().remove(emission);
        
        if (maxIndex != 0) {
            maxIndex -= 1;
        }
        if (index > maxIndex) {
            index = maxIndex;
        }
        if (emissionenListe.getEmissionenListe().isEmpty()) {
            isEmpty = true;
        }
    }
    
    public void validateEmission(FacesContext context, UIComponent comp, Object value) throws ValidatorException{
        String regex = "^[0-9,]+$";
        String emission = (String) value;
        if (!emission.matches(regex)) {
            throw new ValidatorException(new FacesMessage("Bitte geben Sie eine korrekte Emission ein!"));
        }
    }
    
    public void validateCountry(FacesContext context, UIComponent comp, Object value) throws ValidatorException{
        String regex = "^[a-zA-z]+$";
        String name = (String) value;
        for(Emission existierendeEmission : emissionenListe.getEmissionenListe()) {
        	if(existierendeEmission.getCountry().equalsIgnoreCase(name)) {
        		throw new ValidatorException(new FacesMessage("Das Land existriert bereits!"));
        	}
        }
        if (!name.matches(regex)) {
            throw new ValidatorException(new FacesMessage("Bitte geben Sie einen korrekten Ländernamen ein!"));
        }
    }
}