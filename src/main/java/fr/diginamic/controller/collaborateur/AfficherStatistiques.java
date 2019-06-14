package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.List;

public class AfficherStatistiques {

	/**
	 * Methode doGet qui affiche les données quand l'utilisateur accede à l'url
	 * /gestion-transports/chauffeur/occupation/*
	 * 
	 * 
	 *
	 * dans cette url se trouve: un attribut utilisateur sous la forme
	 * ?utilisateur=toto une date de début et une date de fin sous la forme
	 * ?dateDeDebut=01062019 (pour 1er juin 2019) donc exemple d'url
	 * /gestion-transports/chauffeur/occupation?utilisateur=kevinAUnePetitePinne&dateDeDebut=03052019&dateDeFin=03062019
	 * pour une page occupation de l'utilisateur kevinAUnePetitePinne concernant
	 * des dates du 3 mai au 6 juin 2019 (et donc un graphique avec ces dates en
	 * abscisse)
	 *
	 * 
	 * 
	 * 
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String utilisateurCourant = req.getParameter("utilisateurCourant");
		String dateDeDebut = req.getParameter("dateDeDebut");
		String dateDeFin = req.getParameter("dateDeFin");

		// Verifie si les dates en paramètres sont correctes et si ce n'est pas
		// le cas prend en paramètre la dernière semaine
		if (!dateEstValide(dateDeDebut) && !dateEstValide(dateDeFin)) {
			dateDeDebut = dateDujour;
			dateDeFin = dateDuJourMoinsSeptJour;
		}

		Occupation occupation = new Occupation();
		List<Occupation> listeDesOccupations = occupationDao.recupererLesOccupationsCourantes(dateDeDebut, dateDeFin,
				utilisateurCourant);

		// Afficher la graphique
		// TODO Creer la methode afficherLesOccupations(List<Occupation>
		// listeDesOccupations) dans utils pour afficher le graphique lié
		// ou le faire via Java dans JPS?
		afficherLesOccupations(listeDesOccupations);

		// ou alors via (cf ligne) + java dans JSP
		req.setAttribute("listeDesOccupations", listeDesOccupations);
		req.setAttribute("utilisateurCourant", utilisateurCourant);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/occupation.jsp");
		requestDispatcher.forward(req, resp);
	}

}
