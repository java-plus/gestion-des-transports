package fr.diginamic.model;

/**
 * classe vehicule représentant un vehicule
 * 
 * @author Diginamic02
 *
 */
public class Vehicule {

	// private Integer idVehicule;
	// private StatutVehicule statutVehicule;
	private Integer id;
	private String immatriculation;
	private String marque;
	private String modele;
	private String categorie;
	private String photo;
	private String etat;
	private String position;

	/**
	 * Constructeur de l'objet vehicule
	 * 
	 * @param immatriculation
	 *            sous forme String
	 * @param marque
	 *            sous forme String
	 * @param modele
	 *            sous forme String
	 * @param proprietaire
	 *            sous forme String
	 */
	public Vehicule(String immatriculation, String marque, String modele, String proprietaire) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.proprietaire = proprietaire;
	}

	private String proprietaire;
	private Integer nbPlaces;
	// private Integer nombreDePlaces;

	/**
	 * Constructeur de l'objet vehicule
	 * 
	 * @param id
	 *            sous forme Integer
	 * @param immatriculation
	 *            sous forme String
	 * @param marque
	 *            sous forme String
	 * @param modele
	 *            sous forme String
	 * @param categorie
	 *            sous forme String
	 * @param photo
	 *            sous forme String (url)
	 * @param etat
	 *            sous forme String est une enum (null par défaut)
	 * @param position
	 *            sous forme String
	 * @param proprietaire
	 *            sous forme String
	 */
	public Vehicule(Integer id, String immatriculation, String marque, String modele, String categorie, String photo,
			String etat, String position, String proprietaire) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.photo = photo;
		this.etat = etat;
		this.position = position;
		this.proprietaire = proprietaire;
	}

	/**
	 * Constructeur de l'objet vehicule
	 * 
	 * @param immatriculation
	 *            sous forme String
	 * @param marque
	 *            sous forme String
	 * @param modele
	 *            sous forme String
	 * @param categorie
	 *            sous forme String
	 * @param photo
	 *            sous forme String (url)
	 * @param etat
	 *            etat sous forme String est une enum (null par défaut)
	 * @param position
	 *            sous forme String
	 * @param proprietaire
	 *            sous forme String
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

	/**
	 * Constructeur de l'objet vehicule
	 * 
	 * @param immatriculation
	 *            sous forme String
	 * @param marque
	 *            sous forme String
	 * @param modele
	 *            sous forme String
	 * @param categorie
	 *            sous forme String
	 * @param photo
	 *            sous forme String (url)
	 */
	public Vehicule(String immatriculation, String marque, String modele, String categorie, String photo) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.photo = photo;
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 *            sous forme Integer
	 */
	public Vehicule(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Constructeur
	 * 
	 * @param immatriculation
	 *            sous forme String
	 * @param marque
	 *            sous forme String
	 * @param modele
	 *            sous forme String
	 * @param categorie
	 *            sous forme String
	 * @param photo
	 *            sous forme String (url)
	 * @param etat
	 *            sous forme String est une enum (null par défaut)
	 */
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
	 * Getter
	 * 
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Setter
	 * 
	 * @param immatriculation
	 *            the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * Getter
	 * 
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * Setter
	 * 
	 * @param marque
	 *            the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * Getter
	 * 
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * Setter
	 * 
	 * @param modele
	 *            the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * Getter
	 * 
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * Setter
	 * 
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
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
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * Setter
	 * 
	 * @param etat
	 *            the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * Getter
	 * 
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Setter
	 * 
	 * @param position
	 *            the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Getter
	 * 
	 * @return the proprietaire
	 */
	public String getProprietaire() {
		return proprietaire;
	}

	/**
	 * Setter
	 * 
	 * @param proprietaire
	 *            the proprietaire to set
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

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setters
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
