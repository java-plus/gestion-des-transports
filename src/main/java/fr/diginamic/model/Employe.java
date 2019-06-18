package fr.diginamic.model;

public abstract class Employe {

	protected Integer id;
	protected String nom;
	protected String prenom;
	protected String email;
	protected String mdp;
	protected String statut;

	public Employe() {

	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param statut
	 */
	public Employe(Integer id, String nom, String prenom, String statut) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
	}

	/**
	 * Constructeur
	 * 
	 * @param listeDesReservationsVoitures
	 * @param listeDesReservationsCovoiturages
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param mdp
	 */
	public Employe(String nom, String prenom, String email, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * 
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Setter
	 * 
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter
	 * 
	 * @param email the email to set
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
	 * @param id the id to set
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
	 * @param statut the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

}
