package fr.diginamic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet qui invalide la session et supprime les attributs liés à elle.
 */
@WebServlet(urlPatterns = "/logout")
public class Deconnecter extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(Deconnecter.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		SERVICE_LOG.info("Deconnecter : invalidation de la session.");
		session.invalidate();

		session = request.getSession(false);
		SERVICE_LOG.info("session: " + session);
		response.sendRedirect("/gdt/login");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
