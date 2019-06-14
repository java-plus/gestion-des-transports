package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.diginamic.dao.CovoiturageDao;
import fr.diginamic.model.Annonce;
import fr.diginamic.model.Employe;

@WebServlet(urlPatterns = "/gestion-transports/collaborateur/annonces/*")
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

		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateurCourant");

		CovoiturageDao covoiturageDao = new CovoiturageDao();
		List<Annonce> listeDesAnnonces = covoiturageDao.recupererLesAnnonces(utilisateurCourant);

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesAnnonces", listeDesAnnonces);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/collaborateur/annonces.jsp");
		requestDispatcher.forward(req, resp);
	}

}
