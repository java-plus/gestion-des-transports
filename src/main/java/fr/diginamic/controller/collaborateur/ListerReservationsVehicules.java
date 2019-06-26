package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.ArrayList;
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

import fr.diginamic.dao.ResaVehiculeDao;
import fr.diginamic.model.Employe;
import fr.diginamic.model.ReservationVoiture;

@WebServlet(urlPatterns = "/controller/collaborateur/reservations/*")
public class ListerReservationsVehicules extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ListerReservationsVehicules.class);

	/**
	 * Methode doGet qui recupère les données (liste des reservations V�hicules)
	 * quand l'utilisateur accede � l'url
	 * /gestion-transports/collaborateur/reservations
	 * 
	 * @param req  r�cupere les donn�es depuis la DAO et l'envoie � la JSP
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		Employe utilisateur = (Employe) session.getAttribute("utilisateur");
		Integer idUtilisateur = utilisateur.getId();

		ResaVehiculeDao resaVehiculeDao = new ResaVehiculeDao();

		List<ReservationVoiture> listeDesReservationsVehiculeFutur = new ArrayList<ReservationVoiture>();
		List<ReservationVoiture> listeDesReservationsVehiculePassees = new ArrayList<ReservationVoiture>();

		listeDesReservationsVehiculeFutur = resaVehiculeDao
				.recupererReservationsFuturesDUneVoiturePourUtilisateur(idUtilisateur);
		listeDesReservationsVehiculePassees = resaVehiculeDao
				.recupererReservationsPasseesDUneVoiturePourUtilisateur(idUtilisateur);

		// Afficher les reservations futures et passées via les listes
		// listeDesReservationsVehiculeFutur et listeDesReservationsVehiculePassees java
		// dans la JSP
		req.setAttribute("listeDesReservationsVehiculeFutur", listeDesReservationsVehiculeFutur);
		req.setAttribute("listeDesReservationsVehiculePassees", listeDesReservationsVehiculePassees);

		// req.setAttribute("utilisateurCourant", utilisateurCourant);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/collaborateur/reservations.jsp");
		requestDispatcher.forward(req, resp);
	}

}