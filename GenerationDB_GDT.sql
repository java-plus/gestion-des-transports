-- Script V4

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
 `uti_tel` varchar(45) DEFAULT NULL,
 `uti_matricule` varchar(45) DEFAULT NULL);

CREATE TABLE `VEHICULE` (
 `vhc_id` int(11) PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
 `vhc_immatriculation` varchar(11) NOT NULL UNIQUE,
 `vhc_marque` varchar(45) NOT NULL,
 `vhc_modele` varchar(45) NOT NULL,
 `vhc_categorie` varchar(45) NOT NULL,
 `vhc_capacite` INT(5) NOT NULL,
 `vhc_photo` varchar(500) NOT NULL,
 `vhc_etat` enum('EN SERVICE','EN REPARATION','HORS SERVICE') NOT NULL,
 `vhc_position` varchar(45),
 `vhc_proprietaire` enum('societe','personnel') NOT NULL);

CREATE TABLE `RESAVEHICULE` (
 `rvh_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `rvh_datetimeDebut` datetime NOT NULL,
 `rvh_datetimeFin` datetime NOT NULL,
 `rvh_id_utilisateur` int(11) DEFAULT NULL,
 `rvh_id_chauffeur` int(11) NULL,
 `rvh_id_vehicule` int(11) DEFAULT NULL,
 `rvh_besoin_chauffeur` TINYINT(1) NULL DEFAULT 0,
 FOREIGN KEY (rvh_id_utilisateur) REFERENCES UTILISATEUR(uti_id),
 FOREIGN KEY (rvh_id_chauffeur) REFERENCES UTILISATEUR(uti_id),
 FOREIGN KEY (rvh_id_vehicule) REFERENCES VEHICULE(vhc_id));

CREATE TABLE `COVOITURAGE` (
 `cov_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `cov_nbPlacesDispo` int(11) NOT NULL,
 `cov_datetimeDebut` varchar(45) NOT NULL,
 `cov_lieuDepart` varchar(200) NOT NULL,
 `cov_lieuArrive` varchar(200) DEFAULT NULL,
 `cov_duree` int(11),
 `cov_distance` int(11),
 `cov_idReservationVehicule` int(11) NULL,
 `cov_uti_id` int(11) DEFAULT NULL,
 `cov_idVehicule` int(11) DEFAULT NULL,
 FOREIGN KEY (cov_idReservationVehicule) REFERENCES RESAVEHICULE(rvh_id),
 FOREIGN KEY (cov_uti_id) REFERENCES UTILISATEUR(uti_id),
 FOREIGN KEY (cov_idVehicule) REFERENCES VEHICULE(vhc_id));

