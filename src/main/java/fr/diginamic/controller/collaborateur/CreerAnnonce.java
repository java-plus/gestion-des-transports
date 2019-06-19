package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import fr.diginamic.dao.VehiculeDao;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.model.Employe;
import fr.diginamic.model.Vehicule;

@WebServlet(urlPatterns = "/controller/collaborateur/creerannonce/*")
public class CreerAnnonce extends HttpServlet {

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
		// TODOOOOOOOOOOOOOOOOOOOOOO
		HttpSession session = req.getSession(false);

		Employe utilisateur = (Employe) session.getAttribute("utilisateur");

		req.setAttribute("utilisateur", utilisateur);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/collaborateur/annonces_creer.jsp");
		requestDispatcher.forward(req, resp);
	}

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODOOOOOOOOOOOOOOOOOOOOOO
		HttpSession session = req.getSession(false);

		String adresseDeDepart = req.getParameter("adresseDeDepart");
		String adresseDeDestination = req.getParameter("adresseDeDestination");
		String immatriculationVehicule = req.getParameter("immatriculationVehicule");
		String marqueVehicule = req.getParameter("marqueVehicule");
		String modeleVehicule = req.getParameter("modeleVehicule");
		Integer nbPlacesVehicule = Integer.parseInt(req.getParameter("nbPlacesVehicule"));
		String dateDeDepart = req.getParameter("dateDeDepart");
		String selectedHeureDeDepart = req.getParameter("selectedHeureDeDepart");
		String selectedMinuteDeDepart = req.getParameter("selectedMinuteDeDepart");

		LocalDateTime dateHeureDepartEffective = LocalDateTime.parse(
				dateDeDepart + " " + selectedHeureDeDepart + ":" + selectedMinuteDeDepart,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

		Employe utilisateur = (Employe) session.getAttribute("utilisateur");
		Integer idUtilisateur = utilisateur.getId();

		VehiculeDao vehiculeDao = new VehiculeDao();

		Vehicule vehicule = new Vehicule(immatriculationVehicule, marqueVehicule, modeleVehicule, "vehicule personnel",
				"vehicule personnel", "vehicule personnel", "vehicule personnel", "personnel");
		if (!vehiculeDao.existeDeja(vehicule)) {
			vehiculeDao.ajouterVehiculePersonnel(vehicule);
		}

		Integer idVehicule = vehiculeDao.retrouverIdVehicule(vehicule);

		AnnonceCovoiturage annonceCovoiturage = new AnnonceCovoiturage(nbPlacesVehicule, dateHeureDepartEffective,
				adresseDeDepart, adresseDeDestination, idUtilisateur, idVehicule);
		CovoiturageDao covoiturageDao = new CovoiturageDao();
		covoiturageDao.insererNouvelleAnnonce(annonceCovoiturage);
		req.setAttribute("utilisateur", utilisateur);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/collaborateur/annonces_creer.jsp");
		requestDispatcher.forward(req, resp);
	}

}
