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

@WebServlet(urlPatterns = "/controller/collaborateur/annulerReservation/*")
public class AnnulerMaReservation extends HttpServlet {

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