CREATE TABLE `RESACOVOITURAGE` (
 `rco_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `rco_idCovoiture` int(11) NOT NULL,
 `rco_idUtilisateur` int(11) NOT NULL,
 FOREIGN KEY (rco_idCovoiture) REFERENCES COVOITURAGE(cov_id),
 FOREIGN KEY (rco_idUtilisateur) REFERENCES UTILISATEUR(uti_id));
 

             

INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("admin","LASBLEIS","Olivier","olivier.lasbleis@gmail.com","C7AD44CBAD762A5DA0A452F9E854FDC1E0E7A52A38015F23F3EAB1D80B931DD472634DFAC71CD34EBC35D16AB7FB8A90C81F975113D6C7538DC69DD8DE9077EC","PERMIS2","https://images.pexels.com/photos/358457/pexels-photo-358457.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","0234567891");
INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("chauffeur","SEGUINEAU","Kevin","kevin.seguineau@gmail.com","4809CF1F3BD75B6D68262FC716EC3C8F31621EA760533F6256CABD313835EF44830FC559441C2452F45EB8C37F666A0AF7B2BA2A9826C43904F0A67C130C47B1","PERMIS3","https://images.pexels.com/photos/92933/pexels-photo-92933.jpeg?auto=format%2Ccompress&cs=tinysrgb&dpr=2&h=650&w=940","0234567892");
INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("collaborateur","TOUSSAY","Yonel","yonel.toussay@gmail.com","0B9C0FAF3604046CAD97CBEBD2499FEAF2232D9C861D21D72F8A1C3BB0AC9B01BE99C70CDED8ADDD3210622325F654C16B7C3BD788E9F9701F43934C66671A46","PERMIS4","https://images.pexels.com/photos/257840/pexels-photo-257840.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","0234567893");
INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("admin","PEYRAS","Cecile","PEYRAS.Cecile@gmail.com","C7AD44CBAD762A5DA0A452F9E854FDC1E0E7A52A38015F23F3EAB1D80B931DD472634DFAC71CD34EBC35D16AB7FB8A90C81F975113D6C7538DC69DD8DE9077EC","PERMIS2","https://images.pexels.com/photos/358457/pexels-photo-358457.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","0234567891");
INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("chauffeur","KHARBECHE","Billel","kevin.Cecile@gmail.com","4809CF1F3BD75B6D68262FC716EC3C8F31621EA760533F6256CABD313835EF44830FC559441C2452F45EB8C37F666A0AF7B2BA2A9826C43904F0A67C130C47B1","PERMIS3","https://images.pexels.com/photos/92933/pexels-photo-92933.jpeg?auto=format%2Ccompress&cs=tinysrgb&dpr=2&h=650&w=940","0234567892");
INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("collaborateur","ALARDIN","Patrice","Patrice.toussay@gmail.com","0B9C0FAF3604046CAD97CBEBD2499FEAF2232D9C861D21D72F8A1C3BB0AC9B01BE99C70CDED8ADDD3210622325F654C16B7C3BD788E9F9701F43934C66671A46","PERMIS4","https://images.pexels.com/photos/257840/pexels-photo-257840.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","0234567893");
INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("admin","TURPIN","Eloi","Eloi.lasbleis@gmail.com","C7AD44CBAD762A5DA0A452F9E854FDC1E0E7A52A38015F23F3EAB1D80B931DD472634DFAC71CD34EBC35D16AB7FB8A90C81F975113D6C7538DC69DD8DE9077EC","PERMIS2","https://images.pexels.com/photos/358457/pexels-photo-358457.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","0234567891");
INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("chauffeur","PIERRE","Guillaume","PIERRE.Guillaume@gmail.com","4809CF1F3BD75B6D68262FC716EC3C8F31621EA760533F6256CABD313835EF44830FC559441C2452F45EB8C37F666A0AF7B2BA2A9826C43904F0A67C130C47B1","PERMIS3","https://images.pexels.com/photos/92933/pexels-photo-92933.jpeg?auto=format%2Ccompress&cs=tinysrgb&dpr=2&h=650&w=940","0234567892");
INSERT INTO `UTILISATEUR` (`uti_statut`,`uti_nom`,`uti_prenom`,`uti_email`,`uti_mdp`,`uti_permis`,`uti_photo`,`uti_tel`) VALUES ("collaborateur","MERAND","Jean-Baptiste","MERAND.Jean@gmail.com","0B9C0FAF3604046CAD97CBEBD2499FEAF2232D9C861D21D72F8A1C3BB0AC9B01BE99C70CDED8ADDD3210622325F654C16B7C3BD788E9F9701F43934C66671A46","PERMIS4","https://images.pexels.com/photos/257840/pexels-photo-257840.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","0234567893");

INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_capacite`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("ABCDEFG","Renault","4L","Citadine",4,"https://images.caradisiac.com/images/4/0/3/6/174036/S0-la-peugeot-508-elue-plus-belle-voiture-de-l-annee-2018-579428.jpg","EN SERVICE","3 rue de baliverne 77410 Patin","personnel");
INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_capacite`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("HIJKLMN","Peugeot","407","Berline",5,"https://images.caradisiac.com/images/4/0/3/6/174036/S0-la-peugeot-508-elue-plus-belle-voiture-de-l-annee-2018-579428.jpg","EN SERVICE","5 rue du bla 44100 Nantes","societe");
INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_capacite`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("GBCDEFG","Renault","4L","Citadine",9,"https://images.caradisiac.com/images/4/0/3/6/174036/S0-la-peugeot-508-elue-plus-belle-voiture-de-l-annee-2018-579428.jpg","EN SERVICE","3 rue de baliverne 77410 Patin","personnel");
INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_capacite`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("HIJHFMN","Peugeot","407","Berline",3,"https://images.caradisiac.com/images/4/0/3/6/174036/S0-la-peugeot-508-elue-plus-belle-voiture-de-l-annee-2018-579428.jpg","EN SERVICE","5 rue du bla 44100 Nantes","societe");
INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_capacite`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("ASCDSDG","Renault","4L","Citadine",2,"https://images.caradisiac.com/images/4/0/3/6/174036/S0-la-peugeot-508-elue-plus-belle-voiture-de-l-annee-2018-579428.jpg","EN SERVICE","3 rue de baliverne 77410 Patin","personnel");
INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_capacite`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("HYTTLMN","Peugeot","407","Berline",4,"https://images.caradisiac.com/images/4/0/3/6/174036/S0-la-peugeot-508-elue-plus-belle-voiture-de-l-annee-2018-579428.jpg","HORS SERVICE","5 rue du bla 44100 Nantes","societe");
INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_capacite`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("ABJUIKG","Renault","4L","Citadine",9,"https://images.caradisiac.com/images/4/0/3/6/174036/S0-la-peugeot-508-elue-plus-belle-voiture-de-l-annee-2018-579428.jpg","EN REPARATION","3 rue de baliverne 77410 Patin","personnel");
INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_capacite`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("HIHJLMN","Peugeot","407","Berline",12,"https://images.caradisiac.com/images/4/0/3/6/174036/S0-la-peugeot-508-elue-plus-belle-voiture-de-l-annee-2018-579428.jpg","EN SERVICE","5 rue du bla 44100 Nantes","societe");
INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_capacite`,`vhc_photo`,`vhc_etat`,`vhc_position`,`vhc_proprietaire`) VALUES ("ZRTKLMN","Peugeot","407","Berline",11,"https://images.caradisiac.com/images/4/0/3/6/174036/S0-la-peugeot-508-elue-plus-belle-voiture-de-l-annee-2018-579428.jpg","EN SERVICE","5 rue du bla 44100 Nantes","societe");
-- Insertion de donnees /!\ /!\ les attribus de RESAVEHICULE (rvh_id_utilisateur rvh_id_chauffeur rvh_id_vehicule) sont null par défaut /!\ /!\



