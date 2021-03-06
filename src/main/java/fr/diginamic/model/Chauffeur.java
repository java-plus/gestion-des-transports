package fr.diginamic.model;


/**
 * Classe représentant un Chauffeur, classe fille de Employe
 * 
 * @author Diginamic02
 *
 */

public class Chauffeur extends Employe {

	private String matricule;
	private String permis;
	private String photo;
	private String telephone;

	/**
	 * Constructeur de l'objet Chauffeur
	 * 
	 */
	public Chauffeur() {
		super();
	}

	/**
	 * Constructor de l'objet Chauffeur
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param statut
	 */
	public Chauffeur(Integer id, String nom, String prenom, String statut) {
		super(id, nom, prenom, statut);
	}

	/**
	 * Constructeur de l'objet Chauffeur
	 * 
	 * @param matricule
	 * @param permis
	 * @param photo
	 * @param telephone
	 */
	public Chauffeur(String matricule, String permis, String photo, String telephone) {
		super();
		this.matricule = matricule;
		this.permis = permis;
		this.photo = photo;
		this.telephone = telephone;
	}

	/**
	 * Constructor de l'objet Chauffeur
	 * 
	 * @param matricule
	 * @param permis
	 * @param photo
	 * @param telephone
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param mdp
	 */
	public Chauffeur(String matricule, String permis, String photo, String telephone, String nom, String prenom,
			String email, String mdp) {
		super(nom, prenom, email, mdp);
		this.matricule = matricule;
		this.permis = permis;
		this.photo = photo;
		this.telephone = telephone;
	}

	/**
	 * Getter
	 * 
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Setter
	 * 
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * Getter
	 * 
	 * @return the permis
	 */
	public String getPermis() {
		return permis;
	}

	/**
	 * Setter
	 * 
	 * @param permis
	 *            the permis to set
	 */
	public void setPermis(String permis) {
		this.permis = permis;
	}

	/**
	 * Getter
	 * 
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Setter
	 * 
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Getter
	 * 
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Setter
	 * 
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
