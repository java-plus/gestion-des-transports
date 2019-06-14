package fr.diginamic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/gestion-transports/chauffeur/occupation/*")
public class AfficherGraphiqueOccupationChauffeur {

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

		Occupation occupation = new Occupation();
		List<Occupation> listeDesOccupations = occupationDao.recupererLesOccupationsCourantes(dateDeDebut, dateDeFin,
				utilisateurCourant);

		// Afficher la graphique
		// TODO Creer la methode afficherLesOccupations(List<Occupation>
		// listeDesOccupations) dans utils pour afficher le graphique lié
		// ou le faire via Java dans JPS?
		afficherLesOccupations(listeDesOccupations);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/occupation.jsp");
		requestDispatcher.forward(req, resp);
	}

	/**
	 * Methode doPost qui execute la requete utilisateur pour visualiser
	 * occupations selon nouvelles dates
	 * 
	 * la methode verifie d'abord si les dates selectionnées sont valides,
	 * stocke ces valeurs (dateDeDebut, dateDeFin et utilisateurCourant) puis
	 * renvoi sur l'url /gestion-transports/chauffeur/occupation/*
	 * 
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String utilisateurCourant = req.getParameter("utilisateurCourant");
		String dateDeDebut = req.getParameter("dateDeDebut");
		String dateDeFin = req.getParameter("dateDeFin");

		// SI DATES (OU QUELQUECHOSE) INVALIDE
		// TODO creer methode dateEstValide sur utils
		if (dateEstValide(dateDeDebut) && dateEstValide(dateDeFin)) {

			req.setAttribute("utilisateurCourant", utilisateurCourant);
			req.setAttribute("dateDeDebut", dateDeDebut);
			req.setAttribute("dateDeFin", dateDeFin);

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/gestion-transports/chauffeur/occupation/*");
			dispatcher.forward(req, resp);
		} else {

			// MESSAGE D'ERREUR "DATE (OU QUELQUECHOSE) INVALIDE

		}
	}

}
