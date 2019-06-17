package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.model.Chauffeur;
import fr.diginamic.utils.ConnectionUtils;

public class UtilisateurDao {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(UtilisateurDao.class);

	public List<Chauffeur> recupererListeDesChauffeurs() {
		return null;
	}

	/**
	 * Retourne l'id de l'utilisateur dans la base de données. Retourne null s'il
	 * n'a rien trouvé.
	 * 
	 * @param email : email de l'utilisateur
	 * @return (String) id de l'utilisateur
	 */
	public String getUserId(String email) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String id = null;
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append("SELECT uti_id FROM gestion_transport.UTILISATEUR WHERE uti_email = \"");
			selectQuery.append(email);
			selectQuery.append("\";");
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			if (resultSet.next()) {
				id = resultSet.getString("uti_id");
			}
			return id;
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
	 * Retourne le mot de passe hashé de l'utilisateur.
	 * 
	 * @param id (String) : id de l'utilisateur
	 * @return String : le mot de passe hashé
	 */
	public String getUserPwd(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String password = null;
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append("SELECT uti_mdp FROM gestion_transport.UTILISATEUR WHERE uti_id = \"");
			selectQuery.append(id);
			selectQuery.append("\";");
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			if (resultSet.next()) {
				password = resultSet.getString("uti_mdp");
			}
			return password;
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
	 * Retourne plusieurs valeurs de l'utilisateur pour stockage dans la session.
	 * 
	 * @param id : identifiant de l'utilisateur
	 * @return Map<String, String> : les valeurs utiles pendant la navigation
	 */
	public List<String> getUserInfosForSession(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<String> userInfos = new ArrayList<>();
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append(
					"SELECT uti_id, uti_nom, uti_prenom, uti_statut FROM gestion_transport.UTILISATEUR WHERE uti_id = \"");
			selectQuery.append(id);
			selectQuery.append("\";");
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				userInfos.add(resultSet.getString("uti_id"));
				userInfos.add(resultSet.getString("uti_nom"));
				userInfos.add(resultSet.getString("uti_prenom"));
				userInfos.add(resultSet.getString("uti_statut"));
			}
			return userInfos;
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
