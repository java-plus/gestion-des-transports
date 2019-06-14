CREATE DATABASE gestion_transport;
USE gestion_transport;

CREATE TABLE `UTILISATEUR` (
 `uti_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `uti_statut` enum('collaborateur','chauffeur','admin') NOT NULL,
 `uti_nom` varchar(45) NOT NULL,
 `uti_prenom` varchar(45) NOT NULL,
 `uti_email` varchar(100) NOT NULL UNIQUE KEY ,
 `uti_mdp` varchar(200) NOT NULL,
 `uti_permis` varchar(45) DEFAULT NULL,
 `uti_photo` varchar(250) DEFAULT NULL,
 `uti_tel` varchar(45) DEFAULT NULL);

CREATE TABLE `VEHICULE` (
 `vhc_immatriculation` int(11) PRIMARY KEY NOT NULL UNIQUE,
 `vhc_marque` varchar(45) NOT NULL,
 `vhc_modele` varchar(45) NOT NULL,
 `vhc_categorie` varchar(45) NOT NULL,
 `vhc_photo` varchar(100) NOT NULL,
 `vhc_etat` varchar(200) NOT NULL,
 `vhc_position` varchar(45),
 `vhc_proprietaire` varchar(45) NOT NULL);


CREATE TABLE `RESAVEHICULE` (
 `rvh_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `rvh_datetimeDebut` varchar(100) NOT NULL,
 `rvh_datetimeFin` varchar(200) NOT NULL,
 `rvh_id_utilisateur` int(11) NOT NULL,
 `rvh_id_chauffeur` int(11) NOT NULL,
 `vhc_immatriculation` int(11) NOT NULL,
 FOREIGN KEY (rvh_id_utilisateur) REFERENCES UTILISATEUR(uti_id),
 FOREIGN KEY (rvh_id_chauffeur) REFERENCES UTILISATEUR(uti_id),
 FOREIGN KEY (vhc_immatriculation) REFERENCES VEHICULE(vhc_immatriculation));


CREATE TABLE `COVOITURAGE` (
 `cov_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `cov_nbPlacesDispo` varchar(45) NOT NULL,
 `cov_datetimeDebut` varchar(100) NOT NULL,
 `cov_lieuDepart` varchar(200) NOT NULL,
 `cov_lieuArrive` varchar(200) DEFAULT NULL,
 `cov_duree` varchar(10) DEFAULT NULL,
 `cov_distance` varchar(25) DEFAULT NULL,
 `cov_idReservationVehicule` int(11) NOT NULL,
 `cov_uti_id` int(11) NOT NULL,
 `cov_idVehicule` int(11) NOT NULL,
 FOREIGN KEY (cov_idReservationVehicule) REFERENCES RESAVEHICULE(rvh_id),
 FOREIGN KEY (cov_uti_id) REFERENCES UTILISATEUR(uti_id),
 FOREIGN KEY (cov_idVehicule) REFERENCES VEHICULE(vhc_immatriculation));

CREATE TABLE `RESACOVOITURAGE` (
 `rco_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `rco_idCovoiture` int(11) NOT NULL,
 `rco_idUtilisateur` int(11) NOT NULL,
 FOREIGN KEY (rco_idCovoiture) REFERENCES COVOITURAGE(cov_id),
 FOREIGN KEY (rco_idUtilisateur) REFERENCES UTILISATEUR(uti_id));