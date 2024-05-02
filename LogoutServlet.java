package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);

		if (hs != null) {
			System.out.println(hs);
			System.out.println("redirect1");
			hs.invalidate();
			System.out.println("redirect2");
			System.out.println(hs);
		}
		// resp.sendRedirect("login.html");

		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
		System.out.println("redirect3");
	}
}