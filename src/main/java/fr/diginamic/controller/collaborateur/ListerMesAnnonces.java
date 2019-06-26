package fr.diginamic.controller.collaborateur;

import java.io.IOException;
import java.util.ArrayList;
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
import fr.diginamic.dao.ResaCovoiturageDao;
import fr.diginamic.model.AnnonceCovoiturage;
import fr.diginamic.model.Employe;

/**
 * Controller permettant de lister les annonces d’un utilisateur
 * 
 * @author Kevin.s
 *
 */
@WebServlet(urlPatterns = "/controller/collaborateur/annonces/*")
public class ListerMesAnnonces extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(ListerMesAnnonces.class);

	/**
	 * Methode doGet qui recupère la liste des annonces qu'a créé l'utilisateur
	 * courant ainsi que le nombre de réservation qui ont été faites par d'autres
	 * utilisateur sur ce trajet
	 * 
	 * Fonctionnement de la méthode: _crée un instant de la DAO CovoiturageDao
	 * _celle ci appelle la methode recupererLesAnnonces(idUtilisateurCourant) qui
	 * retourne une liste "listeDesAnnonces" _ pour chaque élément (annonce) de
	 * cette liste (dans une boucle for) -> une instance de la dao
	 * ResaCovoiturageDao est créée -> celle ci appelle une methode
	 * combienDePersonnesOntReserve(annonceCovoiturage.getIdAnnonceCovoiturage())
	 * qui, via une requete SQL sur la base RESACOVOITURAGE, compte le nombre de
	 * réservations qui ont été faites sur cette réservation
	 * 
	 * les variables listeDesAnnonces et listeDesNombresDeReservations sont alors
	 * stockées pour etre traitées par la JSP pour affichage
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
		Integer idUtilisateurCourant = utilisateurCourant.getId();
		CovoiturageDao covoiturageDao = new CovoiturageDao();
		List<AnnonceCovoiturage> listeDesAnnoncesEnCours = covoiturageDao
				.recupererLesAnnoncesEnCours(idUtilisateurCourant);
		List<AnnonceCovoiturage> listeDesAnnoncesPassees = covoiturageDao
				.recupererLesAnnoncesPassees(idUtilisateurCourant);
		List<Integer> listeDesNombresDeReservationsEnCours = new ArrayList<>();
		for (AnnonceCovoiturage annonceCovoiturage : listeDesAnnoncesEnCours) {
			ResaCovoiturageDao resaCovoiturageDao = new ResaCovoiturageDao();
			listeDesNombresDeReservationsEnCours
					.add(resaCovoiturageDao.combienDePersonnesOntReserve(annonceCovoiturage.getIdAnnonceCovoiturage()));
		}
		List<Integer> listeDesNombresDeReservationsPassees = new ArrayList<>();
		for (AnnonceCovoiturage annonceCovoiturage : listeDesAnnoncesPassees) {
			ResaCovoiturageDao resaCovoiturageDao = new ResaCovoiturageDao();
			listeDesNombresDeReservationsPassees
					.add(resaCovoiturageDao.combienDePersonnesOntReserve(annonceCovoiturage.getIdAnnonceCovoiturage()));
		}

		req.setAttribute("listeDesAnnoncesEnCours", listeDesAnnoncesEnCours);
		req.setAttribute("listeDesAnnoncesPassees", listeDesAnnoncesPassees);
		req.setAttribute("listeDesNombresDeReservationsEnCours", listeDesNombresDeReservationsEnCours);
		req.setAttribute("listeDesNombresDeReservationsPassees", listeDesNombresDeReservationsPassees);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/collaborateur/annonces.jsp");
		requestDispatcher.forward(req, resp);
	}

}
