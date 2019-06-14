package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.diginamic.dao.CovoiturageDao;
import fr.diginamic.model.Employe;
import fr.diginamic.model.ReservationCovoiturage;

@WebServlet(urlPatterns = "/gestion-transports/collaborateur/reservations/*")
public class ListerReservations {

	/**
	 * Methode doGet qui recupère les données (liste des reservationss) quand
	 * l'utilisateur accede à l'url
	 * /gestion-transports/collaborateur/reservations/*
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateurCourant");

		CovoiturageDao covoiturageDao = new CovoiturageDao();

		List<ReservationCovoiturage> listeDesReservationsCovoiturage = covoiturageDao
				.recupererLesReservations(utilisateurCourant);

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesReservationsCovoiturage", listeDesReservationsCovoiturage);
		req.setAttribute("utilisateurCourant", utilisateurCourant);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/reservationsCovoiturage.jsp");
		requestDispatcher.forward(req, resp);
	}

}
