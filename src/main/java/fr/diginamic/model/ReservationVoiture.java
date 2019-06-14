package fr.diginamic.model;

import java.util.Date;

public class ReservationVoiture {

	private Date dateDeDebut;
	private Date dateDeFin;
	private Date heureDeDebut;
	private Date heureDeFin;
	private Vehicule vehicule;

	/**
	 * Constructeur
	 * 
	 * @param dateDeDebut
	 * @param dateDeFin
	 * @param heureDeDebut
	 * @param heureDeFin
	 * @param vehicule
	 */
	public ReservationVoiture(Date dateDeDebut, Date dateDeFin, Date heureDeDebut, Date heureDeFin, Vehicule vehicule) {
		super();
		this.dateDeDebut = dateDeDebut;
		this.dateDeFin = dateDeFin;
		this.heureDeDebut = heureDeDebut;
		this.heureDeFin = heureDeFin;
		this.vehicule = vehicule;
	}

	/**
	 * @return the dateDeDebut
	 */
	public Date getDateDeDebut() {
		return dateDeDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateDeDebut the dateDeDebut to set
	 */
	public void setDateDeDebut(Date dateDeDebut) {
		this.dateDeDebut = dateDeDebut;
	}

	/**
	 * @return the dateDeFin
	 */
	public Date getDateDeFin() {
		return dateDeFin;
	}

	/**
	 * Setter
	 * 
	 * @param dateDeFin the dateDeFin to set
	 */
	public void setDateDeFin(Date dateDeFin) {
		this.dateDeFin = dateDeFin;
	}

	/**
	 * @return the heureDeDebut
	 */
	public Date getHeureDeDebut() {
		return heureDeDebut;
	}

	/**
	 * Setter
	 * 
	 * @param heureDeDebut the heureDeDebut to set
	 */
	public void setHeureDeDebut(Date heureDeDebut) {
		this.heureDeDebut = heureDeDebut;
	}

	/**
	 * @return the heureDeFin
	 */
	public Date getHeureDeFin() {
		return heureDeFin;
	}

	/**
	 * Setter
	 * 
	 * @param heureDeFin the heureDeFin to set
	 */
	public void setHeureDeFin(Date heureDeFin) {
		this.heureDeFin = heureDeFin;
	}

	/**
	 * @return the vehicule
	 */
	public Vehicule getVehicule() {
		return vehicule;
	}

	/**
	 * Setter
	 * 
	 * @param vehicule the vehicule to set
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

}
