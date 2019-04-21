package com.tsinghuait.st0717.hospitalsystem.dto;

import java.util.Date;
public class StayInHp  implements java.io.Serializable {
     private Integer id;
     private Integer patientId;
     private Integer bedId;
     private Date startTime;
     private Date endTime;
     private Integer days;
     public StayInHp(){
    	 
     }
    public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	/** minimal constructor */
    public StayInHp(Integer id) {
        this.id = id;
    } 
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return this.patientId;
    }
    
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getBedId() {
        return this.bedId;
    }
    
    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
   








}