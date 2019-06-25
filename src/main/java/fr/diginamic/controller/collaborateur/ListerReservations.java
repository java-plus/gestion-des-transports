package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.ResaCovoiturageDao;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.model.Employe;

@WebServlet(urlPatterns = "/controller/collaborateur/reservations/creer")
public class ListerReservations extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ListerReservations.class);

	/**
	 * Methode doGet qui recupère les données (liste des reservationss) quand
	 * l'utilisateur accede à l'url /gestion-transports/collaborateur/reservations/*
	 * 
	 * 
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateur");
		Set<String> h = new HashSet<String>();
		Integer idUtilisateurCourant = utilisateurCourant.getId();
		ResaCovoiturageDao resaCovoiturageDao = new ResaCovoiturageDao();

		List<AnnonceCovoiturage> listeDesReservationsCovoiturage = resaCovoiturageDao
				.recupererLesReservations(idUtilisateurCourant);

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesReservationsCovoiturage", listeDesReservationsCovoiturage);
		Integer idUtilisateur = utilisateurCourant.getId();
		req.setAttribute("idUtilisateur", idUtilisateur);
		// req.setAttribute("utilisateurCourant", utilisateurCourant);

		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/WEB-INF/collaborateur/reservationsCovoiturage.jsp");
		requestDispatcher.forward(req, resp);
	}

}
