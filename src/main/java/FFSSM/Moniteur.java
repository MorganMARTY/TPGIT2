/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Personne {

    public int numeroDiplome;
    
    private final List<Embauche> employeurs = new LinkedList<>();
    
    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur, ou null
     */
    public Club employeurActuel() {
        return employeurs.isEmpty() ? 
                null :  
                employeurs.get(employeurs.size() - 1).estTerminee() ? 
			null : 
			employeurs.get(employeurs.size() - 1).getEmployeur();
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
         if (! employeurs.isEmpty()) { 
            Embauche derniereEmbauche = employeurs.get(employeurs.size() - 1);
            if (null == derniereEmbauche.getFin()) 
                derniereEmbauche.setFin(debutNouvelle);             
        }
        
        Embauche nouvelle = new Embauche(debutNouvelle, this, employeur);
        employeurs.add(nouvelle);    
    }

    public List<Embauche> emplois() {
       return Collections.unmodifiableList(employeurs);
    }

}
