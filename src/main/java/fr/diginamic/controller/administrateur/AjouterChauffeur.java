package fr.diginamic.controller.administrateur;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet d'ajout d'un chauffeur dans la base de données.
 */
@WebServlet(urlPatterns = "/controller/administrateur/chauffeurs/ajout/*")
public class AjouterChauffeur extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(AjouterChauffeur.class);
}
