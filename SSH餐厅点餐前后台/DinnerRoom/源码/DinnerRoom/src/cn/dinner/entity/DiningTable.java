package cn.dinner.entity;

/**
 * DiningTable entity. @author MyEclipse Persistence Tools
 */

public class DiningTable implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tableNum;
	private Integer tablePernum;
	private Integer isno;

	// Constructors

	/** default constructor */
	public DiningTable() {
	}

	/** full constructor */
	public DiningTable(String tableNum, Integer tablePernum, Integer isno) {
		this.tableNum = tableNum;
		this.tablePernum = tablePernum;
		this.isno = isno;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public DiningTable(Integer id, String tableNum, Integer tablePernum,
			Integer isno) {
		//super();
		this.id = id;
		this.tableNum = tableNum;
		this.tablePernum = tablePernum;
		this.isno = isno;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableNum() {
		return this.tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}

	public Integer getTablePernum() {
		return this.tablePernum;
	}

	public void setTablePernum(Integer tablePernum) {
		this.tablePernum = tablePernum;
	}

	public Integer getIsno() {
		return this.isno;
	}

	public void setIsno(Integer isno) {
		this.isno = isno;
	}

}