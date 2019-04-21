package com.tsinghuait.st0717.hospitalsystem.dto;
public class OperatingRoom  implements java.io.Serializable {
     private Integer id;
     private String orNo;
     private String type;
     private String address;
     private String info;
     private String nurseList;
     private int isUseable;
    public int getIsUseable() {
		return isUseable;
	}
	public void setIsUseable(int isUseable) {
		this.isUseable = isUseable;
	}
	public OperatingRoom() {
    }
    public OperatingRoom(Integer id) {
        this.id = id;
    }
    public OperatingRoom(Integer id, String orNo, String type, String address, String info, String nurseList) {
        this.id = id;
        this.orNo = orNo;
        this.type = type;
        this.address = address;
        this.info = info;
        this.nurseList = nurseList;
    }
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrNo() {
        return this.orNo;
    }
    
    public void setOrNo(String orNo) {
        this.orNo = orNo;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }

    public String getNurseList() {
        return this.nurseList;
    }
    
    public void setNurseList(String nurseList) {
        this.nurseList = nurseList;
    }
   








}