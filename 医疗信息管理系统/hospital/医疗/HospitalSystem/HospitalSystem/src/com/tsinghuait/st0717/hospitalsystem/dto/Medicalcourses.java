package com.tsinghuait.st0717.hospitalsystem.dto;
public class Medicalcourses  implements java.io.Serializable{
     private Integer id;
     private String name;
     private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
    public Medicalcourses() {
    }
    public Medicalcourses(Integer id) {
        this.id = id;
    }
    public Medicalcourses(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   








}