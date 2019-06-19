package fr.diginamic.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fr.diginamic.model.Employe;
import fr.diginamic.model.Occupation;
import fr.diginamic.model.Planning;
import fr.diginamic.model.ReservationVoiture;
import fr.diginamic.utils.QueryUtils;

public class ResaVehiculeDao {

	/**
	 * Methode requetant la base de donnée pour retourner la liste des
	 * occupations d'un chauffeur entre deux dates
	 * 
	 * @param dateDeDebut
	 * @param dateDeFin
	 * @param utilisateurCourant
	 * @return
	 */
	public List<Occupation> recupererLesOccupationsCourantes(LocalDate dateDeDebut, LocalDate dateDeFin,
			Employe utilisateurCourant) {
		return null;
	}

	/**
	 * Methode requetant la base de donnée pour retourner la liste des taches
	 * d'un jour pour un chauffeur
	 * 
	 * @param jourCourant
	 * @param utilisateurCourant
	 * @return
	 */
	public List<Planning> recupererLesTachesDuJourCourant(LocalDate jourCourant, Employe utilisateurCourant) {
		return null;
	}

	public void ajoutResaVehicule(ReservationVoiture reservationVoiture) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"INSERT INTO `RESAVEHICULE`(`rvh_datetimeDebut`,`rvh_datetimeFin`,`rvh_id_utilisateur`,`rvh_id_vehicule`) VALUES (");
		sb.append("'").append(reservationVoiture.getDateTimeDeDebut().format(DateTimeFormatter.ofPattern(
				"yyyy-MM-dd HH:mm"))).append("',");
		sb.append("'").append(reservationVoiture.getDateTimeDeFin().format(DateTimeFormatter.ofPattern(
				"yyyy-MM-dd HH:mm"))).append("',");
		sb.append("'").append(reservationVoiture.getIdUtilisateur()).append("',");
		sb.append("'").append(reservationVoiture.getVehicule().getId()).append("'");
		sb.append(")");
		QueryUtils.updateQuery(sb.toString());
	}

}
