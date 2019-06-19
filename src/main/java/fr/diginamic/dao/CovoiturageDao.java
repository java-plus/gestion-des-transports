package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.utils.ConnectionUtils;

public class CovoiturageDao {

	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static LocalTime convertToLocalTimeViaInstant(Date dateToConvert) {
		return LocalDateTime.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault()).toLocalTime();

	}

	public List<AnnonceCovoiturage> recupererLesAnnoncesAvecCritere(String lieuDeDepart, String lieuDeDestination) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			if (!lieuDeDepart.equals("indeterminé") && !lieuDeDestination.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from covoiturage where cov_lieuDepart=\"" + lieuDeDepart
								+ "\" and cov_lieuArrive=\"" + lieuDeDestination + "\"");

			} else if (lieuDeDestination.equals("indeterminé") && !lieuDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from covoiturage where cov_lieuDepart=\"" + lieuDeDepart + "\"");

			} else if (lieuDeDepart.equals("indeterminé") && !lieuDeDestination.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance().prepareStatement(
						"select * from covoiturage where cov_lieuArrive=\"" + lieuDeDestination + "\"");

			} else {
				preparedStatement = ConnectionUtils.getInstance().prepareStatement("select * from covoiturage");

			}
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");

			while (resultSet.next()) {
				Integer id_utilisateur = resultSet.getInt("cov_id");
				Integer nbPlacesDispo = resultSet.getInt("cov_nbPlacesDispo");

				LocalDateTime dateHeureDebut = LocalDateTime.parse(resultSet.getString("cov_dateTimeDebut"),
						formatterDateTime);
				String adresseDepart = resultSet.getString("cov_lieuDepart");
				String adresseArrivee = resultSet.getString("cov_lieuArrive");
				Integer duree = resultSet.getInt("cov_duree");
				// Date duree =
				// resultSet.getDate(resultSet.getString("cov_duree"));
				// LocalTime duree2 = convertToLocalTimeViaInstant(duree);

				Integer distance = resultSet.getInt("cov_distance");
				Integer idReservationVehicule = resultSet.getInt("cov_idReservationVehicule");
				Integer idUtilisateur = resultSet.getInt("cov_uti_id");
				Integer idVehicule = resultSet.getInt("cov_idVehicule");

				listeDesAnnonces
						.add(new AnnonceCovoiturage(id_utilisateur, nbPlacesDispo, dateHeureDebut, adresseDepart,
								adresseArrivee, duree, distance, idReservationVehicule, idUtilisateur, idVehicule));
			}

			return listeDesAnnonces;
		} catch (SQLException e) {
			// SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le resultSet",
					// e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le statement",
					// e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	public List<AnnonceCovoiturage> recupererLesAnnonces(Integer idUtilisateurCourant) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select * from covoiturage where cov_uti_id=" + idUtilisateurCourant);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");

			while (resultSet.next()) {
				Integer id_utilisateur = resultSet.getInt("cov_id");
				Integer nbPlacesDispo = resultSet.getInt("cov_nbPlacesDispo");

				LocalDateTime dateHeureDebut = LocalDateTime.parse(resultSet.getString("cov_dateTimeDebut"),
						formatterDateTime);
				String adresseDepart = resultSet.getString("cov_lieuDepart");
				String adresseArrivee = resultSet.getString("cov_lieuArrive");
				Integer duree = resultSet.getInt("cov_duree");
				// Date duree =
				// resultSet.getDate(resultSet.getString("cov_duree"));
				// LocalTime duree2 = convertToLocalTimeViaInstant(duree);

				Integer distance = resultSet.getInt("cov_distance");
				Integer idReservationVehicule = resultSet.getInt("cov_idReservationVehicule");
				Integer idUtilisateur = resultSet.getInt("cov_uti_id");
				Integer idVehicule = resultSet.getInt("cov_idVehicule");

				listeDesAnnonces
						.add(new AnnonceCovoiturage(id_utilisateur, nbPlacesDispo, dateHeureDebut, adresseDepart,
								adresseArrivee, duree, distance, idReservationVehicule, idUtilisateur, idVehicule));
			}

			return listeDesAnnonces;
		} catch (SQLException e) {
			// SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le resultSet",
					// e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le statement",
					// e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	public List<AnnonceCovoiturage> recupererLesAnnonces() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement("select * from covoiturage");
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");

			while (resultSet.next()) {
				Integer id_utilisateur = resultSet.getInt("cov_id");
				Integer nbPlacesDispo = resultSet.getInt("cov_nbPlacesDispo");
				LocalDateTime dateHeureDebut = LocalDateTime.parse(resultSet.getString("cov_datetimeDebut"),
						formatterDateTime);
				String adresseDepart = resultSet.getString("cov_lieuDepart");
				String adresseArrivee = resultSet.getString("cov_lieuArrive");
				Integer duree = resultSet.getInt("cov_duree");
				// LocalTime duree =
				// LocalTime.parse(resultSet.getString("cov_duree"),
				// formatterTime);
				Integer distance = resultSet.getInt("cov_distance");
				Integer idReservationVehicule = resultSet.getInt("cov_idReservationVehicule");
				Integer idUtilisateur = resultSet.getInt("cov_uti_id");
				Integer idVehicule = resultSet.getInt("cov_idVehicule");

				listeDesAnnonces
						.add(new AnnonceCovoiturage(id_utilisateur, nbPlacesDispo, dateHeureDebut, adresseDepart,
								adresseArrivee, duree, distance, idReservationVehicule, idUtilisateur, idVehicule));
			}

			return listeDesAnnonces;
		} catch (SQLException e) {
			// SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le resultSet",
					// e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le statement",
					// e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	public AnnonceCovoiturage retrouverAnnonceCovoiturage(Integer idCovoiturage) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		AnnonceCovoiturage annonceCovoiturage = null;

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select * from covoiturage where cov_id=" + idCovoiturage);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");

			while (resultSet.next()) {
				Integer id_utilisateur = resultSet.getInt("cov_id");
				Integer nbPlacesDispo = resultSet.getInt("cov_nbPlacesDispo");
				LocalDateTime dateHeureDebut = LocalDateTime.parse(resultSet.getString("cov_dateTimeDebut"),
						formatterDateTime);
				String adresseDepart = resultSet.getString("cov_lieuDepart");
				String adresseArrivee = resultSet.getString("cov_lieuArrive");
				Integer duree = resultSet.getInt("cov_duree");
				// LocalTime duree =
				// LocalTime.parse(resultSet.getString("cov_duree"),
				// formatterTime);
				Integer distance = resultSet.getInt("cov_distance");
				Integer idReservationVehicule = resultSet.getInt("cov_idReservationVehicule");
				Integer idUtilisateur = resultSet.getInt("cov_uti_id");
				Integer idVehicule = resultSet.getInt("cov_idVehicule");

				annonceCovoiturage = new AnnonceCovoiturage(id_utilisateur, nbPlacesDispo, dateHeureDebut,
						adresseDepart, adresseArrivee, duree, distance, idReservationVehicule, idUtilisateur,
						idVehicule);
			}

			return annonceCovoiturage;
		} catch (SQLException e) {
			// SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le resultSet",
					// e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le statement",
					// e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}
	}

}
