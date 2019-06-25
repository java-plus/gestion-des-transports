package fr.diginamic.controller.chauffeur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.diginamic.dao.ResaVehiculeDao;
import fr.diginamic.model.Employe;

/**
 * Controller permettant d’accepter une reservation
 * 
 * @author Kevin.s
 *
 */
@WebServlet(urlPatterns = "/controller/chauffeur/accepterReservation/*")
public class accepterReservation extends HttpServlet {

	public accepterReservation() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idResa = Integer.parseInt(req.getParameter("id"));
		Integer idChauffeur = ((Employe) req.getSession().getAttribute("utilisateur")).getId();
		ResaVehiculeDao vehiculeDao = new ResaVehiculeDao();
		vehiculeDao.accepterReservation(idResa, idChauffeur);
		resp.sendRedirect("/gdt/controller/chauffeur/planning");

	}

}
