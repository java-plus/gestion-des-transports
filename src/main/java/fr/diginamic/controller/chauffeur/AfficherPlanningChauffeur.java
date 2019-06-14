package fr.diginamic.controller.chauffeur;

import java.io.IOException;
import java.util.List;

import fr.diginamic.controller.WebServlet;

@WebServlet(urlPatterns = "/gestion-transports/chauffeur/planning/*")
public class AfficherPlanningChauffeur {

	/**
	 * Methode doGet qui affiche les données quand l'utilisateur accede à l'url
	 * /gestion-transports/chauffeur/planning/*
	 * 
	 * 
	 *
	 * dans cette url se trouve: un attribut utilisateur sous la forme
	 * ?utilisateur=toto
	 * 
	 * un jour courant sous la forme ?jourCourant=01062019 (pour 1er juin 2019)
	 * donc exemple d'url
	 * /gestion-transports/chauffeur/planning?utilisateur=JbSaitPasSoccuperDeSonBebe&jourCourant=06042019
	 * pour une page occupation de l'utilisateur JbSaitPasSoccuperDeSonBebe
	 * concernant la date du 6 avril 2019 (et donc un planning avec ces dates)
	 * 
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
		String jourCourant = req.getParameter("jourCourant");

		// Verifie si les dates en paramètres sont correctes et si ce n'est pas
		// le cas prend en paramètre la dernière semaine
		if (!dateEstValide(jourCourant)) {
			jourCourant = dateDujour;

		}

		PlanningDao planningDao = new PlanningDao();
		List<Planning> listeDesTachesDuJourCourant = planningDao.recupererLesTachesDuJourCourant(jourCourant,
				utilisateurCourant);

		// Afficher la graphique
		// TODO Creer la methode afficherLesOccupations(List<Occupation>
		// listeDesOccupations) dans utils pour afficher le graphique lié
		// ou le faire via Java dans JPS?
		afficherLesTachesDuJourCourant(listeDesTachesDuJourCourant);

		// ou alors via (cf ligne) + java dans JSP
		req.setAttribute("listeDesTachesDuJourCourant", listeDesTachesDuJourCourant);
		req.setAttribute("utilisateurCourant", utilisateurCourant);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/planning.jsp");
		requestDispatcher.forward(req, resp);
	}

}
