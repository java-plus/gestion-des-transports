package fr.diginamic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/init/*")
public class AfficherGraphiqueOccupationChauffeur {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * CategorieDao categorieDao = new CategorieDao();
		 * 
		 * String idCategorie = "-1";
		 * 
		 * List<Categorie> listeDesCategories =
		 * categorieDao.recupererAllCategories();
		 * 
		 * req.setAttribute("categories", listeDesCategories);
		 * 
		 * RequestDispatcher requestDispatcher =
		 * req.getRequestDispatcher("/index.jsp");
		 * requestDispatcher.forward(req, resp);
		 */
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		/*
		 * String selectedCateg = req.getParameter("selectedCateg"); ProduitDao
		 * produitDao = new ProduitDao(); List<Produit> listeDeProduits =
		 * produitDao.recupererAllProduits(selectedCateg);
		 * 
		 * req.setAttribute("produits", listeDeProduits);
		 * 
		 * RequestDispatcher dispatcher =
		 * this.getServletContext().getRequestDispatcher(
		 * "/resultatRecherche.jsp"); dispatcher.forward(req, resp);
		 */
	}

}
