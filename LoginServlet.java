package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.TrainDAL;
import database.TrainFactory;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TrainDAL td = TrainFactory.getTrainDALImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String un = req.getParameter("un");
		String pwd = req.getParameter("pwd");
		System.out.println("inside doget");
		boolean ispwd = td.verifypwd(un, pwd);
		if (ispwd) {
			HttpSession hs = req.getSession();
			hs.setAttribute("LOGGEDIN", "YES");
			System.out.println("before sendredirect");
			resp.sendRedirect("tform.html");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");

			rd.forward(req, resp);
		}
	}
}
