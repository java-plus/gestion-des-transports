package fr.diginamic.model;

public class Vehicule {

	String immatriculation;
	String marque;
	String modele;
	String categorie;
	Integer nombreDePlaces;
	String photo;

	/**
	 * Constructeur
	 * 
	 * @param immatriculation
	 * @param marque
	 * @param modele
	 * @param categorie
	 * @param nombreDePlaces
	 * @param photo
	 */
	public Vehicule(String immatriculation, String marque, String modele, String categorie, Integer nombreDePlaces,
			String photo) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.nombreDePlaces = nombreDePlaces;
		this.photo = photo;
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
	 * @param immatriculation
	 *            the immatriculation to set
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
	 * @param marque
	 *            the marque to set
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
	 * @param modele
	 *            the modele to set
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
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the nombreDePlaces
	 */
	public Integer getNombreDePlaces() {
		return nombreDePlaces;
	}

	/**
	 * Setter
	 * 
	 * @param nombreDePlaces
	 *            the nombreDePlaces to set
	 */
	public void setNombreDePlaces(Integer nombreDePlaces) {
		this.nombreDePlaces = nombreDePlaces;
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
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
