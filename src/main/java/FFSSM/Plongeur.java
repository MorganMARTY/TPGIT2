package FFSSM;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne{
	private List<Licence> licences = new LinkedList<>();
	
	private int niveau = 0;
	
	private GroupeSanguin groupe = GroupeSanguin.APLUS;	
	
	public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, Licence l) {
		super(numeroINSEE, nom, prenom, adresse, telephone, naissance);

		licences.add(l);
	}	
	
	public void ajouteLicence(Licence l) {
		if (null == l)
			throw new IllegalArgumentException("l is null");
		licences.add(l);		
	}
	
	public Licence derniereLicence() {
		return licences.get(licences.size() - 1);
	}

	/**
	 * Get the value of groupe
	 *
	 * @return the value of groupe
	 */
	public GroupeSanguin getGroupe() {
		return groupe;
	}

	/**
	 * Set the value of groupe
	 *
	 * @param groupe new value of groupe
	 */
	public void setGroupe(GroupeSanguin groupe) {
		this.groupe = groupe;
	}


	/**
	 * Get the value of niveau
	 *
	 * @return the value of niveau
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * Set the value of niveau
	 *
	 * @param niveau new value of niveau
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
}
