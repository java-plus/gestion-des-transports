package fr.diginamic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller gérant les error et affiche la page d’erreur correspondante
 * 
 * @author Kevin.s
 *
 */
@WebServlet("/ErrorHandler")
public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processError(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processError(request, response);
	}

	/**
	 * méthode gérant l’erreur
	 * 
	 * @param request
	 *            requete http
	 * @param response
	 *            reponse http
	 * @throws IOException
	 * @throws ServletException
	 */
	private void processError(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// customize error message
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown";
		}
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}
		request.setAttribute("error", "Servlet " + servletName + " has thrown an exception "
				+ throwable.getClass().getName() + " : " + throwable.getMessage());

		request.getRequestDispatcher("/gdt/erreur/Erreur.jsp").forward(request, response);
	}
}