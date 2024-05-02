package models;

public class Ticket {
	int tckt_no;
	int tckt_pnr_no;
	String tckt_travel_date;
	String tckt_from;
	String tckt_to;
	String tckt_class;
	int tckt_total;
	int nop;

	public Ticket(int tckt_no, int tckt_pnr_no, String tckt_travel_date, String tckt_from, String tckt_to,
			String tckt_class, int tckt_total, int nop) {
		super();
		this.tckt_no = tckt_no;
		this.tckt_pnr_no = tckt_pnr_no;
		this.tckt_travel_date = tckt_travel_date;
		this.tckt_from = tckt_from;
		this.tckt_to = tckt_to;
		this.tckt_class = tckt_class;
		this.tckt_total = tckt_total;
		this.nop = nop;
	}

	public int getTckt_no() {
		return tckt_no;
	}

	public void setTckt_no(int tckt_no) {
		this.tckt_no = tckt_no;
	}

	public int getTckt_pnr_no() {
		return tckt_pnr_no;
	}

	public void setTckt_pnr_no(int tckt_pnr_no) {
		this.tckt_pnr_no = tckt_pnr_no;
	}

	public String getTckt_travel_date() {
		return tckt_travel_date;
	}

	public void setTckt_travel_date(String tckt_travel_date) {
		this.tckt_travel_date = tckt_travel_date;
	}

	public String getTckt_from() {
		return tckt_from;
	}

	public void setTckt_from(String tckt_from) {
		this.tckt_from = tckt_from;
	}

	public String getTckt_to() {
		return tckt_to;
	}

	public void setTckt_to(String tckt_to) {
		this.tckt_to = tckt_to;
	}

	public String getTckt_class() {
		return tckt_class;
	}

	public void setTckt_class(String tckt_class) {
		this.tckt_class = tckt_class;
	}

	public int getTckt_total() {
		return tckt_total;
	}

	public void setTckt_total(int tckt_total) {
		this.tckt_total = tckt_total;
	}

	public int getNop() {
		return nop;
	}

	public void setNop(int nop) {
		this.nop = nop;
	}

	@Override
	public String toString() {
		return "Ticket [tckt_no=" + tckt_no + ", tckt_pnr_no=" + tckt_pnr_no + ", tckt_travel_date=" + tckt_travel_date
				+ ", tckt_from=" + tckt_from + ", tckt_to=" + tckt_to + ", tckt_class=" + tckt_class + ", tckt_total="
				+ tckt_total + ", nop=" + nop + "]";
	}
}
