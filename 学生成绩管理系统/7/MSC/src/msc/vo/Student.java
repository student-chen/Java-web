package msc.vo;

public class Student {

	private String sid;
	private String sname;
	private String smajor;
	private String sclass;
	private double tcredit;
	private double tcreditjd;
	private double ocredit;
	private double acredit;
	private double egrade;
	private int majorpm;
	private int classpm;
	private String scode;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSmajor() {
		return smajor;
	}

	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public double getTcredit() {
		return tcredit;
	}

	public void setTcredit(double tcredit) {
		this.tcredit = tcredit;
	}

	public double getAcredit() {
		return acredit;
	}

	public double getTcreditjd() {
		return tcreditjd;
	}

	public void setTcreditjd(double tcreditjd) {
		this.tcreditjd = tcreditjd;
	}

	public double getOcredit() {
		return ocredit;
	}

	public void setOcredit(double ocredit) {
		this.ocredit = ocredit;
	}

	public void setAcredit(double acredit) {
		this.acredit = acredit;
	}

	public double getEgrade() {
		return egrade;
	}

	public void setEgrade(double egrade) {
		this.egrade = egrade;
	}

	public int getMajorpm() {
		return majorpm;
	}

	public void setMajorpm(int majorpm) {
		this.majorpm = majorpm;
	}

	public int getClasspm() {
		return classpm;
	}

	public void setClasspm(int classpm) {
		this.classpm = classpm;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}
}
