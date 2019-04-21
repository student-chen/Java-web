package com.tsinghuait.st0717.hospitalsystem.dto;

import java.util.Date;

public class Stat {
    private String items;//项目
    private Float pay;//金额
    private String payee;//收款人
    private String name;//付款人
    private Date pdate;//日期
    private Byte isFinished;//是否收讫
	public Byte getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(Byte isFinished) {
		this.isFinished = isFinished;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPay() {
		return pay;
	}
	public void setPay(Float pay) {
		this.pay = pay;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
}
