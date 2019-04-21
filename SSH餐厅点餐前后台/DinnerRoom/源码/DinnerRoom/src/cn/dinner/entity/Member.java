package cn.dinner.entity;

/**
 * Member entity. @author MyEclipse Persistence Tools
 */

public class Member implements java.io.Serializable {

	// Fields

	private Integer id;
	//private Integer typeId;
	private MemberType memberType;
	private String name;
	private String phone;
	private Integer mcode;

	// Constructors

	/** default constructor */
	public Member() {
	}


	// Property accessors

	public Member(Integer id, MemberType memberType, String name, String phone,
			Integer mcode) {
		//super();
		this.id = id;
		this.memberType = memberType;
		this.name = name;
		this.phone = phone;
		this.mcode = mcode;
	}
	public Member(MemberType memberType, String name, String phone,
			Integer mcode) {
		//super();
		this.memberType = memberType;
		this.name = name;
		this.phone = phone;
		this.mcode = mcode;
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
	public String getName() {
		return this.name;
	}

	public MemberType getMemberType() {
		return memberType;
	}


	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Integer getMcode() {
		return mcode;
	}


	public void setMcode(Integer mcode) {
		this.mcode = mcode;
	}

}