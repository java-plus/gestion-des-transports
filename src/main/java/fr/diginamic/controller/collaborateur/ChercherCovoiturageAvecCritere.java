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
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.model.Employe;

/**
 * est la classe permettant de lister les annonces de covoiturages disponibles
 * pour l'utilisateur courant et qui correspondent à 3 critères (lieu de départ,
 * lieu d'arrivée, date de départ). comporte une methode doGet activée quand
 * l'url "/controller/collaborateur/chercherannonces/*" est atteint.
 * 
 * Cette classe est "jumelle" de la classe ChercherCovoiturage
 * 
 * @author Diginamic02
 *
 */
@WebServlet(urlPatterns = "/controller/collaborateur/chercherannoncesAvecCritere/*")
public class ChercherCovoiturageAvecCritere extends HttpServlet {
	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ChercherCovoiturage.class);

	/**
	 * Methode doGet qui recupère toutes les annonces de covoiturage quand
	 * l'utilisateur accede à l'url /gestion-transports/collaborateur/annonces/*
	 * La liste des annonce retournée et traitée pour affichage par la JSP
	 * contient toutes les annonces de covoiturages qui n'ont pas été émises par
	 * l'utilisateur courant et dont la date de départ est antérieure à la date
	 * du jour puis trie ces annonces selon 3 critères
	 * 
	 * Fonctionnement de la méthode: _ récupère l'éléments utilisateur courant
	 * (pour savoir s'il est admin, collaborateur ou chauffeur) _ récupère les
	 * éléments : lieuDeDestination,lieuDeDepart,dateDeDepart _ instancie la DAO
	 * CovoiturageDao qui appelera la méthode "recupererLesAnnoncesAvecCritere"
	 * pour récupérer une liste d'annonces de covoiturage correspondant aux
	 * critères evoqués plus haut. _stocke les variables
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

		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateur");

		String lieuDeDestination = (String) req.getParameter("lieuDeDestination");
		String lieuDeDepart = (String) req.getParameter("lieuDeDepart");
		String dateDeDepart = (String) req.getParameter("dateDeDepart");
		System.out.println(dateDeDepart);
		CovoiturageDao covoiturageDao = new CovoiturageDao();
		List<AnnonceCovoiturage> listeDesAnnonces = covoiturageDao.recupererLesAnnoncesAvecCritere(lieuDeDepart,
				lieuDeDestination, dateDeDepart);

		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP
		req.setAttribute("listeDesAnnonces", listeDesAnnonces);
		req.setAttribute("lieuDeDestination", lieuDeDestination);
		req.setAttribute("lieuDeDepart", lieuDeDepart);
		req.setAttribute("dateDeDepart", dateDeDepart);
		Integer idUtilisateur = utilisateurCourant.getId();
		req.setAttribute("idUtilisateur", idUtilisateur);
		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/WEB-INF/collaborateur/chercherCovoiturage.jsp");
		requestDispatcher.forward(req, resp);
	}
}
