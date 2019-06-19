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

import fr.diginamic.dao.ResaVehiculeDao;
import fr.diginamic.dao.VehiculeDao;
import fr.diginamic.model.Employe;
import fr.diginamic.model.ReservationVoiture;
import fr.diginamic.model.Vehicule;

@WebServlet(urlPatterns = "/controller/collaborateur/reserverVehiculeSociete/*")
public class ReserverVehiculeSociete extends HttpServlet {

	public ReserverVehiculeSociete() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VehiculeDao vehiculeDao = new VehiculeDao();
		List<Vehicule> listeVehicule = vehiculeDao.recupererLesVehiculesSociete();
		req.setAttribute("listeVehicule", listeVehicule);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher(
				"/WEB-INF/collaborateur/reservationsVehiculesSociete.jsp");
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

		Employe employe = (Employe) req.getSession(false).getAttribute("utilisateur");
		Integer idEmploye = employe.getId();

		LocalDateTime dateHeureDepart = LocalDateTime.parse(dateDepart + " " + heureDepart + ":" + minuteDepart,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		LocalDateTime dateHeureArrive = LocalDateTime.parse(dateArrive + " " + heureArrive + ":" + minuteArrive,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

		ReservationVoiture reservationVoiture = new ReservationVoiture(idEmploye, dateHeureDepart, dateHeureArrive,
				new Vehicule(idVehicule));

		ResaVehiculeDao resaVehiculeDao = new ResaVehiculeDao();
		resaVehiculeDao.ajoutResaVehicule(reservationVoiture);
		resp.sendRedirect("/gdt/controller/collaborateur/reservations/");

	}

}
