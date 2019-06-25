package fr.diginamic.controller.chauffeur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/controller/chauffeur/planning")
public class AfficherPlanningChauffeur extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(AfficherPlanningChauffeur.class);

	/**
	 * Methode doGet qui affiche les données quand l'utilisateur accede à l'url
	 * /gestion-transports/chauffeur/planning/*
	 * 
	 * 
	 *
	 * dans cette url se trouve: un attribut utilisateur sous la forme
	 * ?utilisateur=toto
	 * 
	 * un jour courant sous la forme ?jourCourant=01062019 (pour 1er juin 2019)
	 * donc exemple d'url
	 * /gestion-transports/chauffeur/planning?utilisateur=JbSaitPasSoccuperDeSonBebe&jourCourant=06042019
	 * pour une page occupation de l'utilisateur JbSaitPasSoccuperDeSonBebe
	 * concernant la date du 6 avril 2019 (et donc un planning avec ces dates)
	 * 
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

		/*
		 * DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("ddMMyyyy");
		 * 
		 * HttpSession session = req.getSession(false);
		 * 
		 * Employe utilisateurCourant = (Employe)
		 * session.getAttribute("utilisateurCourant"); LocalDate jourCourant =
		 * LocalDate.parse(req.getParameter("jourCourant"), formatter);
		 */

		// Verifie si les dates en paramètres sont correctes et si ce n'est pas
		// le cas prend en paramètre la dernière semaine
		// if (!dateEstValide(jourCourant)) {
		// jourCourant = dateDujour;
		//
		// }

		/*
		 * ResaVehiculeDao resaVehiculeDao = new ResaVehiculeDao();
		 * List<Planning> listeDesTachesDuJourCourant =
		 * resaVehiculeDao.recupererLesTachesDuJourCourant(jourCourant,
		 * utilisateurCourant);
		 */

		// pour java dans JSP
		/*
		 * req.setAttribute("listeDesTachesDuJourCourant",
		 * listeDesTachesDuJourCourant); req.setAttribute("utilisateurCourant",
		 * utilisateurCourant);
		 */

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/chauffeur/planning.jsp");
		requestDispatcher.forward(req, resp);
	}

}
