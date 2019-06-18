package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.model.Vehicule;
import fr.diginamic.utils.ConnectionUtils;

public class VehiculeDao {
	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ConnectionUtils.class);

	public void ajouterVehicule(Vehicule vehicule) {
		// ajout du vehicule dans la base de donnée
	}

	public void modifierStatutVehicule(String nouveauStatutVehicule, Vehicule vehicule) {
		// ajout du vehicule dans la base de donnée
	}

	public List<Vehicule> recupererLesVehiculesParImmatriculation(String immatriculation) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Vehicule> listeDesVehicules = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from vehicule where vhc_immatriculation=?");
			preparedStatement.setString(1, immatriculation);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				String immat = resultSet.getString("vhc_immatriculation");
				String marque = resultSet.getString("vhc_marque");
				String modele = resultSet.getString("vhc_modele");
				String categorie = resultSet.getString("vhc_categorie");
				String photo = resultSet.getString("vhc_photo");
				listeDesVehicules.add(
						new Vehicule(immat, marque, modele, categorie, photo));
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
					// SERVICE_LOG.error("impossible de fermer le statement",
					// e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	public List<Vehicule> recupererLesVehiculesParMarque(String marque) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Vehicule> listeDesVehicules = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from vehicule where vhc_marque=?");
			preparedStatement.setString(1, marque);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				String immat = resultSet.getString("vhc_immatriculation");
				String marq = resultSet.getString("vhc_marque");
				String modele = resultSet.getString("vhc_modele");
				String categorie = resultSet.getString("vhc_categorie");
				String photo = resultSet.getString("vhc_photo");
				listeDesVehicules.add(
						new Vehicule(immat, marq, modele, categorie, photo));
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
					// SERVICE_LOG.error("impossible de fermer le statement",
					// e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	public List<Vehicule> recupererLesVehiculesSociete() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Vehicule> listeDesVehicules = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement("select * from vehicule");
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				String immatriculation = resultSet.getString("vhc_immatriculation");
				String marque = resultSet.getString("vhc_marque");
				String modele = resultSet.getString("vhc_modele");
				String categorie = resultSet.getString("vhc_categorie");
				String photo = resultSet.getString("vhc_photo");
				String etat = resultSet.getString("vhc_etat");
				String position = resultSet.getString("vhc_position");
				String proprietaire = resultSet.getString("vhc_proprietaire");

				listeDesVehicules.add(
						new Vehicule(immatriculation, marque, modele, categorie, photo, etat, position, proprietaire));
			}

			return listeDesVehicules;
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
