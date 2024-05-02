package controllers;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.TrainDAL;
import database.TrainFactory;

@WebServlet("/getTrains")
public class TrainsServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Gson gson = null;
	TrainDAL td = null;

	public TrainsServlet() {
		td = TrainFactory.getTrainDALImpl();
		gson = new Gson();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		String FromSt = req.getParameter("from");
		String ToSt = req.getParameter("to");
		res.setContentType("application/json");
		String s = gson.toJson(td.getTrains(FromSt, ToSt));
		try {
			res.getWriter().write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
