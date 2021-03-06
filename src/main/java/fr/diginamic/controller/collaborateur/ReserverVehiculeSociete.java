package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.ResaVehiculeDao;
import fr.diginamic.dao.VehiculeDao;
import fr.diginamic.model.Employe;
import fr.diginamic.model.ReservationVoiture;
import fr.diginamic.model.Vehicule;

/**
 * Controller permettant de reserver un véhicule de société
 * 
 * @author Kevin.s
 *
 */
@WebServlet(urlPatterns = "/controller/collaborateur/reserverVehiculeSociete/*")
public class ReserverVehiculeSociete extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ReserverVehiculeSociete.class);

	public ReserverVehiculeSociete() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VehiculeDao vehiculeDao = new VehiculeDao();
		List<Vehicule> listeVehicule = vehiculeDao.recupererLesVehiculesSociete();
		req.setAttribute("listeVehicule", listeVehicule);

		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/WEB-INF/collaborateur/reservationsVehiculesSociete.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idVehicule = Integer.parseInt(req.getParameter("id"));
		String dateDepart = req.getParameter("datedepart");
		String dateArrive = req.getParameter("datearrive");
		String heureDepart = req.getParameter("heuredepart");
		String heureArrive = req.getParameter("heurearrive");
		String minuteDepart = req.getParameter("minutedepart");
		String minuteArrive = req.getParameter("minutearrive");
		Integer besoinChauffeur;
		if (req.getParameter("chauffeur") != null) {
			besoinChauffeur = Integer.parseInt(req.getParameter("chauffeur"));
		} else {
			besoinChauffeur = 0;
		}

		Employe employe = (Employe) req.getSession(false).getAttribute("utilisateur");
		Integer idEmploye = employe.getId();

		LocalDateTime dateHeureDepart = LocalDateTime.parse(dateDepart + " " + heureDepart + ":" + minuteDepart,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		LocalDateTime dateHeureArrive = LocalDateTime.parse(dateArrive + " " + heureArrive + ":" + minuteArrive,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

		ReservationVoiture reservationVoiture = new ReservationVoiture(idEmploye, dateHeureDepart, dateHeureArrive,
				new Vehicule(idVehicule));
		reservationVoiture.setBesoinChauffeur(besoinChauffeur);
		ResaVehiculeDao resaVehiculeDao = new ResaVehiculeDao();

		// vérifier véhicule disponible
		if (resaVehiculeDao.isVehiculeDisponible(idVehicule, dateHeureDepart, dateHeureArrive)) {
			SERVICE_LOG.info("Vehicule disponible.");
			resaVehiculeDao.ajoutResaVehicule(reservationVoiture);
			resp.sendRedirect(req.getContextPath() + "/controller/collaborateur/reservations/");
		} else {
			SERVICE_LOG.info("Vehicule non disponible.");
			resp.sendRedirect(req.getContextPath()
					+ "/controller/collaborateur/reserverVehiculeSociete?statut=dejareserve");
		}

	}

}
