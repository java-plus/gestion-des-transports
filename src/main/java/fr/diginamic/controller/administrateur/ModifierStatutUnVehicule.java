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

@WebServlet(urlPatterns = "/controller/administrateur/vehicules/suppr/*")
public class ModifierStatutUnVehicule extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ModifierStatutUnVehicule.class);

	/**
	 * Methode doGet qui récupère les données relative à une voiture puis la
	 * supprime en base de donnée
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
		String nouveauStatut = req.getParameter("nouveauStatut");

		// Verifie si les dates en paramètres sont correctes et si ce n'est pas
		// le cas prend en paramètre la dernière semaine
		// if (!dateEstValide(dateDeDebut) && !dateEstValide(dateDeFin)) {
		// dateDeDebut = dateDujour;
		// dateDeFin = dateDuJourMoinsSeptJour;
		// }

		VehiculeDao vehiculeDao = new VehiculeDao();

		/*
		 * vehiculeDao.modifierStatutVehicule(nouveauStatut, new
		 * Vehicule(immatriculation, marque, modele, categorie, nombreDePlaces, photo));
		 */

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/gdt/controller/administrateur/vehicules/");
		requestDispatcher.forward(req, resp);
	}

}
