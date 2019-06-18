package fr.diginamic.model;

import java.util.ArrayList;
import java.util.List;

public class Collaborateur extends Employe {

	protected List<ReservationVoiture> listeDesReservationsVoitures = new ArrayList<>();
	protected List<ReservationCovoiturage> listeDesReservationsCovoiturages = new ArrayList<>();

	public Collaborateur() {

	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param statut
	 */
	public Collaborateur(Integer id, String nom, String prenom, String statut) {
		super(id, nom, prenom, statut);
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
	public Collaborateur(List<ReservationVoiture> listeDesReservationsVoitures,
			List<ReservationCovoiturage> listeDesReservationsCovoiturages, String nom, String prenom, String email,
			String mdp) {
		super();
		this.listeDesReservationsVoitures = listeDesReservationsVoitures;
		this.listeDesReservationsCovoiturages = listeDesReservationsCovoiturages;
	}

	public void reserverCovoiturage() {

	}

	public void reserverVoiture() {

	}

	public void proposerAnnonceCovoiturage() {

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
	 * @param listeDesReservationsVoitures the listeDesReservationsVoitures to set
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
	 * @param listeDesReservationsCovoiturages the listeDesReservationsCovoiturages
	 *                                         to set
	 */
	public void setListeDesReservationsCovoiturages(List<ReservationCovoiturage> listeDesReservationsCovoiturages) {
		this.listeDesReservationsCovoiturages = listeDesReservationsCovoiturages;
	}
}
