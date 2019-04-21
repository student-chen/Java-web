package com.tsinghuait.st0717.hospitalsystem.dto;

public class ViewNursePostDTO {
	/**
	 * 对护士\部门的视图 
	 */
	private int id;
	private String workNum;
	private String name;
	private String sex;
	private String postName;
	private String loginName;
	private String loginPassword;
	private String pName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPName() {
		return pName;
	}
	public void setPName(String name) {
		pName = name;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getWorkNum() {
		return workNum;
	}
	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}

}
