package fr.diginamic.controller.administrateur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.UtilisateurDao;
import fr.diginamic.model.Chauffeur;

/**
 * Servlet d'ajout d'un chauffeur dans la base de données.
 */
@WebServlet(urlPatterns = "/controller/administrateur/chauffeurs/ajouter/*")
public class AjouterChauffeur extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(AjouterChauffeur.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SERVICE_LOG.info("doPost lancé");

		String matricule = null;
		String nom = null;
		String prenom = null;
		String permis = null;
		String email = null;
		String telephone = null;
		String photo = null;
		String mdp = null;

		// récupérer les paramètres
		if (req.getParameter("matriculeModal") != null && !req.getParameter("matriculeModal").isEmpty()) {
			matricule = req.getParameter("matriculeModal");
		}
		if (req.getParameter("nomModal") != null && !req.getParameter("nomModal").isEmpty()) {
			nom = req.getParameter("nomModal");
		}
		if (req.getParameter("prenomModal") != null && !req.getParameter("prenomModal").isEmpty()) {
			prenom = req.getParameter("prenomModal");
		}
		if (req.getParameter("permisModal") != null && !req.getParameter("permisModal").isEmpty()) {
			permis = req.getParameter("permisModal");
		}
		if (req.getParameter("emailModal") != null && !req.getParameter("emailModal").isEmpty()) {
			email = req.getParameter("emailModal");
		}
		if (req.getParameter("telephoneModal") != null && !req.getParameter("telephoneModal").isEmpty()) {
			telephone = req.getParameter("telephoneModal");
		}
		if (req.getParameter("photoModal") != null && !req.getParameter("photoModal").isEmpty()) {
			photo = req.getParameter("photoModal");
		}
		if (req.getParameter("mdpModal") != null && !req.getParameter("mdpModal").isEmpty()) {
			mdp = req.getParameter("mdpModal");
			mdp = DigestUtils.sha512Hex(mdp);
		}

		// créer chauffeur
		Chauffeur chauffeur = new Chauffeur(matricule, permis, photo, telephone, nom, prenom, email, mdp);

		// insérer utilisateur avec fonction DAO
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		utilisateurDao.ajouterChauffeur(chauffeur);

		resp.sendRedirect(req.getContextPath() + "/controller/administrateur/chauffeurs");

	}
}
