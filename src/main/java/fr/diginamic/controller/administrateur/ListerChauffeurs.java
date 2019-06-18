package fr.diginamic.controller.administrateur;

import java.io.IOException;
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

import fr.diginamic.dao.UtilisateurDao;
import fr.diginamic.model.Chauffeur;
import fr.diginamic.model.Employe;

@WebServlet(urlPatterns = "/controller/administrateur/chauffeurs/*")
public class ListerChauffeurs extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ListerChauffeurs.class);

	/**
	 * Methode doGet qui recupère les données (liste des chauffeurs) quand
	 * l'utilisateur accede à l'url /gestion-transports/administrateur/chauffeurs/*
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

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateurCourant");

		UtilisateurDao utilisateurDao = new UtilisateurDao();
		List<Chauffeur> listeDesChauffeurs = utilisateurDao.recupererListeDesChauffeurs();

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesChauffeurs", listeDesChauffeurs);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/administrateur/chauffeurs.jsp");
		requestDispatcher.forward(req, resp);
	}

}
