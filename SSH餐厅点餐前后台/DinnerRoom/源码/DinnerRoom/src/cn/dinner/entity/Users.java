package cn.dinner.entity;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ULoginname;
	private String UPwd;
	private String UName;
	private String USex;
	private String UPhone;
	private String UIdcard;
	private String UAddress;
	private Integer URole;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String ULoginname, String UPwd, String UName, String USex,
			String UPhone, String UIdcard, String UAddress, Integer URole) {
		this.ULoginname = ULoginname;
		this.UPwd = UPwd;
		this.UName = UName;
		this.USex = USex;
		this.UPhone = UPhone;
		this.UIdcard = UIdcard;
		this.UAddress = UAddress;
		this.URole = URole;
	}

	// Property accessors
	

	public Integer getId() {
		return this.id;
	}

	public Users(Integer id, String uLoginname, String uPwd, String uName,
			String uSex, String uPhone, String uIdcard, String uAddress,
			Integer uRole) {
		//super();
		this.id = id;
		this.ULoginname = uLoginname;
		this.UPwd = uPwd;
		this.UName = uName;
		this.USex = uSex;
		this.UPhone = uPhone;
		this.UIdcard = uIdcard;
		this.UAddress = uAddress;
		this.URole = uRole;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getULoginname() {
		return this.ULoginname;
	}

	public void setULoginname(String ULoginname) {
		this.ULoginname = ULoginname;
	}

	public String getUPwd() {
		return this.UPwd;
	}

	public void setUPwd(String UPwd) {
		this.UPwd = UPwd;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUSex() {
		return this.USex;
	}

	public void setUSex(String USex) {
		this.USex = USex;
	}

	public String getUPhone() {
		return this.UPhone;
	}

	public void setUPhone(String UPhone) {
		this.UPhone = UPhone;
	}

	public String getUIdcard() {
		return this.UIdcard;
	}

	public void setUIdcard(String UIdcard) {
		this.UIdcard = UIdcard;
	}

	public String getUAddress() {
		return this.UAddress;
	}

	public void setUAddress(String UAddress) {
		this.UAddress = UAddress;
	}

	public Integer getURole() {
		return this.URole;
	}

	public void setURole(Integer URole) {
		this.URole = URole;
	}
}