package com.tsinghuait.st0717.hospitalsystem.dto;

import java.util.Date;
public class Doctor  implements java.io.Serializable{
     private Integer id;
     private String staffNo;
     private String name;
     private Integer postid;
     private String post;
     private String sex;
     private Date birthday;
     private String info;
     private Integer mcId;
     private String mcName;
     private String loginName;
     private String loginPassword;
     private int isActive;
    /** default constructor */
    public Doctor() {
    }

	/** minimal constructor */
    public Doctor(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Doctor(Integer id, String staffNo, String name, Integer postid, String post, String sex, Date birthday, String info, Integer mcId, String mcName, String loginName, String loginPassword, int isActive) {
        this.id = id;
        this.staffNo = staffNo;
        this.name = name;
        this.postid = postid;
        this.post = post;
        this.sex = sex;
        this.birthday = birthday;
        this.info = info;
        this.mcId = mcId;
        this.mcName = mcName;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.isActive = isActive;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffNo() {
        return this.staffNo;
    }
    
    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostid() {
        return this.postid;
    }
    
    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getPost() {
        return this.post;
    }
    
    public void setPost(String post) {
        this.post = post;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
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

    public String getLoginName() {
        return this.loginName;
    }
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }
    
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public int getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
   








}