package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
				"INSERT INTO `RESAVEHICULE`(`rvh_datetimeDebut`,`rvh_datetimeFin`,`rvh_id_utilisateur`,`rvh_id_vehicule`,`rvh_besoin_chauffeur`) VALUES (");
		sb.append("'").append(reservationVoiture.getDateTimeDeDebut().format(DateTimeFormatter.ofPattern(
				"yyyy-MM-dd HH:mm"))).append("',");
		sb.append("'").append(reservationVoiture.getDateTimeDeFin().format(DateTimeFormatter.ofPattern(
				"yyyy-MM-dd HH:mm"))).append("',");
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
	 * @param immatriculation
	 *            : String immatriculation du véhicule
	 * @return Map<ReservationVoiture, String> : map contenant les réservations
	 *         futures par rapport à la date actuelle et le responsable de
	 *         chaque réservation
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
	 * Methode comme la pr�c�dente mais sans le param�tre immatriculation
	 */
	public List<ReservationVoiture> recupererReservationsFuturesDUneVoiture() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		LocalDateTime dateDeDebut = null;
		LocalDateTime dateDeFin = null;
		String limmatriculation = null;
		String marque = null;
		String modele = null;
		
		//String nomPrenomDuResponsable = null;
		StringBuilder selectQuery = new StringBuilder();
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		List<ReservationVoiture> ListeDesReservationsVoituresFutur = new ArrayList<>();

		try {
			selectQuery.append(
					"select resavehicule.rvh_datetimeDebut as DATE_DEBUT, resavehicule.rvh_datetimeFin as DATE_FIN, vehicule.vhc_immatriculation as IMMATRICULATION, vehicule.vhc_marque as MARQUE, vehicule.vhc_modele as MODELE");
			selectQuery.append(" from resavehicule, vehicule, utilisateur");
			selectQuery.append(" where resavehicule.rvh_id_vehicule=vehicule.vhc_id and resavehicule.rvh_id_utilisateur=utilisateur.uti_id and resavehicule.rvh_datetimeFin > now();");

			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			SERVICE_LOG.info("Requête de recupererReservationsFuturesDUneVoiture() lancée.");
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				dateDeDebut = LocalDateTime.parse(resultSet.getString("DATE_DEBUT"), inputFormatter);
				dateDeFin = LocalDateTime.parse(resultSet.getString("DATE_FIN"), inputFormatter);
				limmatriculation = resultSet.getString("IMMATRICULATION");
				marque = resultSet.getString("MARQUE");
				modele = resultSet.getString("MODELE");
				
				ListeDesReservationsVoituresFutur.add(new ReservationVoiture(dateDeDebut, dateDeFin, limmatriculation, marque, modele));
			}

			return ListeDesReservationsVoituresFutur;
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
	 * @param immatriculation
	 *            : String immatriculation du véhicule
	 * @return Map<ReservationVoiture, String> : map contenant les réservations
	 *         futures par rapport à la date actuelle et le responsable de
	 *         chaque réservation
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
	
	/**
	 * Methode comme la pr�c�dente mais sans le param�tre immatriculation
	 */
	public List<ReservationVoiture> recupererReservationsPasseesDUneVoiture() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		LocalDateTime dateDeDebut = null;
		LocalDateTime dateDeFin = null;
		String limmatriculation = null;
		String marque = null;
		String modele = null;
		
		//String nomPrenomDuResponsable = null;
		StringBuilder selectQuery = new StringBuilder();
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		List<ReservationVoiture> ListeDesReservationsVoituresPassees = new ArrayList<>();

		try {
			selectQuery.append(
					"select resavehicule.rvh_datetimeDebut as DATE_DEBUT, resavehicule.rvh_datetimeFin as DATE_FIN, vehicule.vhc_immatriculation as IMMATRICULATION, vehicule.vhc_marque as MARQUE, vehicule.vhc_modele as MODELE");
			selectQuery.append(" from resavehicule, vehicule, utilisateur");
			selectQuery.append(" where resavehicule.rvh_id_vehicule=vehicule.vhc_id and resavehicule.rvh_id_utilisateur=utilisateur.uti_id and resavehicule.rvh_datetimeFin < now();");

			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			SERVICE_LOG.info("Requête de recupererReservationsFuturesDUneVoiture() lancée.");
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				dateDeDebut = LocalDateTime.parse(resultSet.getString("DATE_DEBUT"), inputFormatter);
				dateDeFin = LocalDateTime.parse(resultSet.getString("DATE_FIN"), inputFormatter);
				limmatriculation = resultSet.getString("IMMATRICULATION");
				marque = resultSet.getString("MARQUE");
				modele = resultSet.getString("MODELE");
				
				ListeDesReservationsVoituresPassees.add(new ReservationVoiture(dateDeDebut, dateDeFin, limmatriculation, marque, modele));
			}

			return ListeDesReservationsVoituresPassees;
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
