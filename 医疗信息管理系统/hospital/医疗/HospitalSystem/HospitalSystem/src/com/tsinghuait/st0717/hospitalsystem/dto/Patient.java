package com.tsinghuait.st0717.hospitalsystem.dto;
public class Patient  implements java.io.Serializable {
     private Integer oid;
     private String patientNo;
     private String name;
     private String sex;
     private String address;
     private Integer age;
     private int isfinished;
     private Integer mcId;
     private String mcName;
    /** default constructor */
    public Patient() {
    }

	/** minimal constructor */
    public Patient(Integer oid) {
        this.oid = oid;
    }
    
    /** full constructor */
    public Patient(Integer oid, String patientNo, String name, String sex, String address, Integer age, int isfinished, Integer mcId, String mcName) {
        this.oid = oid;
        this.patientNo = patientNo;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.age = age;
        this.isfinished = isfinished;
        this.mcId = mcId;
        this.mcName = mcName;
    }
    public Integer getOid() {
        return this.oid;
    }
    
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getPatientNo() {
        return this.patientNo;
    }
    
    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    public int getIsfinished() {
        return this.isfinished;
    }
    
    public void setIsfinished(int isfinished) {
        this.isfinished = isfinished;
    }

    public Integer getMcId() {
        return this.mcId;
    }
    
    public void setMcId(Integer mcId) {
        this.mcId = mcId;
    }

    public String getMcName() {
        return this.mcName;
    }
    
    public void setMcName(String mcName) {
        this.mcName = mcName;
    }
   








}