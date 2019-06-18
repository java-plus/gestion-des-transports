package fr.diginamic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.UtilisateurDao;
import fr.diginamic.exception.AuthenticateException;
import fr.diginamic.model.Administrateur;
import fr.diginamic.model.Collaborateur;
import fr.diginamic.model.Employe;

/**
 * Servlet assurant l'authentification, la gestion de la création de session et
 * les redirections après authentification.
 */
@WebServlet(urlPatterns = "/login")
public class Authentifier extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(Authentifier.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String email = "";
		String password = "";
		String userId = "";

		try {
			if (request.getParameter("inputEmail") != null && !request.getParameter("inputEmail").isEmpty()
					&& !request.getParameter("inputEmail").contentEquals("null")) {
				email = request.getParameter("inputEmail");
			} else {
				throw new AuthenticateException("Erreur de saisie dans un des champs du login.");
			}
			if (request.getParameter("inputPassword") != null && !request.getParameter("inputPassword").isEmpty()
					&& !request.getParameter("inputPassword").contentEquals("null")) {
				password = request.getParameter("inputPassword");
			} else {
				throw new AuthenticateException("Erreur de saisie dans un des champs du login.");
			}
		} catch (AuthenticateException e) {
			SERVICE_LOG.error("Erreur de saisie dans un des champs du login.", e);
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}

		UtilisateurDao utilisateurDao = new UtilisateurDao();

		try {
			if (utilisateurDao.getUserId(email) != null) {
				userId = utilisateurDao.getUserId(email);
				if (DigestUtils.sha512Hex(password).equalsIgnoreCase(utilisateurDao.getUserPwd(userId))) {
					SERVICE_LOG.info("Utilisateur authentifié.");

					Employe employe = null;
					String endOfUrl = "";

					List<String> userInfos = utilisateurDao.getUserInfosForSession(userId);
					if (userInfos.get(3).equalsIgnoreCase("collaborateur")) {
						employe = new Collaborateur(Integer.parseInt(userInfos.get(0)), userInfos.get(1),
								userInfos.get(2), userInfos.get(3));
						endOfUrl = employe.getStatut().toLowerCase() + "/reservations";
					} else if (userInfos.get(3).equalsIgnoreCase("admin")) {
						employe = new Administrateur(Integer.parseInt(userInfos.get(0)), userInfos.get(1),
								userInfos.get(2), userInfos.get(3));
						endOfUrl = "administrateur/vehicules";
					} else if (userInfos.get(3).equalsIgnoreCase("chauffeur")) {
						employe = new Collaborateur(Integer.parseInt(userInfos.get(0)), userInfos.get(1),
								userInfos.get(2), userInfos.get(3));
						endOfUrl = employe.getStatut().toLowerCase() + "/planning";
					}
					session.setAttribute("utilisateur", employe);
					SERVICE_LOG.info("Authentifier : Place l'objet utilisateur dans la session. Redirection...");
					response.sendRedirect("/gdt/controller/" + endOfUrl);
				} else {
					SERVICE_LOG.error("Erreur d'identification. Email et/ou mot de passe inconnu(s).");
					throw new AuthenticateException("Erreur d'identification. Email et/ou mot de passe inconnu(s).");
				}
			} else {
				SERVICE_LOG.error("Erreur d'identification. Email et/ou mot de passe inconnu(s).");
				throw new AuthenticateException("Erreur d'identification. Email et/ou mot de passe inconnu(s).");
			}
		} catch (AuthenticateException e) {
			SERVICE_LOG.error("Erreur d'identification : mail ou mot de passe non reconnus.");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/index.jsp").include(request, response);
	}
}
