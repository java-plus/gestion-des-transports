package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.CovoiturageDao;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.model.Employe;

@WebServlet(urlPatterns = "/controller/collaborateur/chercherannoncesAvecCritere/*")
public class ChercherCovoiturageAvecCritere extends HttpServlet {
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

		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateur");

		String lieuDeDestination = (String) req.getParameter("lieuDeDestination");
		String lieuDeDepart = (String) req.getParameter("lieuDeDepart");
		CovoiturageDao covoiturageDao = new CovoiturageDao();
		List<AnnonceCovoiturage> listeDesAnnonces = covoiturageDao.recupererLesAnnoncesAvecCritere(lieuDeDepart,
				lieuDeDestination);

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesAnnonces", listeDesAnnonces);
		req.setAttribute("lieuDeDestination", lieuDeDestination);
		req.setAttribute("lieuDeDepart", lieuDeDepart);
		Integer idUtilisateur = utilisateurCourant.getId();
		req.setAttribute("idUtilisateur", idUtilisateur);
		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/WEB-INF/collaborateur/chercherCovoiturage.jsp");
		requestDispatcher.forward(req, resp);
	}
}
