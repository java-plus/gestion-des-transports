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
import fr.diginamic.model.Collaborateur;
import fr.diginamic.model.Employe;
import fr.diginamic.utils.ConnectionUtils;
import fr.diginamic.utils.QueryUtils;

/**
 * Dao gérant l’acces à la base de données utilisateur
 * 
 * @author Kevin.s
 *
 */
public class UtilisateurDao {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(UtilisateurDao.class);

	/**
	 * Récupère tous les chauffeurs de la base de données.
	 * 
	 * @return List<Chauffeur> Tous les chauffeurs de la base de données (avec
	 *         prénom, nom, email, permis, photo, téléphone).
	 */
	public List<Chauffeur> recupererListeDesChauffeurs() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Chauffeur> listeDesChauffeurs = new ArrayList<>();
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append(
					"SELECT uti_prenom, uti_nom, uti_email, uti_permis, uti_photo, uti_tel FROM UTILISATEUR WHERE uti_statut = 'chauffeur';");
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				String prenom = resultSet.getString("uti_prenom");
				String nom = resultSet.getString("uti_nom");
				String email = resultSet.getString("uti_email");
				String permis = resultSet.getString("uti_permis");
				String photo = resultSet.getString("uti_photo");
				String tel = resultSet.getString("uti_tel");
				Chauffeur chauffeur = new Chauffeur();
				chauffeur.setPrenom(prenom);
				chauffeur.setEmail(email);
				chauffeur.setNom(nom);
				chauffeur.setPermis(permis);
				chauffeur.setPhoto(photo);
				chauffeur.setTelephone(tel);
				listeDesChauffeurs.add(chauffeur);
			}
			return listeDesChauffeurs;
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
	 * Retourne l'id de l'utilisateur dans la base de données. Retourne null
	 * s'il n'a rien trouvé.
	 * 
	 * @param email
	 *            : email de l'utilisateur
	 * @return (String) id de l'utilisateur
	 */
	public String getUserId(String email) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String id = null;
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append("SELECT uti_id FROM UTILISATEUR WHERE uti_email = \"");
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
	 * @param id
	 *            (String) : id de l'utilisateur
	 * @return String : le mot de passe hashé
	 */
	public String getUserPwd(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String password = null;
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append("SELECT uti_mdp FROM UTILISATEUR WHERE uti_id = \"");
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
	 * Retourne plusieurs valeurs de l'utilisateur pour stockage dans la
	 * session.
	 * 
	 * @param id
	 *            : identifiant de l'utilisateur
	 * @return Map<String, String> : les valeurs utiles pendant la navigation
	 */
	public List<String> getUserInfosForSession(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<String> userInfos = new ArrayList<>();
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append(
					"SELECT uti_id, uti_nom, uti_prenom, uti_statut FROM UTILISATEUR WHERE uti_id = \"");
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

	/**
	 * Ajoute un chauffeur dans la base de données.
	 * 
	 * @param chauffeur
	 *            : objet contenant tous les différents attributs de
	 *            l'utilisateur chauffeur, sauf l'id
	 */
	public void ajouterChauffeur(Chauffeur chauffeur) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"INSERT INTO `UTILISATEUR`(`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`, `uti_matricule`, `uti_permis`, `uti_photo`, `uti_tel`) VALUES (");
		sb.append("'chauffeur',");
		sb.append("'");
		sb.append(chauffeur.getNom());
		sb.append("', ");
		sb.append("'");
		sb.append(chauffeur.getPrenom());
		sb.append("', ");
		sb.append("'");
		sb.append(chauffeur.getEmail());
		sb.append("', ");
		sb.append("'");
		sb.append(chauffeur.getMdp());
		sb.append("', ");
		sb.append("'");
		sb.append(chauffeur.getMatricule());
		sb.append("', ");
		sb.append("'");
		sb.append(chauffeur.getPermis());
		sb.append("', ");
		sb.append("'");
		sb.append(chauffeur.getPhoto());
		sb.append("', ");
		sb.append("'");
		sb.append(chauffeur.getTelephone());
		sb.append("');");

		QueryUtils.updateQuery(sb.toString());
	}

	/**
	 * Récupère la liste des chauffeurs (dont le matricule correspond) de la
	 * base de données.
	 * 
	 * @param matricule
	 *            String matricule du chauffeur
	 * @return List<Chauffeur> La liste de tous les chauffeurs qui
	 *         correspondent.
	 */
	public List<Chauffeur> recupererLesChauffeursParMatricule(String matricule) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Chauffeur> listeDesChauffeurs = new ArrayList<>();
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append(
					"SELECT uti_prenom, uti_nom, uti_email, uti_permis, uti_photo, uti_tel FROM UTILISATEUR WHERE uti_statut = 'chauffeur' AND uti_matricule = \"");
			selectQuery.append(matricule);
			selectQuery.append("\";");
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				String prenom = resultSet.getString("uti_prenom");
				String nom = resultSet.getString("uti_nom");
				String email = resultSet.getString("uti_email");
				String permis = resultSet.getString("uti_permis");
				String photo = resultSet.getString("uti_photo");
				String tel = resultSet.getString("uti_tel");
				Chauffeur chauffeur = new Chauffeur();
				chauffeur.setPrenom(prenom);
				chauffeur.setEmail(email);
				chauffeur.setNom(nom);
				chauffeur.setPermis(permis);
				chauffeur.setPhoto(photo);
				chauffeur.setTelephone(tel);
				listeDesChauffeurs.add(chauffeur);
			}
			return listeDesChauffeurs;
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
	 * méthode permettant de récuperer les chauffeurs par leur prénom
	 * 
	 * @param prenom
	 * @return List<Chauffeur>
	 */
	public List<Chauffeur> recupererLesChauffeursParPrenom(String prenom) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Chauffeur> listeDesChauffeurs = new ArrayList<>();
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append(
					"SELECT uti_prenom, uti_nom, uti_email, uti_permis, uti_photo, uti_tel FROM UTILISATEUR WHERE uti_statut = 'chauffeur' AND uti_prenom = \"");
			selectQuery.append(prenom);
			selectQuery.append("\";");
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				prenom = resultSet.getString("uti_prenom");
				String nom = resultSet.getString("uti_nom");
				String email = resultSet.getString("uti_email");
				String permis = resultSet.getString("uti_permis");
				String photo = resultSet.getString("uti_photo");
				String tel = resultSet.getString("uti_tel");
				Chauffeur chauffeur = new Chauffeur();
				chauffeur.setPrenom(prenom);
				chauffeur.setEmail(email);
				chauffeur.setNom(nom);
				chauffeur.setPermis(permis);
				chauffeur.setPhoto(photo);
				chauffeur.setTelephone(tel);
				listeDesChauffeurs.add(chauffeur);
			}
			return listeDesChauffeurs;
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
	 * méthode permettant de récuperer les chauffeurs par leur nom
	 * 
	 * @param nom
	 * @return List<Chauffeur>
	 */
	public List<Chauffeur> recupererLesChauffeursParNom(String nom) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Chauffeur> listeDesChauffeurs = new ArrayList<>();
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append(
					"SELECT uti_prenom, uti_nom, uti_email, uti_permis, uti_photo, uti_tel FROM UTILISATEUR WHERE uti_statut = 'chauffeur' AND uti_nom = \"");
			selectQuery.append(nom);
			selectQuery.append("\";");
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				String prenom = resultSet.getString("uti_prenom");
				nom = resultSet.getString("uti_nom");
				String email = resultSet.getString("uti_email");
				String permis = resultSet.getString("uti_permis");
				String photo = resultSet.getString("uti_photo");
				String tel = resultSet.getString("uti_tel");
				Chauffeur chauffeur = new Chauffeur();
				chauffeur.setPrenom(prenom);
				chauffeur.setEmail(email);
				chauffeur.setNom(nom);
				chauffeur.setPermis(permis);
				chauffeur.setPhoto(photo);
				chauffeur.setTelephone(tel);
				listeDesChauffeurs.add(chauffeur);
			}
			return listeDesChauffeurs;
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
	 * méthode permettant de récupérer tous les employés
	 * 
	 * @return List<Employe> avec l’id, le nom et le prenom de renseignés
	 */
	public List<Employe> recupererEmploye() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employe> listeDesEmploye = new ArrayList<>();
		StringBuilder selectQuery = new StringBuilder();

		try {
			selectQuery.append("SELECT * FROM UTILISATEUR ");

			preparedStatement = ConnectionUtils.getInstance().prepareStatement(selectQuery.toString());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("uti_id");
				String nom = resultSet.getString("uti_nom");
				String prenom = resultSet.getString("uti_prenom");
				Employe employe = new Collaborateur();
				employe.setId(id);
				employe.setNom(nom);
				employe.setPrenom(prenom);
				listeDesEmploye.add(employe);
			}
			return listeDesEmploye;
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
