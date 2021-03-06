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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.utils.ConnectionUtils;
import fr.diginamic.utils.QueryUtils;

/**
 * Dao gérant l’acces à la table covoiturage
 * 
 * @author Kevin.s
 *
 */
public class CovoiturageDao {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(CovoiturageDao.class);

	/**
	 * méthode permettant de convertir une Date en LocaleDateTime
	 * 
	 * @param Date
	 * @return LocalDateTime
	 */
	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * méthode permettant de convertir une Date en LocalTime
	 * 
	 * @param Date
	 * @return LocalTime
	 */
	public static LocalTime convertToLocalTimeViaInstant(Date dateToConvert) {
		return LocalDateTime.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault()).toLocalTime();

	}

	/**
	 * méthode permettant de décrémenter le nombre de place disponible pour une
	 * annonce
	 * 
	 * @param idAnnonceCovoiturage
	 *            identifiant de l’annonce
	 */
	public void unePlaceReserve(Integer idAnnonceCovoiturage) {

		QueryUtils.updateQuery(

				"update COVOITURAGE set cov_nbPlacesDispo  =cov_nbPlacesDispo -1 where cov_id="
						+ idAnnonceCovoiturage);

	}

	/**
	 * méthode permettant de d’incrementer le nombre de place disponible pour
	 * une annonce
	 * 
	 * @param idAnnonceCovoiturage
	 *            identifiant de l’annonce
	 */
	public void unePlaceReserveEnMoins(Integer idAnnonceCovoiturage) {

		QueryUtils.updateQuery(

				"update COVOITURAGE set cov_nbPlacesDispo  =cov_nbPlacesDispo +1 where cov_id="
						+ idAnnonceCovoiturage);

	}

	/**
	 * méthode permettant de supprimer une annonce
	 * 
	 * @param idAnnonceCovoiturage
	 *            identifiant de l’annonce
	 * @param idUtilisateur
	 *            identifiant du responsable de l’annonce
	 */
	public void annulerAnnonce(Integer idAnnonceCovoiturage, Integer idUtilisateur) {

		QueryUtils.updateQuery(

				"delete from COVOITURAGE where cov_id=" + idAnnonceCovoiturage + " and cov_uti_id=" + idUtilisateur);

	}

	/**
	 * méthode permettant d’ajouter une nouvelle annonce
	 * 
	 * @param annonceCovoiturage
	 *            annonce du covoiturage
	 */
	public void insererNouvelleAnnonce(AnnonceCovoiturage annonceCovoiturage) {

		String dateDeDepart = annonceCovoiturage.getDateDeDepart()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		Integer nbPlacesDispo = annonceCovoiturage.getNbPlacesDisponibles();
		Integer idUtilissateur = annonceCovoiturage.getIdUtilisateur();
		String lieuDepart = annonceCovoiturage.getLieuDeDepart();
		Integer idVehicule = annonceCovoiturage.getIdVehicule();
		Integer idReservationVehiculeSociete = annonceCovoiturage.getIdReservationVehicule();
		String lieuArrive = annonceCovoiturage.getLieuDeDestination();

		System.out.println(idReservationVehiculeSociete);

		if (idReservationVehiculeSociete == 0) {
			System.out.println("ok1");
			System.out.println(
					"insert into COVOITURAGE (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,cov_uti_id,cov_idVehicule) values ("
							+ nbPlacesDispo + ",\"" + dateDeDepart + "\",\"" + lieuDepart + "\",\"" + lieuArrive
							+ "\",\"" + idUtilissateur + "\",\"" + idVehicule + "\")");
			QueryUtils.updateQuery(

					"insert into COVOITURAGE (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,cov_uti_id,cov_idVehicule) values ("
							+ nbPlacesDispo + ",\"" + dateDeDepart + "\",\"" + lieuDepart + "\",\"" + lieuArrive
							+ "\",\"" + idUtilissateur + "\",\"" + idVehicule + "\")");
		} else {
			System.out.println("ok2");
			System.out.println(
					"insert into COVOITURAGE (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,cov_uti_id,cov_idVehicule,cov_idReservationVehicule) values ("
							+ nbPlacesDispo + ",\"" + dateDeDepart + "\",\"" + lieuDepart + "\",\"" + lieuArrive
							+ "\",\"" + idUtilissateur + "\",\"" + idVehicule + "\",\"" + idReservationVehiculeSociete
							+ "\")");
			QueryUtils.updateQuery(

					"insert into COVOITURAGE (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,cov_uti_id,cov_idVehicule,cov_idReservationVehicule) values ("
							+ nbPlacesDispo + ",\"" + dateDeDepart + "\",\"" + lieuDepart + "\",\"" + lieuArrive
							+ "\",\"" + idUtilissateur + "\",\"" + idVehicule + "\",\"" + idReservationVehiculeSociete
							+ "\")");
		}

	}

	/**
	 * méthode permettant de récupérer une annonce selon certain critere
	 * 
	 * @param lieuDeDepart
	 * @param lieuDeDestination
	 * @param dateDeDepart
	 * @return List<AnnonceCovoiturage>
	 */
	public List<AnnonceCovoiturage> recupererLesAnnoncesAvecCritere(String lieuDeDepart, String lieuDeDestination,
			String dateDeDepart) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			if (!lieuDeDepart.equals("indeterminé") && !lieuDeDestination.equals("indeterminé")
					&& !dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from COVOITURAGE where cov_lieuDepart=\"" + lieuDeDepart
								+ "\" and cov_lieuArrive=\"" + lieuDeDestination + "\" and cov_datetimeDebut>\""
								+ dateDeDepart + "\"");

			} else if (lieuDeDestination.equals("indeterminé") && !lieuDeDepart.equals("indeterminé")
					&& dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from COVOITURAGE where cov_lieuDepart=\"" + lieuDeDepart + "\"");

			} else if (!lieuDeDestination.equals("indeterminé") && lieuDeDepart.equals("indeterminé")
					&& dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance().prepareStatement(
						"select * from COVOITURAGE where cov_lieuArrive=\"" + lieuDeDestination + "\"");

			} else if (lieuDeDestination.equals("indeterminé") && lieuDeDepart.equals("indeterminé")
					&& !dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from COVOITURAGE where cov_datetimeDebut>\"" + dateDeDepart + "\"");

			} else if (lieuDeDepart.equals("indeterminé") && !lieuDeDestination.equals("indeterminé")
					&& !dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from COVOITURAGE where cov_lieuArrive=\"" + lieuDeDestination
								+ "\" and cov_datetimeDebut>\"" + dateDeDepart + "\"");

			} else if (!lieuDeDepart.equals("indeterminé") && lieuDeDestination.equals("indeterminé")
					&& !dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from COVOITURAGE where cov_lieuDepart=\"" + lieuDeDepart
								+ "\" and cov_datetimeDebut>\"" + dateDeDepart + "\"");

			} else if (!lieuDeDepart.equals("indeterminé") && !lieuDeDestination.equals("indeterminé")
					&& dateDeDepart.equals("indeterminé")) {
				preparedStatement = ConnectionUtils.getInstance()
						.prepareStatement("select * from COVOITURAGE where cov_lieuDepart=\"" + lieuDeDepart
								+ "\" and cov_lieuArrive=\"" + lieuDeDestination + "\"");

			} else {
				preparedStatement = ConnectionUtils.getInstance().prepareStatement("select * from COVOITURAGE");

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
	 * méthode permettant de récupérer les annonces d’un utilisateur
	 * 
	 * @param idUtilisateurCourant
	 *            id de l’utilisateur
	 * @return List<AnnonceCovoiturage>
	 */
	public List<AnnonceCovoiturage> recupererLesAnnonces(Integer idUtilisateurCourant) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select * from COVOITURAGE where cov_uti_id=" + idUtilisateurCourant);
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
	 * méthode permettant de récuperer les annonces en cours d’un utilisateur
	 * 
	 * @param idUtilisateurCourant
	 *            identifiant de l’utilisateur
	 * @return List<AnnonceCovoiturage>
	 */
	public List<AnnonceCovoiturage> recupererLesAnnoncesEnCours(Integer idUtilisateurCourant) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			SERVICE_LOG.info("QUERYYYYYYY = " + "select * from COVOITURAGE where cov_uti_id=" + idUtilisateurCourant
					+ " AND cov_datetimeDebut >= NOW();");
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select * from COVOITURAGE where cov_uti_id=" + idUtilisateurCourant
							+ " AND cov_datetimeDebut >= NOW();");
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
	 * méthode permettant de récuperer les annonces passées d’un utilisateur
	 * 
	 * @param idUtilisateurCourant
	 *            identifiant de l’utilisateur
	 * @return List<AnnonceCovoiturage>
	 */
	public List<AnnonceCovoiturage> recupererLesAnnoncesPassees(Integer idUtilisateurCourant) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select * from COVOITURAGE where cov_uti_id=" + idUtilisateurCourant
							+ " AND cov_datetimeDebut < NOW();");
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
	 * méthode permettant de récupérer les annonces disponible pour un
	 * utilisateur
	 * 
	 * @param idUtilisateurCourant
	 *            identifiant de l’utilisateur
	 * @return List<AnnonceCovoiturage>
	 */
	public List<AnnonceCovoiturage> recupererLesAnnoncesDisponiblesPourUtilisateur(Integer idUtilisateurCourant) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from gestion_transport.COVOITURAGE WHERE cov_id not in (select cov_id from gestion_transport.covoiturage inner join gestion_transport.resacovoiturage on covoiturage.cov_id=resaCovoiturage.rco_idCovoiture where resaCovoiturage.rco_idUtilisateur="
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
	 * méthode permettant de récupérer une annonce en fonction de son id
	 * 
	 * @param idCovoiturage
	 *            identifiant du covoiturage
	 * @return AnnonceCovoiturage
	 */
	public AnnonceCovoiturage retrouverAnnonceCovoiturage(Integer idCovoiturage) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		AnnonceCovoiturage annonceCovoiturage = null;

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select * from COVOITURAGE where cov_id=" + idCovoiturage);
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
