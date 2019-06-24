package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.utils.ConnectionUtils;
import fr.diginamic.utils.QueryUtils;

public class ResaCovoiturageDao {

	public void reserverCovoiturage(Integer idAnnonceCovoiturage, Integer idUtilisateur) {

		QueryUtils.updateQuery(

				"INSERT INTO RESACOVOITURAGE (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (" + idAnnonceCovoiturage
						+ "," + idUtilisateur + ")");

	}

	public void annulerCovoiturage(Integer idAnnonceCovoiturage, Integer idUtilisateur) {
		System.out.println(idAnnonceCovoiturage);
		System.out.println(idUtilisateur);
		QueryUtils.updateQuery(

				"DELETE from RESACOVOITURAGE where rco_idCovoiture=" + idAnnonceCovoiturage + " and rco_idUtilisateur="
						+ idUtilisateur);

	}

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

}
