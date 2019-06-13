package fr.diginamic.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Employe {

	private List<ReservationVoiture> listeDesReservationsVoitures = new ArrayList<>();
	private List<ReservationCovoiturage> listeDesReservationsCovoiturages = new ArrayList<>();
	private String nom;
	private String prenom;
	private String email;
	private String mdp;

	public Employe() {

	}

	/**
	 * Constructeur
	 * 
	 * @param listeDesReservationsVoitures
	 * @param listeDesReservationsCovoiturages
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param mdp
	 */
	public Employe(List<ReservationVoiture> listeDesReservationsVoitures,
			List<ReservationCovoiturage> listeDesReservationsCovoiturages, String nom, String prenom, String email,
			String mdp) {
		super();
		this.listeDesReservationsVoitures = listeDesReservationsVoitures;
		this.listeDesReservationsCovoiturages = listeDesReservationsCovoiturages;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}

	public void reserverCovoiturage() {

	}

	public void reserverVoiture() {

	}

	public void ProposerAnnonceCovoiturage() {

	}

	/**
	 * @return the listeDesReservationsVoitures
	 */
	public List<ReservationVoiture> getListeDesReservationsVoitures() {
		return listeDesReservationsVoitures;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesReservationsVoitures
	 *            the listeDesReservationsVoitures to set
	 */
	public void setListeDesReservationsVoitures(List<ReservationVoiture> listeDesReservationsVoitures) {
		this.listeDesReservationsVoitures = listeDesReservationsVoitures;
	}

	/**
	 * @return the listeDesReservationsCovoiturages
	 */
	public List<ReservationCovoiturage> getListeDesReservationsCovoiturages() {
		return listeDesReservationsCovoiturages;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesReservationsCovoiturages
	 *            the listeDesReservationsCovoiturages to set
	 */
	public void setListeDesReservationsCovoiturages(List<ReservationCovoiturage> listeDesReservationsCovoiturages) {
		this.listeDesReservationsCovoiturages = listeDesReservationsCovoiturages;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * 
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Setter
	 * 
	 * @param mdp
	 *            the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
