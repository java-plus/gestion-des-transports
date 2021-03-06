package fr.diginamic.controller.administrateur;

import java.io.IOException;

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
import fr.diginamic.model.Employe;

@WebServlet(urlPatterns = "/controller/administrateur/vehicules/ajout/*")
public class AjouterVehicule extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(AjouterVehicule.class);

	/**
	 * Methode doGet qui affiche les données quand l'utilisateur accede à l'url
	 * /gestion-transports/chauffeur/occupation/*
	 * 
	 * 
	 *
	 * dans cette url se trouve: un attribut utilisateur sous la forme
	 * ?utilisateur=toto une date de début et une date de fin sous la forme
	 * ?dateDeDebut=01062019 (pour 1er juin 2019) donc exemple d'url
	 * /gestion-transports/chauffeur/occupation?utilisateur=kevinAUnePetitePinne&dateDeDebut=03052019&dateDeFin=03062019
	 * pour une page occupation de l'utilisateur kevinAUnePetitePinne concernant
	 * des dates du 3 mai au 6 juin 2019 (et donc un graphique avec ces dates en
	 * abscisse)
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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateurCourant");

		String immatriculation = req.getParameter("immatriculation");
		String marque = req.getParameter("marque");
		String modele = req.getParameter("modele");
		String categorie = req.getParameter("categorie");
		Integer nombreDePlaces = Integer.parseInt(req.getParameter("nombreDePlaces"));
		String photo = req.getParameter("photo");

		VehiculeDao vehiculeDao = new VehiculeDao();

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/administrateur/vehicules/");
		requestDispatcher.forward(req, resp);
	}

}
