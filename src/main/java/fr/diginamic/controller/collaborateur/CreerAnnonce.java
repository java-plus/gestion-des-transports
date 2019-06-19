package fr.diginamic.controller.collaborateur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.model.Employe;

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

}
