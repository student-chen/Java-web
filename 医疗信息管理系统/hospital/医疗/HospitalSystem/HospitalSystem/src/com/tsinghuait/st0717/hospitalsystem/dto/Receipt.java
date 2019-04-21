package com.tsinghuait.st0717.hospitalsystem.dto;

import java.util.Date;

public class Receipt  implements java.io.Serializable {
     private Integer id;//收据ID
     private String items;//项目
     private Float pay;//金额
     private String payee;//收款人
     private Integer payeeId;//收款人ID
     private Date pdate;//日期
     private int isFinished;//是否收讫
    public Receipt() {
    }

    public Receipt(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getItems() {
        return this.items;
    }
    
    public void setItems(String items) {
        this.items = items;
    }

    public Float getPay() {
        return this.pay;
    }
    
    public void setPay(Float pay) {
        this.pay = pay;
    }

    public String getPayee() {
        return this.payee;
    }
    
    public void setPayee(String payee) {
        this.payee = payee;
    }

    public Integer getPayeeId() {
        return this.payeeId;
    }
    
    public void setPayeeId(Integer payeeId) {
        this.payeeId = payeeId;
    }

    public Date getPdate() {
        return this.pdate;
    }
    
    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public int getIsFinished() {
        return this.isFinished;
    }
    
    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }
}