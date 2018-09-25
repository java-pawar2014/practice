package com.smarttech.store.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author bpawar
 * @since Aug 18, 2018
 */
@WebServlet(urlPatterns = { "/", "/home", "/welcome" })
public class WelcomeServlet extends HttpServlet {

	private static final long serialVersionUID = 7005387534070919162L;

	public WelcomeServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
