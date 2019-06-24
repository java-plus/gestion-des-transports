package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.model.Employe;
import fr.diginamic.model.Occupation;
import fr.diginamic.model.Planning;
import fr.diginamic.model.ReservationVoiture;
import fr.diginamic.utils.ConnectionUtils;
import fr.diginamic.utils.QueryUtils;

public class ResaVehiculeDao {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ResaVehiculeDao.class);

	/**
	 * Methode requetant la base de donnée pour retourner la liste des occupations
	 * d'un chauffeur entre deux dates
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

	public Boolean isVehiculeDisponible(Integer idDuVehicule, LocalDateTime dateDeDebut, LocalDateTime dateDeFin) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuilder selectQuery = new StringBuilder();
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		try {
			selectQuery.append(
					"SELECT re.rvh_datetimeDebut, re.rvh_datetimeFin, re.rvh_id_chauffeur FROM gestion_transport.RESAVEHICULE re WHERE (rvh_id_vehicule = \"");
			selectQuery.append(idDuVehicule);
			selectQuery.append("\" AND (((\"");
			selectQuery.append(dateDeDebut);
			selectQuery.append("\" BETWEEN rvh_datetimeDebut AND rvh_datetimeFin) XOR (\"");
			selectQuery.append(dateDeDebut);
			selectQuery.append("\" < rvh_datetimeDebut)) AND ((\"");
			selectQuery.append(dateDeFin);
			selectQuery.append("\" BETWEEN rvh_datetimeDebut AND rvh_datetimeFin) XOR \"");
			selectQuery.append(dateDeFin);
			selectQuery.append("\" > rvh_datetimeFin)));");
			SERVICE_LOG.info("requete : " + selectQuery);
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			if (!resultSet.isBeforeFirst()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le resultSet", e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le statement", e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}
	}

	/**
	 * Methode requetant la base de donnée pour retourner la liste des taches d'un
	 * jour pour un chauffeur
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
				"INSERT INTO `RESAVEHICULE`(`rvh_datetimeDebut`,`rvh_datetimeFin`,`rvh_id_utilisateur`,`rvh_id_vehicule`,`rvh_besoin_chauffeur`) VALUES (");
		sb.append("'")
				.append(reservationVoiture.getDateTimeDeDebut().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
				.append("',");
		sb.append("'")
				.append(reservationVoiture.getDateTimeDeFin().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
				.append("',");
		sb.append("'").append(reservationVoiture.getIdUtilisateur()).append("',");
		sb.append("'").append(reservationVoiture.getVehicule().getId()).append("',");
		sb.append("'").append(reservationVoiture.getBesoinChauffeur()).append("'");
		sb.append(")");
		QueryUtils.updateQuery(sb.toString());
	}

	/**
	 * Méthode qui retourne la map des réservations futures d'un véhicule par
	 * rapport à la date actuelle.
	 * 
	 * @param immatriculation : String immatriculation du véhicule
	 * @return Map<ReservationVoiture, String> : map contenant les réservations
	 *         futures par rapport à la date actuelle et le responsable de chaque
	 *         réservation
	 */
	public Map<ReservationVoiture, String> recupererReservationsFuturesDUneVoiture(String immatriculation) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		LocalDateTime dateDeDebut = null;
		LocalDateTime dateDeFin = null;
		String nomPrenomDuResponsable = null;
		StringBuilder selectQuery = new StringBuilder();
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Map<ReservationVoiture, String> mapDesReservations = new HashMap<>();

		try {
			selectQuery.append(
					"SELECT re.rvh_datetimeDebut, re.rvh_datetimeFin, re.rvh_id_chauffeur, ut.uti_nom, ut.uti_prenom FROM gestion_transport.RESAVEHICULE re ");
			selectQuery.append("INNER JOIN VEHICULE ve ON ve.vhc_id = re.rvh_id_vehicule ");
			selectQuery.append("INNER JOIN UTILISATEUR ut ON re.rvh_id_utilisateur = ut.uti_id ");
			selectQuery.append("WHERE re.rvh_datetimeFin > now() AND ve.vhc_immatriculation = \"");
			selectQuery.append(immatriculation);
			selectQuery.append("\";");
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			SERVICE_LOG.info("Requête de recupererReservationsFuturesDUneVoiture(String immatriculation) lancée.");
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				dateDeFin = LocalDateTime.parse(resultSet.getString("rvh_datetimeFin"), inputFormatter);
				dateDeDebut = LocalDateTime.parse(resultSet.getString("rvh_datetimeDebut"), inputFormatter);
				ReservationVoiture reservation = new ReservationVoiture();
				reservation.setDateTimeDeDebut(dateDeDebut);
				reservation.setDateTimeDeFin(dateDeFin);
				nomPrenomDuResponsable = resultSet.getString("uti_prenom") + " " + resultSet.getString("uti_nom");
				mapDesReservations.put(reservation, nomPrenomDuResponsable);
			}

			return mapDesReservations;
		} catch (SQLException e) {
			SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le resultSet", e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le statement", e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}
	}

	/**
	 * Méthode qui retourne la map des réservations passées d'un véhicule par
	 * rapport à la date actuelle.
	 * 
	 * @param immatriculation : String immatriculation du véhicule
	 * @return Map<ReservationVoiture, String> : map contenant les réservations
	 *         futures par rapport à la date actuelle et le responsable de chaque
	 *         réservation
	 */
	public Map<ReservationVoiture, String> recupererReservationsPasseesDUneVoiture(String immatriculation) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		LocalDateTime dateDeDebut = null;
		LocalDateTime dateDeFin = null;
		String nomPrenomDuResponsable = null;
		StringBuilder selectQuery = new StringBuilder();
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		Map<ReservationVoiture, String> mapDesReservations = new HashMap<>();

		try {
			selectQuery.append(
					"SELECT re.rvh_datetimeDebut, re.rvh_datetimeFin, re.rvh_id_chauffeur, ut.uti_nom, ut.uti_prenom FROM gestion_transport.RESAVEHICULE re ");
			selectQuery.append("INNER JOIN VEHICULE ve ON ve.vhc_id = re.rvh_id_vehicule ");
			selectQuery.append("INNER JOIN UTILISATEUR ut ON re.rvh_id_utilisateur = ut.uti_id ");
			selectQuery.append("WHERE re.rvh_datetimeFin < now() AND ve.vhc_immatriculation = \"");
			selectQuery.append(immatriculation);
			selectQuery.append("\";");
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			SERVICE_LOG.info("Requête de recupererReservationsPasseesDUneVoiture(String immatriculation) lancée.");
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				// rvh_id, rvh_datetimeDebut, rvh_datetimeFin,
				// rvh_id_utilisateur,
				// rvh_id_chauffeur, rvh_id_vehicule
				dateDeFin = LocalDateTime.parse(resultSet.getString("rvh_datetimeFin"), inputFormatter);
				dateDeDebut = LocalDateTime.parse(resultSet.getString("rvh_datetimeDebut"), inputFormatter);
				ReservationVoiture reservation = new ReservationVoiture();
				reservation.setDateTimeDeDebut(dateDeDebut);
				reservation.setDateTimeDeFin(dateDeFin);
				nomPrenomDuResponsable = resultSet.getString("uti_prenom") + " " + resultSet.getString("uti_nom");
				mapDesReservations.put(reservation, nomPrenomDuResponsable);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				String formattedDateTime = dateDeDebut.format(formatter); // "1986-04-08
																			// 12:30"
			}

			return mapDesReservations;
		} catch (SQLException e) {
			SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le resultSet", e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le statement", e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

}
