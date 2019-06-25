package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.ResaVehiculeDao;
import fr.diginamic.model.ReservationVoiture;

@WebServlet(urlPatterns = "/controller/collaborateur/reservations")
public class ListerReservationsVehicules extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ListerReservationsVehicules.class);

	/**
	 * Methode doGet qui recupÃ¨re les donnÃ©es (liste des reservations
	 * Véhicules) quand l'utilisateur accede Ã  l'url
	 * /gestion-transports/collaborateur/reservations
	 * 
	 * @param req récupere les données depuis la DAO et l'envoie à la JSP
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

		// Integer idUtilisateurCourant = 8;
		ResaVehiculeDao resaVehiculeDao = new ResaVehiculeDao();

		List<ReservationVoiture> listeDesReservationsVehiculeFutur = new ArrayList<ReservationVoiture>();
		List<ReservationVoiture> listeDesReservationsVehiculePassees = new ArrayList<ReservationVoiture>();
		
		listeDesReservationsVehiculeFutur = resaVehiculeDao.recupererReservationsFuturesDUneVoiture();
		listeDesReservationsVehiculePassees = resaVehiculeDao.recupererReservationsPasseesDUneVoiture();

		// Afficher les reservations futures et passées via les listes listeDesReservationsVehiculeFutur et listeDesReservationsVehiculePassees java dans la JSP
		req.setAttribute("listeDesReservationsVehiculeFutur", listeDesReservationsVehiculeFutur);
		req.setAttribute("listeDesReservationsVehiculePassees", listeDesReservationsVehiculePassees);
		
		// req.setAttribute("utilisateurCourant", utilisateurCourant);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/collaborateur/reservations.jsp");
		requestDispatcher.forward(req, resp);
	}

}