package fr.diginamic.dao;

import java.time.LocalDate;
import java.util.List;

import fr.diginamic.model.Employe;
import fr.diginamic.model.Occupation;
import fr.diginamic.model.Planning;

public class ResaVehiculeDao {

	/**
	 * Methode requetant la base de donnée pour retourner la liste des
	 * occupations d'un chauffeur entre deux dates
	 * 
	 * @param dateDeDebut
	 * @param dateDeFin
	 * @param utilisateurCourant
	 * @return
	 */
	public List<Occupation> recupererLesOccupationsCourantes(LocalDate dateDeDebut, LocalDate dateDeFin,
			Employe utilisateurCourant) {
		return null;
	}

	/**
	 * Methode requetant la base de donnée pour retourner la liste des taches
	 * d'un jour pour un chauffeur
	 * 
	 * @param jourCourant
	 * @param utilisateurCourant
	 * @return
	 */
	public List<Planning> recupererLesTachesDuJourCourant(LocalDate jourCourant, Employe utilisateurCourant) {
		return null;
	}

}
