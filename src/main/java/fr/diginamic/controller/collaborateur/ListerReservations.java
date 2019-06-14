package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.List;

import fr.diginamic.controller.WebServlet;
import fr.diginamic.model.Reservation;

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

		String utilisateurCourant = req.getParameter("utilisateurCourant");

		ReservationCovoiturageDao reservationCovoiturageDao = new ReservationCovoiturageDao();
		List<Reservation> listeDesReservationsCovoiturage = reservationCovoiturageDao
				.recupererLesReservations(utilisateurCourant);

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesReservationsCovoiturage", listeDesReservationsCovoiturage);
		req.setAttribute("utilisateurCourant", utilisateurCourant);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/reservationsCovoiturage.jsp");
		requestDispatcher.forward(req, resp);
	}

}
