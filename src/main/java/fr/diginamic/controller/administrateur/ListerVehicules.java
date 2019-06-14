package fr.diginamic.controller.administrateur;

import java.io.IOException;
import java.util.List;

import fr.diginamic.controller.WebServlet;
import fr.diginamic.model.Vehicule;

@WebServlet(urlPatterns = "/gestion-transports/administrateur/vehicules/*")
public class ListerVehicules {

	/**
	 * Methode doGet qui recupère les données (liste des vehicules) quand
	 * l'utilisateur accede à l'url
	 * /gestion-transports/administrateur/vehicules/*
	 * 
	 * 
	 *
	 *
	 * 
	 * 
	 * 
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String utilisateurCourant = req.getParameter("utilisateurCourant");

		VehiculeDao vehiculeDao = new VehiculeDao();
		List<Vehicule> listeDesVehicules = vehiculeDao.recupererLesVehiculesSociete();

		// Afficher la graphique
		// TODO Creer la methode afficherLesOccupations(List<Occupation>
		// listeDesOccupations) dans utils pour afficher le graphique lié
		// ou le faire via Java dans JPS?
		afficherLesVehicules(listeDesVehicules);

		// ou alors via (cf ligne) + java dans JSP
		req.setAttribute("listeDesVehicules", listeDesVehicules);
		req.setAttribute("utilisateurCourant", utilisateurCourant);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/vehicules.jsp");
		requestDispatcher.forward(req, resp);
	}

}
