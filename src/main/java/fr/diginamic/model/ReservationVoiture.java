package fr.diginamic.model;

import java.time.LocalDateTime;

/**
 * Représente une réservation d'un voiture de société.
 */
public class ReservationVoiture {

	protected Integer id;
	protected Integer idUtilisateur;
	protected Integer idChauffeur;
	protected LocalDateTime dateTimeDeDebut;
	protected LocalDateTime dateTimeDeFin;
	protected Vehicule vehicule;

	/**
	 * Constructor
	 * 
	 */
	public ReservationVoiture() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param idUtilisateur
	 * @param idChauffeur
	 * @param idVehicule
	 * @param dateTimeDeDebut
	 * @param dateTimeDeFin
	 * @param vehicule
	 */

	public ReservationVoiture(Integer id, Integer idUtilisateur, Integer idChauffeur,
			LocalDateTime dateTimeDeDebut, LocalDateTime dateTimeDeFin, Vehicule vehicule) {
		super();
		this.id = id;
		this.idUtilisateur = idUtilisateur;
		this.idChauffeur = idChauffeur;
		this.dateTimeDeDebut = dateTimeDeDebut;
		this.dateTimeDeFin = dateTimeDeFin;
		this.vehicule = vehicule;
	}

	public ReservationVoiture(Integer idUtilisateur, LocalDateTime dateTimeDeDebut, LocalDateTime dateTimeDeFin,
			Vehicule vehicule) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.dateTimeDeDebut = dateTimeDeDebut;
		this.dateTimeDeFin = dateTimeDeFin;
		this.vehicule = vehicule;
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

}