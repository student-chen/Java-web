package cn.dinner.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DinnerOrder entity. @author MyEclipse Persistence Tools
 */

public class DinnerOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tableId;
	private Date ordertime;
	private String usercode;
	private Integer personnum;
	private Integer ispay;
	private Double price;
	private Integer isFull;
	
	// Constructors

	/** default constructor */
	public DinnerOrder() {
	}

	// Property accessors
	

	public Integer getId() {
		return this.id;
	}

	public DinnerOrder(String tableId, Date ordertime, String usercode,
			Integer personnum, Integer ispay, Double price, Integer isFull) {
		//super();
		this.tableId = tableId;
		this.ordertime = ordertime;
		this.usercode = usercode;
		this.personnum = personnum;
		this.ispay = ispay;
		this.price = price;
		this.isFull = isFull;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public Date getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Integer getPersonnum() {
		return this.personnum;
	}

	public void setPersonnum(Integer personnum) {
		this.personnum = personnum;
	}

	public Integer getIspay() {
		return this.ispay;
	}

	public void setIspay(Integer ispay) {
		this.ispay = ispay;
	}
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public Integer getIsFull() {
		return isFull;
	}

	public void setIsFull(Integer isFull) {
		this.isFull = isFull;
	}

}