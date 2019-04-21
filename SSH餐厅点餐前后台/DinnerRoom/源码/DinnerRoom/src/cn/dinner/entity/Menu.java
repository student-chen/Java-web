package cn.dinner.entity;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private Integer id;
	//private Integer typeId;
	private MenuType menuType;
	private String MName;
	private Integer MPrice;
	private String imagePath;
	private String remark;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	// Property accessors

	public Menu(MenuType menuType, String mName, Integer mPrice,
			String imagePath, String remark) {
		//super();
		this.menuType = menuType;
		this.MName = mName;
		this.MPrice = mPrice;
		this.imagePath = imagePath;
		this.remark = remark;
	}
	

	public Menu(Integer id, MenuType menuType, String mName, Integer mPrice,
			String imagePath, String remark) {
		//super();
		this.id = id;
		this.menuType = menuType;
		this.MName = mName;
		this.MPrice = mPrice;
		this.imagePath = imagePath;
		this.remark = remark;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}*/

	public String getMName() {
		return this.MName;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	public void setMName(String MName) {
		this.MName = MName;
	}

	public Integer getMPrice() {
		return this.MPrice;
	}

	public void setMPrice(Integer MPrice) {
		this.MPrice = MPrice;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}