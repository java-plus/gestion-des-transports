package fr.diginamic.model;

/** Class abstraite représentant un employé */
public abstract class Employe {

	/** id de l'employé */
	protected Integer id;
	
	/** nom de l'employé */
	protected String nom;
	
	/** prenom de l'employé */
	protected String prenom;
	
	/** email de l'employé */
	protected String email;
	
	/** mdp de l'employé */
	protected String mdp;
	
	/** statut de l'employé */
	protected String statut;
	
	/**
	 * Constructeur
	 * 
	 * @param id sous forme d'un Integer
	 * @param nom sous forme d'un String
	 * @param prenom sous forme d'un String
	 * @param email sous forme d'un String
	 * @param mdp sous forme d'un String
	 */
	public Employe(Integer id, String nom, String prenom, String email, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}

	/**
	 * Constructeur par défaut
	 * 
	 */
	public Employe() {

	}

	/**
	 * Constructeur de l'objet Employé
	 * 
	 * @param id sous forme d'un Integer
	 * @param nom sous forme d'un String
	 * @param prenom sous forme d'un String
	 * @param statut sous forme d'un String
	 */
	public Employe(Integer id, String nom, String prenom, String statut) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
	}

	/**
	 * Constructeur de l'objet Employé
	 * 
	 * @param nom sous forme d'un String
	 * @param prenom sous forme d'un String
	 * @param email sous forme d'un String
	 * @param mdp sous forme d'un String
	 */
	public Employe(String nom, String prenom, String email, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * 
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Setter
	 * 
	 * @param mdp
	 *            the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/** Getter
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * Setter
	 * 
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

}
