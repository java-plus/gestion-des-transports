package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.diginamic.dao.CovoiturageDao;
import fr.diginamic.model.AnnonceCovoiturage;

@WebServlet(urlPatterns = "/controllers/annonces/*")
public class ListerMesAnnonces extends HttpServlet {

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// HttpSession session = req.getSession(false);
		//
		// Employe utilisateurCourant = (Employe)
		// session.getAttribute("utilisateurCourant");
		Integer idUtilisateurCourant = 1;
		CovoiturageDao covoiturageDao = new CovoiturageDao();
		List<AnnonceCovoiturage> listeDesAnnonces = covoiturageDao.recupererLesAnnonces(idUtilisateurCourant);

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesAnnonces", listeDesAnnonces);

		for (AnnonceCovoiturage annonceCovoiturage : listeDesAnnonces) {
			System.out.println(annonceCovoiturage.getDateDeDepart());
			System.out.println(annonceCovoiturage.getIdAnnonceCovoiturage());
			System.out.println(annonceCovoiturage.getNbPlacesDisponibles());
			System.out.println(annonceCovoiturage.getDateDeDepart());
			System.out.println(annonceCovoiturage.getLieuDeDepart());
			System.out.println(annonceCovoiturage.getLieuDeDestination());
			System.out.println(annonceCovoiturage.getDuree());
			System.out.println(annonceCovoiturage.getDistanceEnKm());
			System.out.println(annonceCovoiturage.getIdUtilisateur());
			System.out.println(annonceCovoiturage.getIdVehicule());
		}

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/collaborateur/annonces.jsp");
		requestDispatcher.forward(req, resp);
	}

}
