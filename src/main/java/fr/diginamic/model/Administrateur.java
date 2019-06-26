package fr.diginamic.model;

/** Class représentant un employé de type Administrateur */
public class Administrateur extends Employe {

	/**
	 * Constructeur de l'objet Administrateur
	 * 
	 * @param nom d'un Administrateur sous forme d'un String
	 * @param prenom d'un Administrateur sous forme d'un String
	 * @param email d'un Administrateur sous forme d'un String
	 * @param mdp d'un Administrateur sous forme d'un String
	 */
	public Administrateur(String nom, String prenom, String email, String mdp) {
		super();
	}

	/**
	 * Constructeur de l'objet Administrateur
	 * 
	 * @param id d'un Administrateur sous forme d'un Integer
	 * @param nom d'un Administrateur sous forme d'un String
	 * @param prenom d'un Administrateur sous forme d'un String
	 * @param statut d'un Administrateur sous forme d'un String
	 */
	public Administrateur(Integer id, String nom, String prenom, String statut) {
		super(id, nom, prenom, statut);
	}

}
