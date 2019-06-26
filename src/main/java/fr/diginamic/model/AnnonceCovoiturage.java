package fr.diginamic.model;

import java.time.LocalDateTime;

/** Class représentant une annonce de covoiturage */
public class AnnonceCovoiturage {
	
	/** id de l'annonce de covoiturage */
	private Integer idAnnonceCovoiturage;
	
	/** nombre de place disponible pour le covoiturage */
	private Integer nbPlacesDisponibles;
	
	/** date de départ covoiturage  */
	private LocalDateTime dateDeDepart;
	
	/** lieu de départ covoiturage */
	private String lieuDeDepart;
	
	/** lieu de destination du covoiturage */
	private String lieuDeDestination;
	
	/** duree du covoiturage */
	private Integer duree;
	
	/** distance parcourue */
	private Integer distanceEnKm;
	
	/** id de la réservation du véhicule */
	private Integer idReservationVehicule;
	
	/** id du vehicule utilisé pour le covoiturage */
	private Integer idVehiculeUtilisePourCovoiturage;
	
	/** id de l'utilisateur réservant un covoiturage */
	private Integer idUtilisateur;
	
	/** id du vehicule */
	private Integer idVehicule;

	/**
	 * Constructeur avec id de reservation
	 * 
	 * @param nbPlacesDisponibles sous forme d'un Integer
	 * @param dateDeDepart sous forme d'un LocalDateTime
	 * @param lieuDeDepart sous forme d'un String
	 * @param lieuDeDestination sous forme d'un String
	 * @param idUtilisateur sous forme d'un Integer
	 * @param idVehiculeUtilisePourCovoiturage sous forme d'un Integer
	 * @param idReservationVehicule sous forme d'un Integer
	 */
	public AnnonceCovoiturage(Integer nbPlacesDisponibles, LocalDateTime dateDeDepart, String lieuDeDepart,
			String lieuDeDestination, Integer idUtilisateur, Integer idVehiculeUtilisePourCovoiturage,
			Integer idReservationVehicule) {
		super();
		this.nbPlacesDisponibles = nbPlacesDisponibles;
		this.dateDeDepart = dateDeDepart;
		this.lieuDeDepart = lieuDeDepart;
		this.lieuDeDestination = lieuDeDestination;
		this.idUtilisateur = idUtilisateur;
		this.idVehiculeUtilisePourCovoiturage = idVehiculeUtilisePourCovoiturage;
		this.idReservationVehicule = idReservationVehicule;
	}

	/**
	 * Constructeur sans id de reservation
	 * 
	 * @param nbPlacesDisponibles sous forme d'un Integer
	 * @param dateDeDepart sous forme d'un LocalDateTime
	 * @param lieuDeDepart sous forme d'un String
	 * @param lieuDeDestination sous forme d'un String
	 * @param idUtilisateur sous forme d'un Integer
	 * @param idVehiculeUtilisePourCovoiturage sous forme d'un Integer
	 * @param idReservationVehicule sous forme d'un Integer
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

	
	/**
	 * Constructeur complet pour l'objet AnnonceCovoiturage
	 * 
	 * @param idAnnonceCovoiturage sous forme d'un Integer
	 * @param nbPlacesDisponibles sous forme d'un Integer
	 * @param dateDeDepart sous forme d'un LocalDateTime
	 * @param lieuDeDepart sous forme d'un String
	 * @param lieuDeDestination sous forme d'un String
	 * @param duree sous forme d'un Integer
	 * @param distanceEnKm sous forme d'un Integer
	 * @param idUtilisateur sous forme d'un Integer
	 * @param idVehicule sous forme d'un Integer
	 * @param idReservationVehicule sous forme d'un Integer
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

	/** Getter
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

	/** Getter
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

	/** Getter
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

	/** Getter
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

	/** Getter
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

	/** Getter
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

	/** Getter
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

	/** Getter
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

	/** Getter
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

	/** Getter
	 * @return the idVehicule
	 */
	public Integer getIdVehicule() {
		return idVehiculeUtilisePourCovoiturage;
	}

	/** Getter
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
