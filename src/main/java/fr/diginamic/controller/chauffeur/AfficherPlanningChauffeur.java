package fr.diginamic.controller.chauffeur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller permettant de rediriger vers le planning du chauffeur
 * 
 * @author Kevin.s
 *
 */
@WebServlet(urlPatterns = "/controller/chauffeur/planning")
public class AfficherPlanningChauffeur extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(AfficherPlanningChauffeur.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/chauffeur/planning.jsp");
		requestDispatcher.forward(req, resp);
	}

}
