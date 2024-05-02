package models;

public class Station {
	String st_id;
	String st_name;

	public String getSt_id() {
		return st_id;
	}

	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public Station(String st_id, String st_name) {
		this.st_id = st_id;
		this.st_name = st_name;
	}
}
