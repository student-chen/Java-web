package cn.dinner.entity;

/**
 * MemberType entity. @author MyEclipse Persistence Tools
 */

public class MemberType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typeName;

	// Constructors

	/** default constructor */
	public MemberType() {
	}

	/** full constructor */
	public MemberType(String typeName) {
		this.typeName = typeName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}