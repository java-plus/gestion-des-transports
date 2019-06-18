package fr.diginamic.model;

public class Vehicule {

	// private Integer idVehicule;
	// private StatutVehicule statutVehicule;
	private String immatriculation;
	private String marque;
	private String modele;
	private String categorie;
	private String photo;
	private String etat;
	private String position;
	private String proprietaire;
	private Integer nbPlaces;
	// private Integer nombreDePlaces;

	/**
	 * Constructeur
	 * 
	 * @param immatriculation
	 * @param marque
	 * @param modele
	 * @param categorie
	 * @param photo
	 * @param etat
	 * @param position
	 * @param proprietaire
	 */
	public Vehicule(String immatriculation, String marque, String modele, String categorie, String photo, String etat,
			String position, String proprietaire) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.photo = photo;
		this.etat = etat;
		this.position = position;
		this.proprietaire = proprietaire;
	}

	public Vehicule(String immatriculation, String marque, String modele, String categorie, String photo) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.photo = photo;
	}

	public Vehicule(String immatriculation, String marque, String modele, String categorie, String photo, String etat) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.photo = photo;
		this.etat = etat;
	}

	/**
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Setter
	 * 
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * Setter
	 * 
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * Setter
	 * 
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * Setter
	 * 
	 * @param categorie the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Setter
	 * 
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * Setter
	 * 
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Setter
	 * 
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the proprietaire
	 */
	public String getProprietaire() {
		return proprietaire;
	}

	/**
	 * Setter
	 * 
	 * @param proprietaire the proprietaire to set
	 */
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	/**
	 * Getter
	 * 
	 * @return the nbPlaces
	 */
	public Integer getNbPlaces() {
		return nbPlaces;
	}

	/**
	 * Setters
	 * 
	 * @param nbPlaces
	 *            the nbPlaces to set
	 */
	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

}
