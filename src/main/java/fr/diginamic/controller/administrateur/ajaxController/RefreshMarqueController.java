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

import fr.diginamic.dao.VehiculeDao;
import fr.diginamic.model.Vehicule;

@WebServlet(urlPatterns = "/controller/refreshMarque")
public class RefreshMarqueController extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(RefreshMarqueController.class);

	public RefreshMarqueController() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String marque = req.getParameter("marque");
		VehiculeDao vehiculeDao = new VehiculeDao();
		List<Vehicule> listeVehicule = vehiculeDao.recupererLesVehiculesParMarque(marque);
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String json = gson.toJson(listeVehicule);
		resp.getWriter().write(json);
	}

}
