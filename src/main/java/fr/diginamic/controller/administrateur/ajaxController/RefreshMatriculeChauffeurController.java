package fr.diginamic.controller.administrateur.ajaxController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.diginamic.dao.UtilisateurDao;
import fr.diginamic.model.Chauffeur;

/**
 * Controller permettant à la requete ajax de filtrer les chauffeurs par
 * matricule
 * 
 * @author Kevin.s
 *
 */
@WebServlet(urlPatterns = "/controller/refreshMatriculeChauffeur")
public class RefreshMatriculeChauffeurController extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(RefreshMatriculeChauffeurController.class);

	public RefreshMatriculeChauffeurController() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule = req.getParameter("matricule");
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		List<Chauffeur> listeDesChauffeurs;
		if (matricule.equals("")) {
			listeDesChauffeurs = utilisateurDao.recupererListeDesChauffeurs();
		} else {
			listeDesChauffeurs = utilisateurDao.recupererLesChauffeursParMatricule(matricule);
		}
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String json = gson.toJson(listeDesChauffeurs);
		resp.getWriter().write(json);
	}

}
