package fr.diginamic.model;

import java.util.Date;

public class AnnonceCovoiturage {

	private Integer idAnnonceCovoiturage;
	private Date dateDeDepart;
	private Adresse adresseDeDepart;
	private Adresse adresseDeDestination;
	private Date heureDeDepart;
	private Vehicule vehicule;
	private Integer placesDisponibles;
	private Collaborateur chauffeur;

}
