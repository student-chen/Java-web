package cn.dinner.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.service.DinnerOrderservice;


public class HomeAction {
	@Autowired
	private DinnerOrderservice dinnerOrderservice;
	private Double yesterdaySr;
	private Double todaySr;
	private Integer yesterdayJdNum;
	private Integer toddayJdNum;
	private Integer yesterdayorderNum;
	private Integer toddayorderNum;
	private Integer rll1;
	private Integer rll2;
	private Integer rll3;
	private Integer rll4;
	public String homeInfo(){
		String[] info = dinnerOrderservice.homeInfo().split(",");
		yesterdaySr = Double.valueOf(info[0]);
		yesterdayJdNum = Integer.parseInt(info[1]);
		yesterdayorderNum = Integer.parseInt(info[2]);
		todaySr = Double.valueOf(info[3]);
		toddayJdNum = Integer.parseInt(info[4]);
		toddayorderNum = Integer.parseInt(info[5]);
		rll1 = Integer.parseInt(info[6]);
		rll2 = Integer.parseInt(info[7]);
		rll3 = Integer.parseInt(info[8]);
		rll4 = Integer.parseInt(info[9]);
		if(toddayJdNum!=0){
			rll1 = Integer.parseInt(info[6])/toddayJdNum;
			rll2 = Integer.parseInt(info[7])/toddayJdNum;
			rll3 = Integer.parseInt(info[8])/toddayJdNum;
			rll4 = Integer.parseInt(info[9])/toddayJdNum;
		}
		return "sucess";
	}
	public Double getYesterdaySr() {
		return yesterdaySr;
	}
	public void setYesterdaySr(Double yesterdaySr) {
		this.yesterdaySr = yesterdaySr;
	}
	public Double getTodaySr() {
		return todaySr;
	}
	public void setTodaySr(Double todaySr) {
		this.todaySr = todaySr;
	}
	public Integer getYesterdayJdNum() {
		return yesterdayJdNum;
	}
	public void setYesterdayJdNum(Integer yesterdayJdNum) {
		this.yesterdayJdNum = yesterdayJdNum;
	}
	public Integer getToddayJdNum() {
		return toddayJdNum;
	}
	public void setToddayJdNum(Integer toddayJdNum) {
		this.toddayJdNum = toddayJdNum;
	}
	public Integer getYesterdayorderNum() {
		return yesterdayorderNum;
	}
	public void setYesterdayorderNum(Integer yesterdayorderNum) {
		this.yesterdayorderNum = yesterdayorderNum;
	}
	public Integer getToddayorderNum() {
		return toddayorderNum;
	}
	public void setToddayorderNum(Integer toddayorderNum) {
		this.toddayorderNum = toddayorderNum;
	}
	public Integer getRll1() {
		return rll1;
	}
	public void setRll1(Integer rll1) {
		this.rll1 = rll1;
	}
	public Integer getRll2() {
		return rll2;
	}
	public void setRll2(Integer rll2) {
		this.rll2 = rll2;
	}
	public Integer getRll3() {
		return rll3;
	}
	public void setRll3(Integer rll3) {
		this.rll3 = rll3;
	}
	public Integer getRll4() {
		return rll4;
	}
	public void setRll4(Integer rll4) {
		this.rll4 = rll4;
	}
	
}