INSERT INTO `RESAVEHICULE`(`rvh_datetimeDebut`,`rvh_datetimeFin`,`rvh_id_utilisateur`,`rvh_id_vehicule`) VALUES ("2019-06-13 00:00","2019-06-17 00:00",3,2);
INSERT INTO `RESAVEHICULE`(`rvh_datetimeDebut`,`rvh_datetimeFin`,`rvh_id_utilisateur`,`rvh_id_vehicule`) VALUES ("2019-06-15 00:00","2019-06-19 00:00",3,2);
INSERT INTO `RESAVEHICULE`(`rvh_datetimeDebut`,`rvh_datetimeFin`,`rvh_id_utilisateur`,`rvh_id_vehicule`) VALUES ("2019-07-03 00:00","2019-07-15 00:00",3,2);
INSERT INTO `RESAVEHICULE`(`rvh_datetimeDebut`,`rvh_datetimeFin`,`rvh_id_utilisateur`,`rvh_id_vehicule`) VALUES ("2019-06-13 00:00","2019-06-17 00:00",5,4);
INSERT INTO `RESAVEHICULE`(`rvh_datetimeDebut`,`rvh_datetimeFin`,`rvh_id_utilisateur`,`rvh_id_vehicule`) VALUES ("2019-06-15 00:00","2019-06-19 00:00",6,2);
INSERT INTO `RESAVEHICULE`(`rvh_datetimeDebut`,`rvh_datetimeFin`,`rvh_id_utilisateur`,`rvh_id_vehicule`) VALUES ("2019-07-03 00:00","2019-07-15 00:00",6,4);



