package com.tsinghuait.st0717.hospitalsystem.dto;
import java.util.Date;
public class Operation  implements java.io.Serializable {
    // Fields    
     private Integer id;
     private String type;
     private Date date;
     private Float pay;
     private Integer operatingRoomId;
     private Integer patenitId;
     private Integer pkDoctorId;
     private Integer extDoctorId;
     private Byte isFinish;
    // Constructors

    /** default constructor */
    public Operation() {
    }

	/** minimal constructor */
    public Operation(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Operation(Integer id, String type, Date date, Float pay, Integer operatingRoomId, Integer patenitId, Integer pkDoctorId, Integer extDoctorId, Byte isFinish) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.pay = pay;
        this.operatingRoomId = operatingRoomId;
        this.patenitId = patenitId;
        this.pkDoctorId = pkDoctorId;
        this.extDoctorId = extDoctorId;
        this.isFinish = isFinish;
    }
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public Float getPay() {
        return this.pay;
    }
    
    public void setPay(Float pay) {
        this.pay = pay;
    }

    public Integer getOperatingRoomId() {
        return this.operatingRoomId;
    }
    
    public void setOperatingRoomId(Integer operatingRoomId) {
        this.operatingRoomId = operatingRoomId;
    }

    public Integer getPatenitId() {
        return this.patenitId;
    }
    
    public void setPatenitId(Integer patenitId) {
        this.patenitId = patenitId;
    }

    public Integer getPkDoctorId() {
        return this.pkDoctorId;
    }
    
    public void setPkDoctorId(Integer pkDoctorId) {
        this.pkDoctorId = pkDoctorId;
    }

    public Integer getExtDoctorId() {
        return this.extDoctorId;
    }
    
    public void setExtDoctorId(Integer extDoctorId) {
        this.extDoctorId = extDoctorId;
    }

    public Byte getIsFinish() {
        return this.isFinish;
    }
    
    public void setIsFinish(Byte isFinish) {
        this.isFinish = isFinish;
    }
   








}