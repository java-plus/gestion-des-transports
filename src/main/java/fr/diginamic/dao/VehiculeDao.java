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
import fr.diginamic.model.Vehicule;
import fr.diginamic.utils.ConnectionUtils;
import fr.diginamic.utils.QueryUtils;

/**
 * Dao gérant l’acces à la base de données vehicule
 * 
 * @author Kevin.s
 *
 */
public class VehiculeDao {
	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(VehiculeDao.class);

	/**
	 * méthode permettant d’ajouter un véhicule en base de données
	 * 
	 * @param vehicule
	 */
	public void ajouterVehicule(Vehicule vehicule) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_photo`,`vhc_capacite`) VALUES (");
		sb.append("'").append(vehicule.getImmatriculation()).append("',");
		sb.append("'").append(vehicule.getMarque()).append("',");
		sb.append("'").append(vehicule.getModele()).append("',");
		sb.append("'").append(vehicule.getCategorie()).append("',");
		sb.append("'").append(vehicule.getPhoto()).append("',");
		sb.append(vehicule.getNbPlaces());
		sb.append(");");

		SERVICE_LOG.info(sb.toString());
		QueryUtils.updateQuery(sb.toString());
	}

	/**
	 * méthode permettant de vérifier si un véhicule existe déja
	 * 
	 * @param vehicule
	 * @return boolean
	 */
	public boolean existeDeja(Vehicule vehicule) {
		if (recupererLesVehiculesParImmatriculation(vehicule.getImmatriculation()).size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * méthode permettant de récuperer l’id d’un véhicule
	 * 
	 * @param vehicule
	 * @return Integer
	 */
	public Integer retrouverIdVehicule(Vehicule vehicule) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select vhc_id from VEHICULE where vhc_immatriculation=?");
			preparedStatement.setString(1, vehicule.getImmatriculation());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			Integer idVehicule = 0;
			while (resultSet.next()) {

				idVehicule = resultSet.getInt("vhc_id");

			}

			return idVehicule;
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
					SERVICE_LOG.error("impossible de fermer le statement",
							e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	/**
	 * méthode permettant de vérifier si un véhicule appartient à la société
	 * 
	 * @param vehicule
	 * @return Boolean
	 */
	public Boolean estUnVehiculeDeSociete(Vehicule vehicule) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select * from VEHICULE where vhc_immatriculation=?");
			preparedStatement.setString(1, vehicule.getImmatriculation());
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			String proprietaire = "";
			while (resultSet.next()) {

				proprietaire = resultSet.getString("vhc_proprietaire");
				System.out.println(proprietaire);
				System.out.println(resultSet.getString("vhc_proprietaire"));
				System.out.println(proprietaire.equals("societe"));
			}
			if (proprietaire.equals("societe")) {
				return true;
			} else {
				return false;
			}

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
					SERVICE_LOG.error("impossible de fermer le statement",
							e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	/**
	 * méthode permettant de récupérer l’identifiant d’une reservation
	 * 
	 * @param vehicule
	 * @param dateHeureDepartEffective
	 * @param idUtilisateur
	 * @return Integer
	 */
	public Integer retrouverIdReservation(Vehicule vehicule, LocalDateTime dateHeureDepartEffective,
			Integer idUtilisateur) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String dateDeDepart = dateHeureDepartEffective.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

		try {

			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from RESAVEHICULE  inner join vehicule on RESAVEHICULE.rvh_id_vehicule=VEHICULE.vhc_id "
							+ "where VEHICULE.vhc_immatriculation=\"" + vehicule.getImmatriculation()
							+ "\" and rvh_id_utilisateur=" + idUtilisateur + " and \"" + dateDeDepart
							+ "\" between rvh_datetimeDebut and rvh_datetimeFin");

			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			Integer idReservation = null;

			while (resultSet.next()) {
				idReservation = resultSet.getInt("rvh_id");

			}
			return idReservation;

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
					SERVICE_LOG.error("impossible de fermer le statement",
							e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	/**
	 * méthode permettant d’ajouter un véhicule personnel
	 * 
	 * @param vehicule
	 */
	public void ajouterVehiculePersonnel(Vehicule vehicule) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_photo`,`vhc_capacite`,`vhc_proprietaire`) VALUES (");
		sb.append("'").append(vehicule.getImmatriculation()).append("',");
		sb.append("'").append(vehicule.getMarque()).append("',");
		sb.append("'").append(vehicule.getModele()).append("',");
		sb.append("'").append(vehicule.getCategorie()).append("',");
		sb.append("'").append(vehicule.getPhoto()).append("',");
		sb.append(5).append(",");

		sb.append("'").append(vehicule.getProprietaire()).append("'");
		sb.append(")");

		SERVICE_LOG.info(sb.toString());
		QueryUtils.updateQuery(sb.toString());
	}

	/**
	 * méthode permettant de récupérer les vehicules par leur immatriculation
	 * 
	 * @param immatriculation
	 * @return List<Vehicule>
	 */
	public List<Vehicule> recupererLesVehiculesParImmatriculation(String immatriculation) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Vehicule> listeDesVehicules = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select * from VEHICULE where vhc_immatriculation=?");
			preparedStatement.setString(1, immatriculation);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				String immat = resultSet.getString("vhc_immatriculation");
				String marque = resultSet.getString("vhc_marque");
				String modele = resultSet.getString("vhc_modele");
				String categorie = resultSet.getString("vhc_categorie");
				String photo = resultSet.getString("vhc_photo");

				String etat = resultSet.getString("vhc_etat");
				listeDesVehicules.add(new Vehicule(immat, marque, modele, categorie, photo, etat));

			}

			return listeDesVehicules;
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
					SERVICE_LOG.error("impossible de fermer le statement",
							e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	/**
	 * méthode permettant de récupérer les vehicules par leur marque
	 * 
	 * @param marque
	 * @return List<Vehicule>
	 */
	public List<Vehicule> recupererLesVehiculesParMarque(String marque) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Vehicule> listeDesVehicules = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select * from VEHICULE where vhc_marque=?");
			preparedStatement.setString(1, marque);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				String immat = resultSet.getString("vhc_immatriculation");
				String marq = resultSet.getString("vhc_marque");
				String modele = resultSet.getString("vhc_modele");
				String categorie = resultSet.getString("vhc_categorie");
				String photo = resultSet.getString("vhc_photo");
				listeDesVehicules.add(new Vehicule(immat, marq, modele, categorie, photo));
			}

			return listeDesVehicules;
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
					SERVICE_LOG.error("impossible de fermer le statement",
							e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	/**
	 * méthode permettant de récupérer les vehicules de la société
	 * 
	 * @return List<Vehicule>
	 */
	public List<Vehicule> recupererLesVehiculesSociete() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Vehicule> listeDesVehicules = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("SELECT * FROM VEHICULE ve WHERE ve.vhc_proprietaire = \"societe\";");
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {

				Integer id = resultSet.getInt("vhc_id");
				String immatriculation = resultSet.getString("vhc_immatriculation");
				String marque = resultSet.getString("vhc_marque");
				String modele = resultSet.getString("vhc_modele");
				String categorie = resultSet.getString("vhc_categorie");
				String photo = resultSet.getString("vhc_photo");
				String etat = resultSet.getString("vhc_etat");
				String position = resultSet.getString("vhc_position");
				String proprietaire = resultSet.getString("vhc_proprietaire");

				Vehicule vehicule = new Vehicule(immatriculation, marque, modele, categorie, photo, etat, position,
						proprietaire);
				vehicule.setId(id);
				listeDesVehicules.add(vehicule);
			}

			return listeDesVehicules;
		} catch (SQLException e) {
			SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le resultSet",
							e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le statement",
							e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	/**
	 * méthode permettant de récupérer les id et immatriculation de tous les
	 * véhicules
	 * 
	 * @return List<Vehicule>
	 */
	public List<Vehicule> recupererVehiculesIdImmat() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Vehicule> listeDesVehicules = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("SELECT * FROM VEHICULE;");
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("vhc_id");
				String immatriculation = resultSet.getString("vhc_immatriculation");

				Vehicule vehicule = new Vehicule(id);
				vehicule.setImmatriculation(immatriculation);

				listeDesVehicules.add(vehicule);
			}

			return listeDesVehicules;
		} catch (SQLException e) {
			SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le resultSet",
							e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le statement",
							e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}
}
