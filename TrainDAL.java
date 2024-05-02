package database;

import java.util.ArrayList;
import java.util.List;

import models.Passenger;
import models.Station;
import models.Ticket;
import models.Train;

public interface TrainDAL {
	public ArrayList<Station> getStations();

	public ArrayList<Train> getTrains(String fromSt, String toSt);

	public boolean verifypwd(String un, String pwd);

	public void setTcktDetails(List<Passenger> passengers, Ticket t);

	public int calTotal(int nop, String from, String to, String travelClass);
}
