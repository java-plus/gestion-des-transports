package fr.diginamic.model;

/** Class de l'objet ReservationCovoiturage */
public class ReservationCovoiturage {
	
	/** id de la réservation covoiturage */
	private Integer id_ReservationCovoiturage;
	
	/** id de l'annonce de covoiturage **/
	private Integer idAnnonceCovoiturage;
	
	/** id de l'utilisateur du covoiturage */
	private Integer idUtilisateur;
	
	/**  annonce du covoiturage * */
	private AnnonceCovoiturage annonceCovoiturage;

	/**
	 * Constructeur de l'objet ReservationCovoiturage
	 * 
	 * @param id_ReservationCovoiturage sous forme d'un Integer
	 * @param idAnnonceCovoiturage sous forme d'un Integer
	 * @param idUtilisateur sous forme d'un Integer
	 */
	public ReservationCovoiturage(Integer id_ReservationCovoiturage, Integer idAnnonceCovoiturage,
			Integer idUtilisateur) {
		super();
		this.id_ReservationCovoiturage = id_ReservationCovoiturage;
		this.idAnnonceCovoiturage = idAnnonceCovoiturage;
		this.idUtilisateur = idUtilisateur;
	}
	
	/**
	 * Constructeur de l'objet ReservationCovoiturage
	 * 
	 * @param id_ReservationCovoiturage sous forme d'un Integer
	 * @param idAnnonceCovoiturage sous forme d'un Integer
	 * @param idUtilisateur sous forme d'un Integer
	 * @param annonceCovoiturage sous forme d'un AnnonceCovoiturage
	 */
	public ReservationCovoiturage(Integer id_ReservationCovoiturage, Integer idAnnonceCovoiturage,
			Integer idUtilisateur, AnnonceCovoiturage annonceCovoiturage) {
		super();
		this.id_ReservationCovoiturage = id_ReservationCovoiturage;
		this.idAnnonceCovoiturage = idAnnonceCovoiturage;
		this.idUtilisateur = idUtilisateur;
		this.annonceCovoiturage = annonceCovoiturage;
	}

	/** Getter
	 * @return the id_ReservationCovoiturage
	 */
	public Integer getId_ReservationCovoiturage() {
		return id_ReservationCovoiturage;
	}

	/**
	 * Setter
	 * 
	 * @param id_ReservationCovoiturage
	 *            the id_ReservationCovoiturage to set
	 */
	public void setId_ReservationCovoiturage(Integer id_ReservationCovoiturage) {
		this.id_ReservationCovoiturage = id_ReservationCovoiturage;
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
	 * @return the annonceCovoiturage
	 */
	public AnnonceCovoiturage getAnnonceCovoiturage() {
		return annonceCovoiturage;
	}

	/**
	 * Setter
	 * 
	 * @param annonceCovoiturage
	 *            the annonceCovoiturage to set
	 */
	public void setAnnonceCovoiturage(AnnonceCovoiturage annonceCovoiturage) {
		this.annonceCovoiturage = annonceCovoiturage;
	}

}
