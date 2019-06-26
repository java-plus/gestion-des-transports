package fr.diginamic.model;

import java.util.ArrayList;
import java.util.List;


/**
 * classe représentant un collaborateur, fille de la classe Employe
 * 
 * @author Diginamic02
 *
 */

public class Collaborateur extends Employe {

	protected List<ReservationVoiture> listeDesReservationsVoitures = new ArrayList<>();
	protected List<ReservationCovoiturage> listeDesReservationsCovoiturages = new ArrayList<>();

	public Collaborateur() {

	}

	/**
	 * Constructor de l'objet collaborateur
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
	 * Constructeur de l'objet collaborateur
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

	/**
	 * Getter
	 * 
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
	 * Getter
	 * 
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
}
