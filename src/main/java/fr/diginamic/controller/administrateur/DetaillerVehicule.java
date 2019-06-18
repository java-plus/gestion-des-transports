package fr.diginamic.controller.administrateur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.VehiculeDao;
import fr.diginamic.model.Vehicule;

/**
 * Servlet gérant l'affichage de la page d'information d'un véhicule de la
 * société.
 */
@WebServlet(urlPatterns = "/controller/administrateur/vehicules/vehicule/*")
public class DetaillerVehicule extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(AjouterVehicule.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SERVICE_LOG.info("Servlet DetaillerVehicule lancée : doGet");

		String immatriculation = req.getAttribute("immatriculation").toString();
		VehiculeDao vehiculeDao = new VehiculeDao();

		Vehicule vehicule = null;
		if (vehiculeDao.recupererLesVehiculesParImmatriculation(immatriculation) != null) {
			vehicule = vehiculeDao.recupererLesVehiculesParImmatriculation(immatriculation).get(0);
		}

		req.setAttribute("vehicule", vehicule);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/administrateur/vehicule.jsp");
		requestDispatcher.forward(req, resp);
	}

}
