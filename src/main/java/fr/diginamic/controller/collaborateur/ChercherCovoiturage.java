package fr.diginamic.controller.collaborateur;

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

import fr.diginamic.dao.CovoiturageDao;
import fr.diginamic.dao.UtilisateurDao;
import fr.diginamic.dao.VehiculeDao;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.model.Employe;
import fr.diginamic.model.Vehicule;

/**
 * est la classe permettant de lister les annonces de covoiturages disponibles
 * pour l'utilisateur courant. comporte une methode doGet activée quand l'url
 * "/controller/collaborateur/chercherannonces/*" est atteint.
 * 
 * Cette classe est "jumelle" de la classe ChercherCovoiturageAvecCritères
 * 
 * 
 * @author Diginamic02
 *
 */
@WebServlet(urlPatterns = "/controller/collaborateur/chercherannonces/*")
public class ChercherCovoiturage extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ChercherCovoiturage.class);

	/**
	 * Methode doGet qui recupère toutes les annonces de covoiturage quand
	 * l'utilisateur accede à l'url /gestion-transports/collaborateur/annonces/*
	 * La liste des annonce retournée et traitée pour affichage par la JSP
	 * contient toutes les annonces de covoiturages qui n'ont pas été émises par
	 * l'utilisateur courant et dont la date de départ est antérieure à la date
	 * du jour
	 * 
	 * Fonctionnement de la méthode: _ récupère l'éléments utilisateur courant
	 * (pour savoir s'il est admin, collaborateur ou chauffeur) _ crée avec les
	 * valeurs "indeterminé" les variables
	 * lieuDeDestination,lieuDeDepart,dateDeDepart NOTA BENE : ces variables
	 * correspondent aux critères utilisés dans la classe
	 * ChercherCovoiturageAvecCritères _ instancie la DAO CovoiturageDao qui
	 * appelera la méthode "recupererLesAnnoncesDisponiblesPourUtilisateur" pour
	 * récupérer une liste d'annonces de covoiturage correspondant aux critères
	 * evoqués plus haut. _stocke les variables
	 * listeDesAnnonces,lieuDeDepart,lieuDeDestination,idUtilisateur,dateDeDepart
	 * qui seront traités par la JSP
	 * "/WEB-INF/collaborateur/chercherCovoiturage.jsp" pour affichage
	 * 
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODOOOOOOOOOOOOOOOOOOOOOO
		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateur");
		String lieuDeDestination = "indeterminé";// req.getParameter("lieuDeDestination");
		String lieuDeDepart = "indeterminé";// req.getParameter("lieuDeDestination");
		String dateDeDepart = "indeterminé";
		CovoiturageDao covoiturageDao = new CovoiturageDao();
		List<AnnonceCovoiturage> listeDesAnnonces = covoiturageDao
				.recupererLesAnnoncesDisponiblesPourUtilisateur(utilisateurCourant.getId());

		UtilisateurDao utilisateurDao = new UtilisateurDao();
		List<Employe> listeEmploye = utilisateurDao.recupererEmploye();

		VehiculeDao vehiculeDao = new VehiculeDao();
		List<Vehicule> listeVehicule = vehiculeDao.recupererVehiculesIdImmat();

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeVehicule", listeVehicule);
		req.setAttribute("listeEmploye", listeEmploye);
		req.setAttribute("listeDesAnnonces", listeDesAnnonces);
		req.setAttribute("lieuDeDestination", lieuDeDestination);
		Integer idUtilisateur = utilisateurCourant.getId();
		req.setAttribute("idUtilisateur", idUtilisateur);
		req.setAttribute("lieuDeDepart", lieuDeDepart);
		req.setAttribute("dateDeDepart", dateDeDepart);
		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/WEB-INF/collaborateur/chercherCovoiturage.jsp");
		requestDispatcher.forward(req, resp);
	}

}
