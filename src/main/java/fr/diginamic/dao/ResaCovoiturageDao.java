package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.model.Employe;
import fr.diginamic.model.ReservationCovoiturage;
import fr.diginamic.utils.ConnectionUtils;

public class ResaCovoiturageDao {

	public List<ReservationCovoiturage> recupererLesReservations(Employe utilisateurCourant) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		PreparedStatement preparedStatementAnnonceCovoiturage = null;
		ResultSet resultSetAnnonceCovoiturage = null;

		List<ReservationCovoiturage> listeDesReservations = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from resaCovoiturage where rco_idUtilisateur=" + utilisateurCourant.getId());
			resultSet = preparedStatement.executeQuery();

			ConnectionUtils.doCommit();

			while (resultSet.next()) {

				Integer idReservationCovoiturage = resultSet.getInt("rco_id");
				Integer idCovoiturage = resultSet.getInt("rco_idCovoiturage");
				Integer idUtilisateur = resultSet.getInt("rco_idUtilisateur");

				CovoiturageDao coivoiturageDao = new CovoiturageDao();
				AnnonceCovoiturage annonceCovoiturage = coivoiturageDao.retrouverAnnonceCovoiturage(idCovoiturage);

				listeDesReservations.add(new ReservationCovoiturage(idReservationCovoiturage, idCovoiturage,
						idUtilisateur, annonceCovoiturage));
			}

			return listeDesReservations;
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
