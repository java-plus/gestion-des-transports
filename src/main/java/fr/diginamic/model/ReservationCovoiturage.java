package fr.diginamic.model;

public class ReservationCovoiturage {

	private Integer id_ReservationCovoiturage;
	private Integer idAnnonceCovoiturage;
	private Integer idUtilisateur;
	private AnnonceCovoiturage annonceCovoiturage;

	/**
	 * Constructeur
	 * 
	 * @param id_ReservationCovoiturage
	 * @param idAnnonceCovoiturage
	 * @param idUtilisateur
	 */
	public ReservationCovoiturage(Integer id_ReservationCovoiturage, Integer idAnnonceCovoiturage,
			Integer idUtilisateur) {
		super();
		this.id_ReservationCovoiturage = id_ReservationCovoiturage;
		this.idAnnonceCovoiturage = idAnnonceCovoiturage;
		this.idUtilisateur = idUtilisateur;
	}

	public ReservationCovoiturage(Integer id_ReservationCovoiturage, Integer idAnnonceCovoiturage,
			Integer idUtilisateur, AnnonceCovoiturage annonceCovoiturage) {
		super();
		this.id_ReservationCovoiturage = id_ReservationCovoiturage;
		this.idAnnonceCovoiturage = idAnnonceCovoiturage;
		this.idUtilisateur = idUtilisateur;
		this.annonceCovoiturage = annonceCovoiturage;
	}

	/**
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

}
