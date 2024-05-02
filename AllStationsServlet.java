package controllers;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.TrainDAL;
import database.TrainFactory;

@WebServlet("/getAllStations")
public class AllStationsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Gson gson = null;
	TrainDAL db = null;

	public AllStationsServlet() {
		db = TrainFactory.getTrainDALImpl();
		gson = new Gson();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("application/json");
		String s = gson.toJson(db.getStations());

		try {
			res.getWriter().write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
