package fr.diginamic.controller.collaborateur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.diginamic.dao.CovoiturageDao;
import fr.diginamic.dao.ResaCovoiturageDao;
import fr.diginamic.model.Employe;

/**
 * est la classe permettant d'annuler une reservation. comporte une methode
 * doGet activée quand l'url "/controller/collaborateur/annulerReservation/*"
 * est atteind
 * 
 * 
 * 
 * @author Diginamic02
 *
 */
@WebServlet(urlPatterns = "/controller/collaborateur/annulerReservation/*")
public class AnnulerMaReservation extends HttpServlet {

	/**
	 * methode doGet permettant de supprimer une reservation stockée dans la
	 * base de donnée faite par l'utilisateur. l'url
	 * /controller/collaborateur/annulerReservation?idAnnonceCovoiturage=....
	 * active cette methode l'attribut idAnnonceCovoiturage est alors renseigné
	 * 
	 * Fonctionnement de la méthode: la methode crée une instance de la DAO
	 * ResaCovoiturageDao cette instance appelle une methode
	 * annulerCovoiturage(idAnnonceCovoiturage, idUtilisateur) Cette dernière
	 * active une requete SQL qui supprime dans la table "RESACOVOITURAGE" la
	 * réservation de covoiturage en question Une instance de la DAO
	 * CovoiturageDao est créée. Cette instance appelle une methode
	 * unePlaceReserveEnMoins(idAnnonceCovoiturage) Cette dernière active une
	 * requete SQL qui augmente de 1 dans la table "COVOITURAGE" le nombre de
	 * places disponibles à la ligne correspondant à l'annonce de covoiturage
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateur");

		Integer idAnnonceCovoiturage = Integer.parseInt(req.getParameter("idAnnonceCovoiturage"));

		Integer idUtilisateur = utilisateurCourant.getId();
		ResaCovoiturageDao resaCovoiturageDao = new ResaCovoiturageDao();
		resaCovoiturageDao.annulerCovoiturage(idAnnonceCovoiturage, idUtilisateur);

		CovoiturageDao covoiturageDao = new CovoiturageDao();
		covoiturageDao.unePlaceReserveEnMoins(idAnnonceCovoiturage);
		// Afficher les reservations via la liste listeDesReservations
		// et java dans JSP

		resp.sendRedirect("/gdt/controller/collaborateur/reservations/creer");
	}

}
