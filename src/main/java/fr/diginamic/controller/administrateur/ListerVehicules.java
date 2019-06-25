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

import fr.diginamic.dao.VehiculeDao;
import fr.diginamic.model.Vehicule;

/**
 * Controller permettant de lister les véhicules et d’ajouter un véhicule
 * 
 * @author Kevin.s
 *
 */
@WebServlet(urlPatterns = "/controller/administrateur/vehicules/*")
public class ListerVehicules extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ListerVehicules.class);

	/**
	 * Methode doGet qui recupère les données (liste des vehicules) quand
	 * l'utilisateur accede à l'url
	 * /gestion-transports/administrateur/vehicules/*
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		SERVICE_LOG.info("get de ListerVehicules lancé");

		VehiculeDao vehiculeDao = new VehiculeDao();
		List<Vehicule> listeDesVehiculesSociete = vehiculeDao.recupererLesVehiculesSociete();
		req.setAttribute("listeDesVehicules", listeDesVehiculesSociete);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/administrateur/vehicules.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String immatriculation = req.getParameter("immatriculationModal");
		String marque = req.getParameter("marqueModal");
		String modele = req.getParameter("modeleModal");
		String categorie = req.getParameter("categorieModal");
		Integer nbPlaces = Integer.parseInt(req.getParameter("nbPlacesModal"));
		String photo = req.getParameter("photoModal");

		Vehicule vehicule = new Vehicule(immatriculation, marque, modele, categorie, photo);
		vehicule.setProprietaire("societe");
		vehicule.setNbPlaces(nbPlaces);

		VehiculeDao vehiculeDao = new VehiculeDao();
		vehiculeDao.ajouterVehicule(vehicule);
		SERVICE_LOG.info("redirect");
		resp.sendRedirect("/gdt/controller/administrateur/vehicules");

	}

}
