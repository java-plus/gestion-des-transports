package fr.diginamic.filter_listener;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.diginamic.model.Employe;

@WebFilter("/controller/*")
public class FilterLogin implements Filter {

	public FilterLogin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		System.out.println("filter lancé");

		if (req.isRequestedSessionIdValid()) {
			Employe utilisateur = (Employe) session.getAttribute("utilisateur");
			String statut = utilisateur.getStatut();
			System.out.println("statut:" + utilisateur.getStatut());
			if (statut.equals("admin")) {
				chain.doFilter(request, response);
			} else if (statut.equals("chauffeur") && !req.getRequestURI().contains("administrateur")) {
				chain.doFilter(request, response);
			} else if (statut.equals("collaborateur") && !req.getRequestURI().contains("chauffeur")
					&& !req.getRequestURI().contains("admin")) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendError(403, "Interdit");
			}
		} else {
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/gdt/login");
			dispatcher.forward(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}