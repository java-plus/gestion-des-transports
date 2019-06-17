package fr.diginamic.controller.administrateur.ajaxController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.diginamic.dao.VehiculeDao;
import fr.diginamic.model.Vehicule;

@WebServlet(urlPatterns = "/controllers/refreshImmatriculation")
public class RefreshImmatriculationController extends HttpServlet {

	public RefreshImmatriculationController() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String immatriculation = req.getParameter("immatriculation");
		VehiculeDao vehiculeDao = new VehiculeDao();
		List<Vehicule> listeVehicule = vehiculeDao.recupererLesVehiculesParImmatriculation(immatriculation);
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String json = gson.toJson(listeVehicule);
		resp.getWriter().write(json);
	}

}
