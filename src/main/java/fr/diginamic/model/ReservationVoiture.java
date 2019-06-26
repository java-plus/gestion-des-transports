package fr.diginamic.model;

import java.time.LocalDateTime;

/**
 * Représente une réservation d'une voiture de société.
 */
public class ReservationVoiture {

	protected Integer id;
	protected Integer idUtilisateur;
	protected Integer idChauffeur;
	protected LocalDateTime dateTimeDeDebut;
	protected LocalDateTime dateTimeDeFin;
	protected Vehicule vehicule;
	protected Integer besoinChauffeur;
	protected String immatriculation;
	protected String marque;
	protected String modele;

	/**
	 * Constructor par d�faut de l'objet ReservationVoiture
	 * 
	 */
	public ReservationVoiture() {
		super();
	}

	/**
	 * Constructor de l'objet ReservationVoiture
	 * 
	 * @param id
	 * @param idUtilisateur
	 * @param idChauffeur
	 * @param idVehicule
	 * @param dateTimeDeDebut
	 * @param dateTimeDeFin
	 * @param vehicule
	 */

	public ReservationVoiture(Integer id, Integer idUtilisateur, Integer idChauffeur, LocalDateTime dateTimeDeDebut,
			LocalDateTime dateTimeDeFin, Vehicule vehicule) {
		super();
		this.id = id;
		this.idUtilisateur = idUtilisateur;
		this.idChauffeur = idChauffeur;
		this.dateTimeDeDebut = dateTimeDeDebut;
		this.dateTimeDeFin = dateTimeDeFin;
		this.vehicule = vehicule;
	}

	/**
	 * Constructeur de l'objet ReservationVoiture
	 * 
	 * @param idUtilisateur
	 * @param dateTimeDeDebut
	 * @param dateTimeDeFin
	 * @param vehicule
	 */
	public ReservationVoiture(Integer idUtilisateur, LocalDateTime dateTimeDeDebut, LocalDateTime dateTimeDeFin,
			Vehicule vehicule) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.dateTimeDeDebut = dateTimeDeDebut;
		this.dateTimeDeFin = dateTimeDeFin;
		this.vehicule = vehicule;
	}

	/**
	 * Constructeur de l'objet ReservationVoiture
	 * 
	 * @param dateTimeDeDebut
	 * @param dateTimeDeFin
	 * @param immatriculation
	 * @param marque
	 * @param modele
	 */
	public ReservationVoiture(LocalDateTime dateTimeDeDebut, LocalDateTime dateTimeDeFin, String immatriculation,
			String marque, String modele) {
		super();
		this.dateTimeDeDebut = dateTimeDeDebut;
		this.dateTimeDeFin = dateTimeDeFin;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
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
	 * <<<<<<< HEAD
	 * 
	 * @param id
	 *            the id to set =======
	 * @param id
	 *            the id to set >>>>>>> master
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the idUtilisateur
	 */
	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * Setter
	 * 
	 * @param idUtilisateur
	 *            the idUtilisateur to set
	 */
	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * Getter
	 * 
	 * @return the idChauffeur
	 */
	public Integer getIdChauffeur() {
		return idChauffeur;
	}

	/**
	 * Setter
	 * 
	 * @param idChauffeur
	 *            the idChauffeur to set
	 */
	public void setIdChauffeur(Integer idChauffeur) {
		this.idChauffeur = idChauffeur;
	}

	/**
	 * Getter
	 * 
	 * @return the dateTimeDeDebut
	 */
	public LocalDateTime getDateTimeDeDebut() {
		return dateTimeDeDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateTimeDeDebut
	 *            the dateTimeDeDebut to set
	 */
	public void setDateTimeDeDebut(LocalDateTime dateTimeDeDebut) {
		this.dateTimeDeDebut = dateTimeDeDebut;
	}

	/**
	 * Getter
	 * 
	 * @return the dateTimeDeFin
	 */
	public LocalDateTime getDateTimeDeFin() {
		return dateTimeDeFin;
	}

	/**
	 * Setter
	 * 
	 * 
	 * @param dateTimeDeFin
	 *            the dateTimeDeFin to set =======
	 * @param dateTimeDeFin
	 *            the dateTimeDeFin to set >>>>>>> master
	 */
	public void setDateTimeDeFin(LocalDateTime dateTimeDeFin) {
		this.dateTimeDeFin = dateTimeDeFin;
	}

	/**
	 * Getter
	 * 
	 * @return the vehicule
	 */
	public Vehicule getVehicule() {
		return vehicule;
	}

	/**
	 * Setter
	 * 
	 * @param vehicule
	 *            the vehicule to set
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	/**
	 * Getter
	 * 
	 * @return the besoinChauffeur
	 */
	public Integer getBesoinChauffeur() {
		return besoinChauffeur;
	}

	/**
	 * Setters
	 * 
	 * @param besoinChauffeur
	 *            the besoinChauffeur to set
	 */
	public void setBesoinChauffeur(Integer besoinChauffeur) {
		this.besoinChauffeur = besoinChauffeur;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

}