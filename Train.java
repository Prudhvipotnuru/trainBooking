package models;

public class Train {
	int tno;
	String tname;
	String tsch;

	public Train(int tno, String tname, String tsch) {
		this.tno = tno;
		this.tname = tname;
		this.tsch = tsch;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTsch() {
		return tsch;
	}

	public void setTsch(String tsch) {
		this.tsch = tsch;
	}
}
