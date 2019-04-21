package cn.dinner.entity;

/**
 * DinnerPc entity. @author MyEclipse Persistence Tools
 */

public class DinnerPc implements java.io.Serializable {

	// Fields

	private Integer id;
	//private Integer orderid;
	private DinnerOrder dinnerOrder;
	private Integer isok;

	// Constructors

	/** default constructor */
	public DinnerPc() {
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}*/

	public Integer getIsok() {
		return this.isok;
	}

	public DinnerOrder getDinnerOrder() {
		return dinnerOrder;
	}


	public void setDinnerOrder(DinnerOrder dinnerOrder) {
		this.dinnerOrder = dinnerOrder;
	}


	public void setIsok(Integer isok) {
		this.isok = isok;
	}

}