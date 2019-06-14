package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.List;

import fr.diginamic.controller.WebServlet;
import fr.diginamic.model.Annonce;

@WebServlet(urlPatterns = "/gestion-transports/collaborateur/annonces/*")
public class ListerMesAnnonces {

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

		AnnonceDao annonceDao = new AnnonceDao();
		List<Annonce> listeDesAnnonces = annonceDao.recupererLesAnnonces(utilisateurCourant);

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesAnnonces", listeDesAnnonces);
		req.setAttribute("utilisateurCourant", utilisateurCourant);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/collaborateur/annonces.jsp");
		requestDispatcher.forward(req, resp);
	}

}
