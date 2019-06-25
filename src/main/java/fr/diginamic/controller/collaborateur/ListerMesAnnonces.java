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

import fr.diginamic.dao.CovoiturageDao;
import fr.diginamic.dao.ResaCovoiturageDao;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.model.Employe;

@WebServlet(urlPatterns = "/controller/collaborateur/annonces/*")
public class ListerMesAnnonces extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ListerMesAnnonces.class);

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
		Integer idUtilisateurCourant = utilisateurCourant.getId();
		CovoiturageDao covoiturageDao = new CovoiturageDao();
		List<AnnonceCovoiturage> listeDesAnnoncesEnCours = covoiturageDao
				.recupererLesAnnoncesEnCours(idUtilisateurCourant);
		List<AnnonceCovoiturage> listeDesAnnoncesPassees = covoiturageDao
				.recupererLesAnnoncesPassees(idUtilisateurCourant);
		List<Integer> listeDesNombresDeReservationsEnCours = new ArrayList<>();
		for (AnnonceCovoiturage annonceCovoiturage : listeDesAnnoncesEnCours) {
			ResaCovoiturageDao resaCovoiturageDao = new ResaCovoiturageDao();
			listeDesNombresDeReservationsEnCours
					.add(resaCovoiturageDao.combienDePersonnesOntReserve(annonceCovoiturage.getIdAnnonceCovoiturage()));
		}
		List<Integer> listeDesNombresDeReservationsPassees = new ArrayList<>();
		for (AnnonceCovoiturage annonceCovoiturage : listeDesAnnoncesEnCours) {
			ResaCovoiturageDao resaCovoiturageDao = new ResaCovoiturageDao();
			listeDesNombresDeReservationsPassees
					.add(resaCovoiturageDao.combienDePersonnesOntReserve(annonceCovoiturage.getIdAnnonceCovoiturage()));
		}
		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesAnnoncesEnCours", listeDesAnnoncesEnCours);
		req.setAttribute("listeDesAnnoncesPassees", listeDesAnnoncesPassees);
		req.setAttribute("listeDesNombresDeReservationsEnCours", listeDesNombresDeReservationsEnCours);
		req.setAttribute("listeDesNombresDeReservationsEnCours", listeDesNombresDeReservationsPassees);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/collaborateur/annonces.jsp");
		requestDispatcher.forward(req, resp);
	}

}
