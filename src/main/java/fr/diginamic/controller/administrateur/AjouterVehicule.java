package fr.diginamic.controller.administrateur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.diginamic.dao.VehiculeDao;
import fr.diginamic.model.Employe;

@WebServlet(urlPatterns = "/gestion-transports/admin/vehicules/ajout/*")
public class AjouterVehicule extends HttpServlet {

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateurCourant");

		String immatriculation = req.getParameter("immatriculation");
		String marque = req.getParameter("marque");
		String modele = req.getParameter("modele");
		String categorie = req.getParameter("categorie");
		Integer nombreDePlaces = Integer.parseInt(req.getParameter("nombreDePlaces"));
		String photo = req.getParameter("photo");

		// Verifie si les dates en paramètres sont correctes et si ce n'est pas
		// le cas prend en paramètre la dernière semaine
		// if (!dateEstValide(dateDeDebut) && !dateEstValide(dateDeFin)) {
		// dateDeDebut = dateDujour;
		// dateDeFin = dateDuJourMoinsSeptJour;
		// }

		VehiculeDao vehiculeDao = new VehiculeDao();

		// vehiculeDao.ajouterVehicule(new Vehicule(immatriculation, marque,
		// modele, categorie, nombreDePlaces, photo));

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/gestion-transports/administrateur/vehicules/");
		requestDispatcher.forward(req, resp);
	}

}
