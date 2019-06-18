package fr.diginamic.model;

public class Administrateur extends Employe {

	/**
	 * Constructor
	 * 
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param mdp
	 */
	public Administrateur(String nom, String prenom, String email, String mdp) {
		super();
	}

	public Administrateur(Integer id, String nom, String prenom, String statut) {
		super(id, nom, prenom, statut);
	}

	public void supprimerVehicule() {

	}

	public void envoyerVehiculeEnReparation() {

	}
}
