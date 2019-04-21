package com.tsinghuait.st0717.hospitalsystem.dto;
public class Sickbed  implements java.io.Serializable {
     private SickbedId Id;
     private Integer id;
     private String bedNo;
     private String type;
     private int isUseable;
    public Sickbed() {
    }    
	public String getBedNo() {
		return bedNo;
	}
	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	public int getIsUseable() {
		return isUseable;
	}
	public void setIsUseable(int isUseable) {
		this.isUseable = isUseable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setId(SickbedId id) {
		Id = id;
	}
}