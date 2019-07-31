-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           8.0.16 - MySQL Community Server - GPL
-- SE du serveur:                Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour gestion_transport
CREATE DATABASE IF NOT EXISTS `gestion_transport` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestion_transport`;

-- Listage de la structure de la table gestion_transport. COVOITURAGE
CREATE TABLE IF NOT EXISTS `COVOITURAGE` (
  `cov_id` int(11) NOT NULL AUTO_INCREMENT,
  `cov_nbPlacesDispo` int(11) NOT NULL,
  `cov_datetimeDebut` varchar(45) NOT NULL,
  `cov_lieuDepart` varchar(200) NOT NULL,
  `cov_lieuArrive` varchar(200) DEFAULT NULL,
  `cov_duree` int(11) DEFAULT NULL,
  `cov_distance` int(11) DEFAULT NULL,
  `cov_idReservationVehicule` int(11) DEFAULT NULL,
  `cov_uti_id` int(11) DEFAULT NULL,
  `cov_idVehicule` int(11) DEFAULT NULL,
  PRIMARY KEY (`cov_id`),
  KEY `cov_idReservationVehicule` (`cov_idReservationVehicule`),
  KEY `cov_uti_id` (`cov_uti_id`),
  KEY `cov_idVehicule` (`cov_idVehicule`),
  CONSTRAINT `covoiturage_ibfk_1` FOREIGN KEY (`cov_idReservationVehicule`) REFERENCES `RESAVEHICULE` (`rvh_id`),
  CONSTRAINT `covoiturage_ibfk_2` FOREIGN KEY (`cov_uti_id`) REFERENCES `UTILISATEUR` (`uti_id`),
  CONSTRAINT `covoiturage_ibfk_3` FOREIGN KEY (`cov_idVehicule`) REFERENCES `VEHICULE` (`vhc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table gestion_transport.COVOITURAGE : ~0 rows (environ)
/*!40000 ALTER TABLE `COVOITURAGE` DISABLE KEYS */;
/*!40000 ALTER TABLE `COVOITURAGE` ENABLE KEYS */;

