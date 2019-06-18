package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.CovoiturageDao;
import fr.diginamic.model.AnnonceCovoiturage;

@WebServlet(urlPatterns = "/controller/collaborateur/chercherannonces/*")
public class ChercherCovoiturage extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ChercherCovoiturage.class);

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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// HttpSession session = req.getSession(false);
		//
		// Employe utilisateurCourant = (Employe)
		// session.getAttribute("utilisateurCourant");
		String lieuDeDestination = "indeterminé";// req.getParameter("lieuDeDestination");
		String lieuDeDepart = "indeterminé";// req.getParameter("lieuDeDestination");
		CovoiturageDao covoiturageDao = new CovoiturageDao();
		List<AnnonceCovoiturage> listeDesAnnonces = covoiturageDao.recupererLesAnnonces();

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesAnnonces", listeDesAnnonces);
		req.setAttribute("lieuDeDestination", lieuDeDestination);
		req.setAttribute("lieuDeDepart", lieuDeDepart);
		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/WEB-INF/collaborateur/chercherCovoiturage.jsp");
		requestDispatcher.forward(req, resp);
	}

}
