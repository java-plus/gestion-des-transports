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
 `vhc_immatriculation` varchar(11) PRIMARY KEY NOT NULL UNIQUE,
 `vhc_marque` varchar(45) NOT NULL,
 `vhc_modele` varchar(45) NOT NULL,
 `vhc_categorie` varchar(45) NOT NULL,
 `vhc_photo` varchar(500) NOT NULL,
 `vhc_etat` varchar(200) NOT NULL,
 `vhc_position` varchar(45),
 `vhc_proprietaire` enum('societe','personnel') NOT NULL);


CREATE TABLE `RESAVEHICULE` (
 `rvh_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `rvh_datetimeDebut` DATETIME NOT NULL,
 `rvh_datetimeFin` DATETIME NOT NULL,
 `rvh_id_utilisateur` int(11) NOT NULL,
 `rvh_id_chauffeur` int(11) NOT NULL,
 `vhc_immatriculation` varchar(11) NOT NULL,
 FOREIGN KEY (rvh_id_utilisateur) REFERENCES UTILISATEUR(uti_id),
 FOREIGN KEY (rvh_id_chauffeur) REFERENCES UTILISATEUR(uti_id),
 FOREIGN KEY (vhc_immatriculation) REFERENCES VEHICULE(vhc_immatriculation));


CREATE TABLE `COVOITURAGES` (
 `cov_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `cov_nbPlacesDispo` int(11) NOT NULL,
 `cov_datetimeDebut` DATETIME NOT NULL,
 `cov_lieuDepart` varchar(200) NOT NULL,
 `cov_lieuArrive` varchar(200) DEFAULT NULL,
 `cov_duree` TIME,
 `cov_distance` int(11),
 `cov_idReservationVehicule` int(11) NOT NULL,
 `cov_uti_id` int(11) NOT NULL,
 `cov_idVehicule` varchar(11) NOT NULL,
 FOREIGN KEY (cov_idReservationVehicule) REFERENCES RESAVEHICULE(rvh_id),
 FOREIGN KEY (cov_uti_id) REFERENCES UTILISATEUR(uti_id),
 FOREIGN KEY (cov_idVehicule) REFERENCES VEHICULE(vhc_immatriculation));

CREATE TABLE `RESACOVOITURAGE` (
 `rco_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `rco_idCovoiture` int(11) NOT NULL,
 `rco_idUtilisateur` int(11) NOT NULL,
 FOREIGN KEY (rco_idCovoiture) REFERENCES COVOITURAGE(cov_id),
 FOREIGN KEY (rco_idUtilisateur) REFERENCES UTILISATEUR(uti_id));
 

INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("admin","LASBLEIS","Olivier","olivier.lasbleis@gmail.com","C7AD44CBAD762A5DA0A452F9E854FDC1E0E7A52A38015F23F3EAB1D80B931DD472634DFAC71CD34EBC35D16AB7FB8A90C81F975113D6C7538DC69DD8DE9077EC","PERMIS2","https://images.pexels.com/photos/358457/pexels-photo-358457.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","0234567891");
INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("chauffeur","SEGUINEAU","Kevin","kevin.seguineau@gmail.com","4809CF1F3BD75B6D68262FC716EC3C8F31621EA760533F6256CABD313835EF44830FC559441C2452F45EB8C37F666A0AF7B2BA2A9826C43904F0A67C130C47B1","PERMIS3","https://images.pexels.com/photos/92933/pexels-photo-92933.jpeg?auto=format%2Ccompress&cs=tinysrgb&dpr=2&h=650&w=940","0234567892");
INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("collaborateur","TOUSSAY","Yonel","yonel.toussay@gmail.com","0B9C0FAF3604046CAD97CBEBD2499FEAF2232D9C861D21D72F8A1C3BB0AC9B01BE99C70CDED8ADDD3210622325F654C16B7C3BD788E9F9701F43934C66671A46","PERMIS4","https://images.pexels.com/photos/257840/pexels-photo-257840.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","0234567893");

INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("ABCDEFG","Renault","4L","Citadine","https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjqtd2u6OjiAhVOhxoKHRYWDJEQjRx6BAgBEAU&url=https%3A%2F%2Fwww.gettyimages.fr%2Fphotos%2Frenault-4l&psig=AOvVaw1QMuboldwnoU4ib9x6ikLh&ust=1560596292545441","neuf","3 rue de baliverne 77410 Patin","personnel");
INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("HIJKLMN","Peugeot","407","Berline","https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwiZ27L-5ejiAhVQJBoKHaiqAosQjRx6BAgBEAU&url=https%3A%2F%2Fwww.ouestfrance-auto.com%2Fvoiture-occasion%2Fpeugeot-407-diesel-cesson-sevigne-ille-et-vilaine-9824298.html&psig=AOvVaw3tKO9GKsaltBg9JEFiPaDo&ust=1560595650767345","usé","5 rue du bla 44100 Nantes","societe");