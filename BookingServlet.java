package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.TrainDAL;
import database.TrainFactory;
import models.Passenger;
import models.PassengerList;
import models.Ticket;

@WebServlet("/BookServlet")
public class BookingServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TrainDAL td = TrainFactory.getTrainDALImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Access single input parameters
		String from = req.getParameter("inputFrom");
		String to = req.getParameter("inputTwo");
		String train = req.getParameter("inputTrain");
		String date = req.getParameter("inputDate");
		System.out.println(date);
		String travelClass = req.getParameter("inputClass");

		// Access multiple input parameters (like arrays of passengers)
		String[] passengerNames = req.getParameterValues("passengerName[]");
		String[] passengerGenders = req.getParameterValues("passengerGender[]");
		String[] passengerAges = req.getParameterValues("passengerAge[]");
		String[] berthPreferences = req.getParameterValues("berthPreference[]");

		// Prepare a list to store passenger details
		PassengerList passengers = new PassengerList();
		int tckt_no = (int) (Math.random() * (999999 - 100000 + 1)) + 100000;
		int pnr_no = (int) (Math.random() * (9999999 - 1000000 + 1)) + 1000000;
		if (passengerNames != null) {

			for (int i = 0; i < passengerNames.length; i++) {

				String name = passengerNames[i];
				String gender = passengerGenders[i];
				int age = Integer.parseInt(passengerAges[i]);
				String berthPreference = berthPreferences[i];

				// Add to the list of passengers
				passengers.add(new Passenger(tckt_no, name, age, gender, berthPreference));
			}

		}
		int nop = passengers.size();
		int tckt_total = (int) (td.calTotal(nop, from, to, travelClass));
		// Now you can process or save these details as needed
		// Example: Print the details to console (for debugging)
		System.out.println("From: " + from);
		System.out.println("To: " + to);
		System.out.println("Train: " + train);
		System.out.println("Date: " + date);
		System.out.println("Class: " + travelClass);
		System.out.println("NOP:" + nop);
		System.out.println("total:" + tckt_total);
		for (Passenger passenger : passengers) {
			System.out.println("Passenger: " + passenger.toString());
		}
		Ticket ticket = new Ticket(tckt_no, pnr_no, date, from, to, travelClass, tckt_total, nop);
		td.setTcktDetails(passengers, ticket);
		System.out.println("function set tckt details call");

		res.setContentType("application/json");
		// Send response back to client

		Gson gson = new Gson();
		Map<String, Object> m = new HashMap<>();
		m.put("Ticket", ticket);
		m.put("passenegers", passengers);
		res.getWriter().write(gson.toJson(m));
	}
}
