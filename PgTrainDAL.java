package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbUtilities.JdbcConnection;
import models.Passenger;
import models.Station;
import models.StationsList;
import models.Ticket;
import models.Train;
import models.TrainsList;

public class PgTrainDAL implements TrainDAL {
	public static Connection con;
	public StationsList sl = new StationsList();
	public TrainsList tl = new TrainsList();
	PreparedStatement st;
	ResultSet rs;

	public PgTrainDAL() {
		con = null;
		con = JdbcConnection.getConnection();
	}

	public ArrayList<Station> getStations() {
		try {

			PreparedStatement st = con.prepareStatement("Select * from i225station");
			ResultSet rs = st.executeQuery();
			sl = new StationsList();
			while (rs.next()) {

				sl.add(new Station(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
		}
		return sl;

	}

	public ArrayList<Train> getTrains(String fromSt, String toSt) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement st = con.prepareStatement("SELECT t.train_no, t.train_name,t.train_schedule\r\n"
					+ "FROM i225train_station ts\r\n" + "JOIN i225train t ON ts.train_no = t.train_no\r\n"
					+ "JOIN i225station s ON ts.st_id = s.st_id\r\n" + "WHERE s.st_id = ? OR s.st_id = ?\r\n"
					+ "GROUP BY t.train_no, t.train_name,t.train_schedule\r\n" + "HAVING COUNT(*) = 2");
			st.setString(1, fromSt);
			st.setString(2, toSt);
			ResultSet rs = st.executeQuery();
			tl = new TrainsList();
			while (rs.next()) {

				tl.add(new Train(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (Exception e) {
		}
		return tl;
	}

	public boolean verifypwd(String un, String pwd) {
		// TODO Auto-generated method stub
		boolean ispwd = false;
		try {
			PreparedStatement st = con.prepareStatement("Select password from i225login where username=?");
			st.setString(1, un);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				System.out.println(pwd);
				System.out.println(rs.getString(1));
				if (rs.getString(1).equals(pwd)) {
					ispwd = true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ispwd;
	}

	public void setTcktDetails(List<Passenger> passengers, Ticket t) {
		System.out.println("tckt details exec");
		// TODO Auto-generated method stub
		PreparedStatement st;
		try {
			st = con.prepareStatement("insert into i225ticket values(?,?,?,?,?,?,?,?)");
			st.setInt(1, t.getTckt_no());
			st.setInt(2, t.getTckt_pnr_no());
			String travelDateStr = t.getTckt_travel_date();
			java.sql.Date travelDate = java.sql.Date.valueOf(travelDateStr); // Assuming the date is in 'YYYY-MM-DD' //
																				// format
			st.setDate(3, travelDate);
			st.setString(4, t.getTckt_from());
			st.setString(5, t.getTckt_to());
			st.setString(6, t.getTckt_class());
			st.setInt(7, t.getTckt_total());
			st.setInt(8, t.getNop());
			st.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st = con.prepareStatement("insert into i225passenger values(?,?,?,?,?)");
			for (Passenger p : passengers) {
				st.setInt(1, p.getTckt_no());
				st.setString(2, p.getpsng_name());
				st.setInt(3, p.getPsng_age());
				st.setString(4, p.getPsng_gender());
				st.setString(5, p.getPsng_berth());
				st.addBatch();
			}
			st.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int calTotal(int nop, String from, String to, String travelClass) {
		int total = 0;
		try {
			st = con.prepareStatement("select * from getbill(?,?,?,?)");
			st.setInt(1, nop);
			st.setString(2, from);
			st.setString(3, to);
			st.setString(4, travelClass);
			rs = st.executeQuery();
			rs.next();
			total = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
}
