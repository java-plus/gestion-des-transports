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

@WebServlet(urlPatterns = "/controller/administrateur/vehicules")
public class ListerVehicules extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ListerVehicules.class);

	/**
	 * Methode doGet qui recupère les données (liste des vehicules) quand
	 * l'utilisateur accede à l'url /gestion-transports/administrateur/vehicules/*
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
		// ou alors via (cf ligne) + java dans JSP
		req.setAttribute("listeDesVehicules", listeDesVehiculesSociete);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/administrateur/vehicules.jsp");
		requestDispatcher.forward(req, resp);
	}

}
