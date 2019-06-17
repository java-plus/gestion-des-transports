package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.model.Employe;
import fr.diginamic.utils.ConnectionUtils;

public class CovoiturageDao {

	public List<AnnonceCovoiturage> recupererLesAnnonces(Employe utilisateurCourant) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AnnonceCovoiturage> listeDesAnnonces = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from covoiturage where idUtilisateur where cov_uti_id=" + utilisateurCourant.getId());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");

			while (resultSet.next()) {
				Integer id_utilisateur = resultSet.getInt("cov_id");
				Integer nbPlacesDispo = resultSet.getInt("cov_id");
				LocalDateTime dateHeureDebut = LocalDateTime.parse(resultSet.getString("cov-dateTimeDebut"),
						formatterDateTime);
				String adresseDepart = resultSet.getString("cov_lieuDepart");
				String adresseArrivee = resultSet.getString("cov_lieuArrive");
				LocalTime duree = LocalTime.parse(resultSet.getString("cov_duree"), formatterTime);
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
				Integer nbPlacesDispo = resultSet.getInt("cov_id");
				LocalDateTime dateHeureDebut = LocalDateTime.parse(resultSet.getString("cov-dateTimeDebut"),
						formatterDateTime);
				String adresseDepart = resultSet.getString("cov_lieuDepart");
				String adresseArrivee = resultSet.getString("cov_lieuArrive");
				LocalTime duree = LocalTime.parse(resultSet.getString("cov_duree"), formatterTime);
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
				Integer nbPlacesDispo = resultSet.getInt("cov_id");
				LocalDateTime dateHeureDebut = LocalDateTime.parse(resultSet.getString("cov-dateTimeDebut"),
						formatterDateTime);
				String adresseDepart = resultSet.getString("cov_lieuDepart");
				String adresseArrivee = resultSet.getString("cov_lieuArrive");
				LocalTime duree = LocalTime.parse(resultSet.getString("cov_duree"), formatterTime);
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
