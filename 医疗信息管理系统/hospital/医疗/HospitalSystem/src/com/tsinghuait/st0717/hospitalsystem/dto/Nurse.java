package com.tsinghuait.st0717.hospitalsystem.dto;
public class Nurse  implements java.io.Serializable{
     private Integer id;
     private String staffNo;
     private String name;
     private String sex;
     private Integer postid;
     private String post;
     private String loginName;
     private String loginPassword;
    public Nurse() {
    }
    public Nurse(Integer id) {
        this.id = id;
    }
    public Nurse(Integer id, String staffNo, String name, String sex, Integer postid, String post, String loginName, String loginPassword) {
        this.id = id;
        this.staffNo = staffNo;
        this.name = name;
        this.sex = sex;
        this.postid = postid;
        this.post = post;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }
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

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
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
   








}