INSERT INTO `COVOITURAGE` (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,`cov_duree`,`cov_distance`,`cov_uti_id`,`cov_idVehicule`) VALUES (3,"2019-07-05 14:29","Nantes","Paris",4,400,1,1);
INSERT INTO `COVOITURAGE` (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,`cov_duree`,`cov_distance`,`cov_uti_id`,`cov_idVehicule`) VALUES (2,"2019-06-15 11:17","Nantes","Perpignan",6,600,1,1);
INSERT INTO `COVOITURAGE` (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,`cov_duree`,`cov_distance`,`cov_uti_id`,`cov_idVehicule`) VALUES (1,"2019-06-18 17:30","Perpignan","Paris",8,700,2,3);
INSERT INTO `COVOITURAGE` (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,`cov_duree`,`cov_distance`,`cov_idReservationVehicule`,`cov_uti_id`,`cov_idVehicule`) VALUES (3,"2019-07-05 14:29","Nantes","Paris",4,400,1,3,2);
INSERT INTO `COVOITURAGE` (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,`cov_duree`,`cov_distance`,`cov_uti_id`,`cov_idVehicule`) VALUES (2,"2019-06-15 11:17","Nantes","Perpignan",6,600,4,5);
INSERT INTO `COVOITURAGE` (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,`cov_duree`,`cov_distance`,`cov_idReservationVehicule`,`cov_uti_id`,`cov_idVehicule`) VALUES (1,"2019-06-18 17:30","Perpignan","Paris",8,700,2,5,4);
INSERT INTO `COVOITURAGE` (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,`cov_duree`,`cov_distance`,`cov_uti_id`,`cov_idVehicule`) VALUES (1,"2019-06-18 17:30","Perpignan","Paris",8,700,6,3);
INSERT INTO `COVOITURAGE` (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,`cov_duree`,`cov_distance`,`cov_idReservationVehicule`,`cov_uti_id`,`cov_idVehicule`) VALUES (3,"2019-07-05 14:29","Nantes","Paris",4,400,1,6,2);
INSERT INTO `COVOITURAGE` (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,`cov_duree`,`cov_distance`,`cov_uti_id`,`cov_idVehicule`) VALUES (2,"2019-06-15 11:17","Nantes","Perpignan",6,600,6,5);
INSERT INTO `COVOITURAGE` (`cov_nbPlacesDispo`,`cov_datetimeDebut`,`cov_lieuDepart`,`cov_lieuArrive`,`cov_duree`,`cov_distance`,`cov_idReservationVehicule`,`cov_uti_id`,`cov_idVehicule`) VALUES (1,"2019-06-18 17:30","Perpignan","Paris",8,700,2,6,4);

 INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (1,8);
  INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (1,7);
   INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (1,6);
    INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (1,5);
     INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (2,1);
      INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (2,5);
       INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (2,6);
        INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (3,8);
         INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (4,8);
          INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (5,8);
           INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (5,7);
            INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (5,6);
             INSERT INTO `RESACOVOITURAGE` (`rco_idCovoiture`,`rco_idUtilisateur`) VALUES (6,8);
			INSERT INTO `VEHICULE` (`vhc_immatriculation`,`vhc_marque`,`vhc_modele`,`vhc_categorie`,`vhc_photo`,`vhc_capacite`,`vhc_etat`) VALUES ('ab-123-cd','ferrari','grosse voiture','Berlines Taille S','https://pic.clubic.com/v1/images/1713156/raw',2,'EN SERVICE');