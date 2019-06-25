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
import fr.diginamic.utils.QueryUtils;

public class CovoiturageDao {

	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static LocalTime convertToLocalTimeViaInstant(Date dateToConvert) {
		return LocalDateTime.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault()).toLocalTime();

	}

	public void unePlaceReserve(Integer idAnnonceCovoiturage) {

		QueryUtils.updateQuery(

				"update gestion_transport.covoiturage set cov_nbPlacesDispo  =cov_nbPlacesDispo -1 where cov_id="
						+ idAnnonceCovoiturage);

	}

	public void unePlaceReserveEnMoins(Integer idAnnonceCovoiturage) {

		QueryUtils.updateQuery(

				"update gestion_transport.covoiturage set cov_nbPlacesDispo  =cov_nbPlacesDispo +1 where cov_id="
						+ idAnnonceCovoiturage);

	}

	public void annulerAnnonce(Integer idAnnonceCovoiturage, Integer idUtilisateur) {

		QueryUtils.updateQuery(

				"delete from covoiturage where cov_id=" + idAnnonceCovoiturage + " and cov_uti_id=" + idUtilisateur);

	}

	public void insererNouvelleAnnonce(AnnonceCovoiturage annonceCovoiturage) {

		String dateDeDepart = annonceCovoiturage.getDateDeDepart()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		Integer nbPlacesDispo = annonceCovoiturage.getNbPlacesDisponibles();
		Integer idUtilissateur = annonceCovoiturage.getIdUtilisateur();
		String lieuDepart = annonceCovoiturage.getLieuDeDepart();
		Integer idVehicule = annonceCovoiturage.getIdVehicule();
		Integer idReservationVehiculeSociete = annonceCovoiturage.getIdReservationVehicule();
		String lieuArrive = annonceCovoiturage.getLieuDeDestination();
		// System.out.println(dateDeDepart);
		// System.out.println(nbPlacesDispo);
		// System.out.println(lieuDepart);
		// System.out.println(lieuArrive);
		System.out.println(idReservationVehiculeSociete);
		if (idReservationVehiculeSociete == null) {
			System.out.println("ok1");
			System.out.println(
					"insert into covoiturage (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,cov_uti_id,cov_idVehicule) values ("
							+ nbPlacesDispo + ",\"" + dateDeDepart + "\",\"" + lieuDepart + "\",\"" + lieuArrive
							+ "\",\"" + idUtilissateur + "\",\"" + idVehicule + "\")");
			QueryUtils.updateQuery(

					"insert into covoiturage (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,cov_uti_id,cov_idVehicule) values ("
							+ nbPlacesDispo + ",\"" + dateDeDepart + "\",\"" + lieuDepart + "\",\"" + lieuArrive
							+ "\",\"" + idUtilissateur + "\",\"" + idVehicule + "\")");
		} else {
			System.out.println("ok2");
			System.out.println(
					"insert into covoiturage (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,cov_uti_id,cov_idVehicule,cov_idReservationVehicule) values ("
							+ nbPlacesDispo + ",\"" + dateDeDepart + "\",\"" + lieuDepart + "\",\"" + lieuArrive
							+ "\",\"" + idUtilissateur + "\",\"" + idVehicule + "\",\"" + idReservationVehiculeSociete
							+ "\")");
			QueryUtils.updateQuery(

					"insert into covoiturage (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,cov_uti_id,cov_idVehicule,cov_idReservationVehicule) values ("
							+ nbPlacesDispo + ",\"" + dateDeDepart + "\",\"" + lieuDepart + "\",\"" + lieuArrive
							+ "\",\"" + idUtilissateur + "\",\"" + idVehicule + "\",\"" + idReservationVehiculeSociete
							+ "\")");
		}

	}

	public List<AnnonceCovoiturage> recupererLesAnnoncesAvecCritere(String lieuDeDepart, String lieuDeDestination,
			String dateDeDepart) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			if (!lieuDeDepart.equals("indeterminé") && !lieuDeDestination.equals("indeterminé")
					&& !dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from covoiturage where cov_lieuDepart=\"" + lieuDeDepart
								+ "\" and cov_lieuArrive=\"" + lieuDeDestination + "\" and cov_datetimeDebut>\""
								+ dateDeDepart + "\"");

			} else if (lieuDeDestination.equals("indeterminé") && !lieuDeDepart.equals("indeterminé")
					&& dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from covoiturage where cov_lieuDepart=\"" + lieuDeDepart + "\"");

			} else if (!lieuDeDestination.equals("indeterminé") && lieuDeDepart.equals("indeterminé")
					&& dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance().prepareStatement(
						"select * from covoiturage where cov_lieuArrive=\"" + lieuDeDestination + "\"");

			} else if (lieuDeDestination.equals("indeterminé") && lieuDeDepart.equals("indeterminé")
					&& !dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from covoiturage where cov_datetimeDebut>\"" + dateDeDepart + "\"");

			} else if (lieuDeDepart.equals("indeterminé") && !lieuDeDestination.equals("indeterminé")
					&& !dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from covoiturage where cov_lieuArrive=\"" + lieuDeDestination
								+ "\" and cov_datetimeDebut>\"" + dateDeDepart + "\"");

			} else if (!lieuDeDepart.equals("indeterminé") && lieuDeDestination.equals("indeterminé")
					&& !dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from covoiturage where cov_lieuDepart=\"" + lieuDeDepart
								+ "\" and cov_datetimeDebut>\"" + dateDeDepart + "\"");

			} else if (!lieuDeDepart.equals("indeterminé") && !lieuDeDestination.equals("indeterminé")
					&& dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from covoiturage where cov_lieuDepart=\"" + lieuDeDepart
								+ "\" and cov_lieuArrive=\"" + lieuDeDestination + "\"");

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
				// TODO PRENDRE EN COMPTE CHANGEMENT DE FORMAT cov_dateTimeDebut
				// EN DATE DANS BDD
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

	public List<AnnonceCovoiturage> recupererLesAnnoncesDisponiblesPourUtilisateur(Integer idUtilisateurCourant) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from gestion_transport.covoiturage WHERE cov_id not in (select cov_id from gestion_transport.covoiturage inner join gestion_transport.resacovoiturage on covoiturage.cov_id=resaCovoiturage.rco_idCovoiture where resaCovoiturage.rco_idUtilisateur="
							+ idUtilisateurCourant + ") and cov_datetimeDebut > CURDATE()");
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
