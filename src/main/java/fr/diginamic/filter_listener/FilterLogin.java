package fr.diginamic.filter_listener;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/controller/*")
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
		// HttpServletRequest req = (HttpServletRequest) request;
		// HttpSession session = req.getSession(false);
		//
		// if (req.isRequestedSessionIdValid()) {
		// String statut = (String) session.getAttribute("statut");
		// if (statut.equals("admin")) {
		// chain.doFilter(request, response);
		// } else if (statut.equals("chauffeur") &&
		// !req.getPathInfo().contains("admin")) {
		// chain.doFilter(request, response);
		// } else if (statut.equals("collaborateur") &&
		// !req.getPathInfo().contains("chauffeur") && !req.getPathInfo()
		// .contains("admin")) {
		chain.doFilter(request, response);
		// } else {
		// ((HttpServletResponse) response).sendError(403, "Interdit");
		// }
		// } else {
		// RequestDispatcher dispatcher =
		// req.getServletContext().getRequestDispatcher("/gdt/login");
		// }

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
