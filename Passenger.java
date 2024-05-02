package models;

public class Passenger {
	int tckt_no;
	String psng_name;
	int psng_age;
	String psng_gender;
	String psng_berth;

	public Passenger(int tckt_no, String psng_name, int psng_age, String psng_gender, String psng_berth) {
		super();
		this.tckt_no = tckt_no;
		this.psng_name = psng_name;
		this.psng_age = psng_age;
		this.psng_gender = psng_gender;
		this.psng_berth = psng_berth;
	}

	public int getTckt_no() {
		return tckt_no;
	}

	public void setTckt_no(int tckt_no) {
		this.tckt_no = tckt_no;
	}

	public String getpsng_name() {
		return psng_name;
	}

	public void setpsng_name(String psng_name) {
		this.psng_name = psng_name;
	}

	public int getPsng_age() {
		return psng_age;
	}

	public void setPsng_age(int psng_age) {
		this.psng_age = psng_age;
	}

	public String getPsng_gender() {
		return psng_gender;
	}

	public void setPsng_gender(String psng_gender) {
		this.psng_gender = psng_gender;
	}

	@Override
	public String toString() {
		return "Passenger [tckt_no=" + tckt_no + ", psng_name=" + psng_name + ", psng_age=" + psng_age
				+ ", psng_gender=" + psng_gender + ", psng_berth=" + psng_berth + "]";
	}

	public String getPsng_berth() {
		return psng_berth;
	}

	public void setPsng_berth(String psng_berth) {
		this.psng_berth = psng_berth;
	}
}
