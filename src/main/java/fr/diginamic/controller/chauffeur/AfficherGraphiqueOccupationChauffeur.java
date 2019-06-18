package fr.diginamic.controller.chauffeur;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import fr.diginamic.dao.ResaVehiculeDao;
import fr.diginamic.model.Employe;
import fr.diginamic.model.Occupation;

@WebServlet(urlPatterns = "/controller/chauffeur/occupation")
public class AfficherGraphiqueOccupationChauffeur extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(AfficherGraphiqueOccupationChauffeur.class);

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
	 * pour une page occupation de l'utilisateur kevinAUnePetitePinne concernant des
	 * dates du 3 mai au 6 juin 2019 (et donc un graphique avec ces dates en
	 * abscisse)
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

		HttpSession session = req.getSession(false);

		Employe utilisateurCourant = (Employe) session.getAttribute("utilisateurCourant");

		LocalDate dateDeDebut = LocalDate.parse(req.getParameter("dateDeDebut"), formatter);
		LocalDate dateDeFin = LocalDate.parse(req.getParameter("dateDeFin"), formatter);

		// Verifie si les dates en paramètres sont correctes et si ce n'est pas
		// le cas prend en paramètre la dernière semaine
		// if (!dateEstValide(dateDeDebut) && !dateEstValide(dateDeFin)) {
		// dateDeDebut = dateDujour;
		// dateDeFin = dateDuJourMoinsSeptJour;
		// }

		ResaVehiculeDao resaVehiculeDao = new ResaVehiculeDao();
		List<Occupation> listeDesOccupations = resaVehiculeDao.recupererLesOccupationsCourantes(dateDeDebut, dateDeFin,
				utilisateurCourant);

		// ou alors via (cf ligne) + java dans JSP
		req.setAttribute("listeDesOccupations", listeDesOccupations);
		req.setAttribute("utilisateurCourant", utilisateurCourant);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/chauffeur/occupation.jsp");
		requestDispatcher.forward(req, resp);
	}

}
