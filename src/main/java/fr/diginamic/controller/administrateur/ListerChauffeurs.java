package fr.diginamic.controller.administrateur;

import java.io.IOException;
import java.util.List;

import fr.diginamic.controller.WebServlet;
import fr.diginamic.model.Chauffeur;

@WebServlet(urlPatterns = "/gestion-transports/administrateur/chauffeurs/*")
public class ListerChauffeurs {

	/**
	 * Methode doGet qui recupère les données (liste des annonces) quand
	 * l'utilisateur accede à l'url /gestion-transports/collaborateur/annonces/*
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

		ChauffeurDao chauffeurDao = new ChauffeurDao();
		List<Chauffeur> listeDesChauffeurs = chauffeurDao.recupererLesChauffeurs(utilisateurCourant);

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesChauffeurs", listeDesChauffeurs);
		req.setAttribute("utilisateurCourant", utilisateurCourant);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/administrateur/chauffeurs.jsp");
		requestDispatcher.forward(req, resp);
	}

}