-- Listage de la structure de la table gestion_transport. RESACOVOITURAGE
CREATE TABLE IF NOT EXISTS `RESACOVOITURAGE` (
  `rco_id` int(11) NOT NULL AUTO_INCREMENT,
  `rco_idCovoiture` int(11) NOT NULL,
  `rco_idUtilisateur` int(11) NOT NULL,
  PRIMARY KEY (`rco_id`),
  KEY `rco_idCovoiture` (`rco_idCovoiture`),
  KEY `rco_idUtilisateur` (`rco_idUtilisateur`),
  CONSTRAINT `resacovoiturage_ibfk_1` FOREIGN KEY (`rco_idCovoiture`) REFERENCES `COVOITURAGE` (`cov_id`),
  CONSTRAINT `resacovoiturage_ibfk_2` FOREIGN KEY (`rco_idUtilisateur`) REFERENCES `UTILISATEUR` (`uti_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table gestion_transport.RESACOVOITURAGE : ~0 rows (environ)
/*!40000 ALTER TABLE `RESACOVOITURAGE` DISABLE KEYS */;
/*!40000 ALTER TABLE `RESACOVOITURAGE` ENABLE KEYS */;

-- Listage de la structure de la table gestion_transport. RESAVEHICULE
CREATE TABLE IF NOT EXISTS `RESAVEHICULE` (
  `rvh_id` int(11) NOT NULL AUTO_INCREMENT,
  `rvh_datetimeDebut` datetime NOT NULL,
  `rvh_datetimeFin` datetime NOT NULL,
  `rvh_id_utilisateur` int(11) DEFAULT NULL,
  `rvh_id_chauffeur` int(11) DEFAULT NULL,
  `rvh_id_vehicule` int(11) DEFAULT NULL,
  `rvh_besoin_chauffeur` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`rvh_id`),
  KEY `rvh_id_utilisateur` (`rvh_id_utilisateur`),
  KEY `rvh_id_chauffeur` (`rvh_id_chauffeur`),
  KEY `rvh_id_vehicule` (`rvh_id_vehicule`),
  CONSTRAINT `resavehicule_ibfk_1` FOREIGN KEY (`rvh_id_utilisateur`) REFERENCES `UTILISATEUR` (`uti_id`),
  CONSTRAINT `resavehicule_ibfk_2` FOREIGN KEY (`rvh_id_chauffeur`) REFERENCES `UTILISATEUR` (`uti_id`),
  CONSTRAINT `resavehicule_ibfk_3` FOREIGN KEY (`rvh_id_vehicule`) REFERENCES `VEHICULE` (`vhc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table gestion_transport.RESAVEHICULE : ~5 rows (environ)
/*!40000 ALTER TABLE `RESAVEHICULE` DISABLE KEYS */;
INSERT INTO `RESAVEHICULE` (`rvh_id`, `rvh_datetimeDebut`, `rvh_datetimeFin`, `rvh_id_utilisateur`, `rvh_id_chauffeur`, `rvh_id_vehicule`, `rvh_besoin_chauffeur`) VALUES
	(7, '2019-06-27 05:30:00', '2019-06-28 03:30:00', 1, 2, 19, 0),
	(8, '2019-02-13 08:30:00', '2019-06-29 04:30:00', 1, NULL, 17, 0),
	(9, '2018-11-07 02:20:00', '2018-11-24 03:20:00', 3, NULL, 21, 1),
	(10, '2019-06-29 06:30:00', '2019-06-29 09:00:00', 3, 2, 21, 0),
	(11, '2019-06-29 14:30:00', '2019-06-29 18:10:00', 1, 2, 19, 0);
/*!40000 ALTER TABLE `RESAVEHICULE` ENABLE KEYS */;

-- Listage de la structure de la table gestion_transport. UTILISATEUR
CREATE TABLE IF NOT EXISTS `UTILISATEUR` (
  `uti_id` int(11) NOT NULL AUTO_INCREMENT,
  `uti_statut` enum('collaborateur','chauffeur','admin') NOT NULL,
  `uti_nom` varchar(45) NOT NULL,
  `uti_prenom` varchar(45) NOT NULL,
  `uti_email` varchar(100) NOT NULL,
  `uti_mdp` varchar(200) NOT NULL,
  `uti_permis` varchar(45) DEFAULT NULL,
  `uti_photo` varchar(250) DEFAULT NULL,
  `uti_tel` varchar(45) DEFAULT NULL,
  `uti_matricule` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uti_id`),
  UNIQUE KEY `uti_email` (`uti_email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table gestion_transport.UTILISATEUR : ~5 rows (environ)
/*!40000 ALTER TABLE `UTILISATEUR` DISABLE KEYS */;
INSERT INTO `UTILISATEUR` (`uti_id`, `uti_statut`, `uti_nom`, `uti_prenom`, `uti_email`, `uti_mdp`, `uti_permis`, `uti_photo`, `uti_tel`, `uti_matricule`) VALUES
	(1, 'admin', 'Dupuis', 'Pierre', 'admin@admin.com', 'C7AD44CBAD762A5DA0A452F9E854FDC1E0E7A52A38015F23F3EAB1D80B931DD472634DFAC71CD34EBC35D16AB7FB8A90C81F975113D6C7538DC69DD8DE9077EC', 'PERMIS2', 'https://images.pexels.com/photos/358457/pexels-photo-358457.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', '0234567891', NULL),
	(2, 'chauffeur', 'Grey', 'John', 'chauff@chauff.com', '4809CF1F3BD75B6D68262FC716EC3C8F31621EA760533F6256CABD313835EF44830FC559441C2452F45EB8C37F666A0AF7B2BA2A9826C43904F0A67C130C47B1', 'PERMIS3', 'https://d1dcnte8mfzkpv.cloudfront.net/uploads/2018/02/a52b021a916b11d0348570f45f5.jpg', '0234567892', NULL),
	(3, 'collaborateur', 'Maflo', 'Philippe', 'collab@collab.com', '0B9C0FAF3604046CAD97CBEBD2499FEAF2232D9C861D21D72F8A1C3BB0AC9B01BE99C70CDED8ADDD3210622325F654C16B7C3BD788E9F9701F43934C66671A46', 'PERMIS4', 'https://images.pexels.com/photos/257840/pexels-photo-257840.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940', '0234567893', NULL),
	(10, 'chauffeur', 'Skywalker', 'Any', 'any@sky.com', '1783b4a6670b4b7e4b54681fa2e0994c84b47e45cb4eff57643704bee019c69480e2a1c17dca8c62ea2031d763c6ed79d7bb4e603e913c23a5b22f9788b800bd', 'PS-PSD-44', 'https://www.findadriver.gr/wp-content/uploads/2016/06/chauffeur_driving.jpg', '09.02.45.34.12', '97334HD8'),
	(11, 'chauffeur', 'Garcia', 'Yves', 'yves.garcia@google.com', '449a5a23a7aa9016ef9b40d392e57fae4ce50bd9e7065222c53eab0b84604b45c93849fb42da8c713f7c53c7e2a3deb9be1b950f0a7f7aeba335df8441d02274', 'MD-66S-SD', 'https://www.swdrivers.com/wp-content/uploads/2014/12/Chauffeur_hp.jpg', '08.98.23.35.34', 'KS-SF76-SD');
/*!40000 ALTER TABLE `UTILISATEUR` ENABLE KEYS */;

-- Listage de la structure de la table gestion_transport. VEHICULE
CREATE TABLE IF NOT EXISTS `VEHICULE` (
  `vhc_id` int(11) NOT NULL AUTO_INCREMENT,
  `vhc_immatriculation` varchar(11) NOT NULL,
  `vhc_marque` varchar(45) NOT NULL,
  `vhc_modele` varchar(45) NOT NULL,
  `vhc_categorie` varchar(45) NOT NULL,
  `vhc_capacite` int(5) NOT NULL,
  `vhc_photo` varchar(500) NOT NULL,
  `vhc_etat` enum('EN SERVICE','EN REPARATION','HORS SERVICE') DEFAULT NULL,
  `vhc_position` varchar(45) DEFAULT NULL,
  `vhc_proprietaire` enum('societe','personnel') NOT NULL,
  PRIMARY KEY (`vhc_id`),
  UNIQUE KEY `vhc_id` (`vhc_id`),
  UNIQUE KEY `vhc_immatriculation` (`vhc_immatriculation`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table gestion_transport.VEHICULE : ~6 rows (environ)
/*!40000 ALTER TABLE `VEHICULE` DISABLE KEYS */;
INSERT INTO `VEHICULE` (`vhc_id`, `vhc_immatriculation`, `vhc_marque`, `vhc_modele`, `vhc_categorie`, `vhc_capacite`, `vhc_photo`, `vhc_etat`, `vhc_position`, `vhc_proprietaire`) VALUES
	(17, 'GG-666-LM', 'Audi', 'A7', 'Berlines Taille L', 5, 'https://upload.wikimedia.org/wikipedia/commons/d/d2/2018_Audi_A7_S_Line_40_TDi_S-A_2.0.jpg', 'EN SERVICE', NULL, 'societe'),
	(18, 'LS-564-KQ', 'Audi', 'A3', 'Compactes', 5, 'https://www.turbo.fr/sites/default/files/styles/article_690x405/public/migration/newscast/field_image/000000008405090.jpg?itok=P3Mk4yls', 'HORS SERVICE', NULL, 'societe'),
	(19, 'HS-762-PQ', 'Audi', 'A1', 'Mini-citadines', 5, 'https://images.caradisiac.com/logos-ref/modele/modele--audi-a1/S0-modele--audi-a1.jpg', 'EN SERVICE', NULL, 'societe'),
	(20, 'OD-776-PV', 'Peugeot', '208', 'Mini-citadines', 5, 'https://www.sixt.fr/fileadmin/_processed_/csm_peugeot-208-5d-schwarz-2012_ab8123acf5.png', 'EN REPARATION', NULL, 'societe'),
	(21, 'VS-720-LQ', 'Peugeot', '308', 'Citadines polyvalentes', 5, 'https://www.turbo.fr/sites/default/files/styles/article_690x405/public/2018-05/logo_690x405_turbo_peugeot_308.png?itok=4Xtb6nH5', 'EN SERVICE', NULL, 'societe'),
	(22, 'SH-623-PL', 'Dacia', 'Sandero', 'VEHICULE personnel', 5, 'VEHICULE personnel', NULL, NULL, 'personnel');
/*!40000 ALTER TABLE `VEHICULE` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
