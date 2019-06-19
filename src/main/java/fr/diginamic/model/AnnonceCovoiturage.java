package fr.diginamic.model;

import java.time.LocalDateTime;

public class AnnonceCovoiturage {

	private Integer idAnnonceCovoiturage;
	private Integer nbPlacesDisponibles;
	private LocalDateTime dateDeDepart;
	private String lieuDeDepart;
	private String lieuDeDestination;
	private Integer duree;
	private Integer distanceEnKm;
	private Integer idReservationVehicule;
	private Integer idVehiculeUtilisePourCovoiturage;

	/**
	 * Constructeur
	 * 
	 * @param nbPlacesDisponibles
	 * @param dateDeDepart
	 * @param lieuDeDepart
	 * @param lieuDeDestination
	 * @param idUtilisateur
	 */
	public AnnonceCovoiturage(Integer nbPlacesDisponibles, LocalDateTime dateDeDepart, String lieuDeDepart,
			String lieuDeDestination, Integer idUtilisateur, Integer idVehiculeUtilisePourCovoiturage) {
		super();
		this.nbPlacesDisponibles = nbPlacesDisponibles;
		this.dateDeDepart = dateDeDepart;
		this.lieuDeDepart = lieuDeDepart;
		this.lieuDeDestination = lieuDeDestination;
		this.idUtilisateur = idUtilisateur;
		this.idVehiculeUtilisePourCovoiturage = idVehiculeUtilisePourCovoiturage;
	}

	private Integer idUtilisateur;
	private Integer idVehicule;

	/**
	 * Constructeur
	 * 
	 * @param idAnnonceCovoiturage
	 * @param nbPlacesDisponibles
	 * @param dateDeDepart
	 * @param lieuDeDepart
	 * @param lieuDeDestination
	 * @param duree
	 * @param distanceEnKm
	 * @param idReservationVehicule
	 * @param idUtilisateur
	 * @param idVehicule
	 */
	public AnnonceCovoiturage(Integer idAnnonceCovoiturage, Integer nbPlacesDisponibles, LocalDateTime dateDeDepart,
			String lieuDeDepart, String lieuDeDestination, Integer duree, Integer distanceEnKm,
			Integer idReservationVehicule, Integer idUtilisateur, Integer idVehicule) {
		super();
		this.idAnnonceCovoiturage = idAnnonceCovoiturage;
		this.nbPlacesDisponibles = nbPlacesDisponibles;
		this.dateDeDepart = dateDeDepart;
		this.lieuDeDepart = lieuDeDepart;
		this.lieuDeDestination = lieuDeDestination;
		this.duree = duree;
		this.distanceEnKm = distanceEnKm;
		this.idReservationVehicule = idReservationVehicule;
		this.idUtilisateur = idUtilisateur;
		this.idVehiculeUtilisePourCovoiturage = idVehicule;
	}

	/**
	 * @return the idAnnonceCovoiturage
	 */
	public Integer getIdAnnonceCovoiturage() {
		return idAnnonceCovoiturage;
	}

	/**
	 * Setter
	 * 
	 * @param idAnnonceCovoiturage
	 *            the idAnnonceCovoiturage to set
	 */
	public void setIdAnnonceCovoiturage(Integer idAnnonceCovoiturage) {
		this.idAnnonceCovoiturage = idAnnonceCovoiturage;
	}

	/**
	 * @return the nbPlacesDisponibles
	 */
	public Integer getNbPlacesDisponibles() {
		return nbPlacesDisponibles;
	}

	/**
	 * Setter
	 * 
	 * @param nbPlacesDisponibles
	 *            the nbPlacesDisponibles to set
	 */
	public void setNbPlacesDisponibles(Integer nbPlacesDisponibles) {
		this.nbPlacesDisponibles = nbPlacesDisponibles;
	}

	/**
	 * @return the lieuDeDepart
	 */

	/**
	 * @return the duree
	 */
	public Integer getDuree() {
		return duree;
	}

	/**
	 * Setter
	 * 
	 * @param duree
	 *            the duree to set
	 */
	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	/**
	 * @return the distanceEnKm
	 */
	public Integer getDistanceEnKm() {
		return distanceEnKm;
	}

	/**
	 * Setter
	 * 
	 * @param distanceEnKm
	 *            the distanceEnKm to set
	 */
	public void setDistanceEnKm(Integer distanceEnKm) {
		this.distanceEnKm = distanceEnKm;
	}

	/**
	 * @return the idReservationVehicule
	 */
	public Integer getIdReservationVehicule() {
		return idReservationVehicule;
	}

	/**
	 * Setter
	 * 
	 * @param idReservationVehicule
	 *            the idReservationVehicule to set
	 */
	public void setIdReservationVehicule(Integer idReservationVehicule) {
		this.idReservationVehicule = idReservationVehicule;
	}

	/**
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
	 * @return the dateDeDepart
	 */
	public LocalDateTime getDateDeDepart() {
		return dateDeDepart;
	}

	/**
	 * Setter
	 * 
	 * @param dateDeDepart
	 *            the dateDeDepart to set
	 */
	public void setDateDeDepart(LocalDateTime dateDeDepart) {
		this.dateDeDepart = dateDeDepart;
	}

	/**
	 * @return the lieuDeDepart
	 */
	public String getLieuDeDepart() {
		return lieuDeDepart;
	}

	/**
	 * Setter
	 * 
	 * @param lieuDeDepart
	 *            the lieuDeDepart to set
	 */
	public void setLieuDeDepart(String lieuDeDepart) {
		this.lieuDeDepart = lieuDeDepart;
	}

	/**
	 * @return the lieuDeDestination
	 */
	public String getLieuDeDestination() {
		return lieuDeDestination;
	}

	/**
	 * Setter
	 * 
	 * @param lieuDeDestination
	 *            the lieuDeDestination to set
	 */
	public void setLieuDeDestination(String lieuDeDestination) {
		this.lieuDeDestination = lieuDeDestination;
	}

	/**
	 * Setter
	 * 
	 * @param idVehicule
	 *            the idVehicule to set
	 */
	public void setIdVehicule(Integer idVehicule) {
		this.idVehiculeUtilisePourCovoiturage = idVehicule;
	}

	/**
	 * @return the idVehicule
	 */
	public Integer getIdVehicule() {
		return idVehiculeUtilisePourCovoiturage;
	}

	/**
	 * @return the idVehiculeUtilisePourCovoiturage
	 */
	public Integer getIdVehiculeUtilisePourCovoiturage() {
		return idVehiculeUtilisePourCovoiturage;
	}

	/**
	 * Setter
	 * 
	 * @param idVehiculeUtilisePourCovoiturage
	 *            the idVehiculeUtilisePourCovoiturage to set
	 */
	public void setIdVehiculeUtilisePourCovoiturage(Integer idVehiculeUtilisePourCovoiturage) {
		this.idVehiculeUtilisePourCovoiturage = idVehiculeUtilisePourCovoiturage;
	}

}
