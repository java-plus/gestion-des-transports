package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.utils.ConnectionUtils;
import fr.diginamic.utils.QueryUtils;

/**
 * Dao gérant l’acces à la base de donnée resaCovoiturage
 * 
 * @author Kevin.s
 *
 */
public class ResaCovoiturageDao {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ResaCovoiturageDao.class);

	/**
	 * méthode permettant de reserver un covoiturage
	 * 
	 * @param idAnnonceCovoiturage
	 * @param idUtilisateur
	 */
	public void reserverCovoiturage(Integer idAnnonceCovoiturage, Integer idUtilisateur) {

		QueryUtils.updateQuery(

				"INSERT INTO RESACOVOITURAGE (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (" + idAnnonceCovoiturage
						+ "," + idUtilisateur + ")");

	}

	/**
	 * méthode permettant d’annuler une reservation de covoiturage
	 * 
	 * @param idAnnonceCovoiturage
	 * @param idUtilisateur
	 */
	public void annulerCovoiturage(Integer idAnnonceCovoiturage, Integer idUtilisateur) {

		QueryUtils.updateQuery(

				"DELETE from RESACOVOITURAGE where rco_idCovoiture=" + idAnnonceCovoiturage + " and rco_idUtilisateur="
						+ idUtilisateur);

	}

	/**
	 * méthode permettant d’annuler toutes les reservations d’un covoiturage
	 * 
	 * @param idAnnonceCovoiturage
	 */
	public void annulerToutesLesReservations(Integer idAnnonceCovoiturage) {

		QueryUtils.updateQuery(

				"DELETE from RESACOVOITURAGE where rco_idCovoiture=" + idAnnonceCovoiturage);

	}

	/**
	 * Méthode permettant de récuperer les annonces de covoiturage en cours (non
	 * passées) sur lesquels l’utilisateur a reservé une place
	 * 
	 * @param idUtilisateurCourant
	 * @return List<AnnonceCovoiturage>
	 */
	public List<AnnonceCovoiturage> recupererLesReservationsEnCours(Integer idUtilisateurCourant) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		PreparedStatement preparedStatementAnnonceCovoiturage = null;
		ResultSet resultSetAnnonceCovoiturage = null;

		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from covoiturage inner join resacovoiturage on covoiturage.cov_id=resaCovoiturage.rco_idCovoiture where cov_datetimeDebut >= NOW() AND resaCovoiturage.rco_idUtilisateur="
							+ idUtilisateurCourant);
			resultSet = preparedStatement.executeQuery();
			DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			ConnectionUtils.doCommit();

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
	 * Méthode permettant de récuperer les annonces de covoiturage passées sur
	 * lesquelles l’utilisateur a reservé une place
	 * 
	 * @param idUtilisateurCourant
	 * @return List<AnnonceCovoiturage>
	 */
	public List<AnnonceCovoiturage> recupererLesReservationsPassees(Integer idUtilisateurCourant) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		PreparedStatement preparedStatementAnnonceCovoiturage = null;
		ResultSet resultSetAnnonceCovoiturage = null;

		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from covoiturage inner join resacovoiturage on covoiturage.cov_id=resaCovoiturage.rco_idCovoiture where cov_datetimeDebut < NOW() AND resaCovoiturage.rco_idUtilisateur="
							+ idUtilisateurCourant);
			resultSet = preparedStatement.executeQuery();
			DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			ConnectionUtils.doCommit();

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
	 * méthode permettant de recuperer les annonces de covoiturage sur lesquels
	 * l’utilisateur à reservé une place
	 * 
	 * @param idUtilisateurCourant
	 * @return List<AnnonceCovoiturage>
	 */
	public List<AnnonceCovoiturage> recupererLesReservations(Integer idUtilisateurCourant) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		PreparedStatement preparedStatementAnnonceCovoiturage = null;
		ResultSet resultSetAnnonceCovoiturage = null;

		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from covoiturage inner join resacovoiturage on covoiturage.cov_id=resaCovoiturage.rco_idCovoiture where resaCovoiturage.rco_idUtilisateur="
							+ idUtilisateurCourant);
			resultSet = preparedStatement.executeQuery();
			DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			ConnectionUtils.doCommit();

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
	 * méthode permettant de récuperer le nombre d’utilisateur qui ont reserver sur
	 * le covoiturage
	 * 
	 * @param idAnnonceCovoiturage
	 * @return Integer
	 */
	public Integer combienDePersonnesOntReserve(Integer idAnnonceCovoiturage) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		PreparedStatement preparedStatementAnnonceCovoiturage = null;
		ResultSet resultSetAnnonceCovoiturage = null;

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select count(rco_id) from resacovoiturage where rco_idCovoiture=" + idAnnonceCovoiturage);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();

			Integer nbReservations = 0;
			while (resultSet.next()) {

				nbReservations = resultSet.getInt("count(rco_id)");

			}

			return nbReservations;
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
