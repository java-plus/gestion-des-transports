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

import fr.diginamic.dao.VehiculeDao;
import fr.diginamic.model.Employe;
import fr.diginamic.model.Vehicule;

@WebServlet(urlPatterns = "/gestion-transports/administrateur/vehicules/*")
public class ListerVehicules extends HttpServlet {

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateurCourant");

		VehiculeDao vehiculeDao = new VehiculeDao();
		List<Vehicule> listeDesVehiculesSociete = vehiculeDao.recupererLesVehiculesSociete();

		// ou alors via (cf ligne) + java dans JSP
		req.setAttribute("listeDesVehicules", listeDesVehiculesSociete);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/vehicules.jsp");
		requestDispatcher.forward(req, resp);
	}

}
