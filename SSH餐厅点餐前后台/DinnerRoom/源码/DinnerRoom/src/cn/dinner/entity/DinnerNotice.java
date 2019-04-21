package cn.dinner.entity;

/**
 * DinnerNotice entity. @author MyEclipse Persistence Tools
 */

public class DinnerNotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private String menuName;
	private Integer orderId;
	private Integer menunum;
	private String remark;
	private Integer menuPrice;

	// Constructors

	/** default constructor */
	public DinnerNotice() {
	}


	// Property accessors
	

	public Integer getId() {
		return this.id;
	}

	public DinnerNotice(String menuName, Integer orderId, Integer menunum,
			String remark, Integer menuPrice) {
		//super();
		this.menuName = menuName;
		this.orderId = orderId;
		this.menunum = menunum;
		this.remark = remark;
		this.menuPrice = menuPrice;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getOrderId() {
		return this.orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMenunum() {
		return this.menunum;
	}

	public void setMenunum(Integer menunum) {
		this.menunum = menunum;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(Integer menuPrice) {
		this.menuPrice = menuPrice;
	}

}