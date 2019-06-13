package fr.diginamic.model;

import java.util.Date;

public class AnnonceCovoiturage {

	private int idAnnonceCovoiturage;
	private Date dateDeDepart;
	private Adresse adresseDeDepart;
	private Adresse adresseDeDestination;
	private Date heureDeDepart;
	private Vehicule vehicule;
	private int placesDisponibles;
	private Collaborateur chauffeur;

}
