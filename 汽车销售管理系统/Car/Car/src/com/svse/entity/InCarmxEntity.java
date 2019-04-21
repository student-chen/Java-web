package com.svse.entity;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class InCarmxEntity implements Serializable {
	
	private int incarmxid;
	private int incarid;
	private int detailid;
	private int storeid;
	private int newstoreid;
	
	private String incarprice;
	private String outcarprice;
	private String carshouzi;
	private String carcjh;
	private String carhgz;
	
	private String carfdjh;
	private String carcolor;
	private String carimg;
	
	private String detailguige;
	private String detailname;
	private String carchanshu;
	private int carrukucount;
	private String carrukutime;
	private int pid;
	private int mid;
	private int carkucunflag;
	
	private String storename;
	private String zjmc;
	private String mname;
	private String mrealname;
	private String sortname;
	

	
	public String getMrealname() {
		return mrealname;
	}


	public void setMrealname(String mrealname) {
		this.mrealname = mrealname;
	}


	public String getSortname() {
		return sortname;
	}


	public void setSortname(String sortname) {
		this.sortname = sortname;
	}


	public String getDetailname() {
		return detailname;
	}


	public void setDetailname(String detailname) {
		this.detailname = detailname;
	}


	public String getStorename() {
		return storename;
	}


	public void setStorename(String storename) {
		this.storename = storename;
	}


	public String getZjmc() {
		return zjmc;
	}


	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	private String flag;
	
	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


	public String getDetailguige() {
		return detailguige;
	}


	public void setDetailguige(String detailguige) {
		this.detailguige = detailguige;
	}


	public int getCarrukucount() {
		return carrukucount;
	}


	public void setCarrukucount(int carrukucount) {
		this.carrukucount = carrukucount;
	}


	private CommonsMultipartFile img;


	public int getIncarmxid() {
		return incarmxid;
	}


	public void setIncarmxid(int incarmxid) {
		this.incarmxid = incarmxid;
	}


	public int getIncarid() {
		return incarid;
	}


	public void setIncarid(int incarid) {
		this.incarid = incarid;
	}


	public int getDetailid() {
		return detailid;
	}


	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}


	public int getStoreid() {
		return storeid;
	}


	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}


	public int getNewstoreid() {
		return newstoreid;
	}


	public void setNewstoreid(int newstoreid) {
		this.newstoreid = newstoreid;
	}


	public String getIncarprice() {
		return incarprice;
	}


	public void setIncarprice(String incarprice) {
		this.incarprice = incarprice;
	}


	public String getOutcarprice() {
		return outcarprice;
	}


	public void setOutcarprice(String outcarprice) {
		this.outcarprice = outcarprice;
	}


	public String getCarshouzi() {
		return carshouzi;
	}


	public void setCarshouzi(String carshouzi) {
		this.carshouzi = carshouzi;
	}


	public String getCarcjh() {
		return carcjh;
	}


	public void setCarcjh(String carcjh) {
		this.carcjh = carcjh;
	}


	public String getCarhgz() {
		return carhgz;
	}


	public void setCarhgz(String carhgz) {
		this.carhgz = carhgz;
	}


	public String getCarfdjh() {
		return carfdjh;
	}


	public void setCarfdjh(String carfdjh) {
		this.carfdjh = carfdjh;
	}


	public String getCarcolor() {
		return carcolor;
	}


	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}


	public String getCarimg() {
		return carimg;
	}


	public void setCarimg(String carimg) {
		this.carimg = carimg;
	}


	public String getCarchanshu() {
		return carchanshu;
	}


	public void setCarchanshu(String carchanshu) {
		this.carchanshu = carchanshu;
	}


	public String getCarrukutime() {
		return carrukutime;
	}


	public void setCarrukutime(String carrukutime) {
		this.carrukutime = carrukutime;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public int getMid() {
		return mid;
	}


	public void setMid(int mid) {
		this.mid = mid;
	}


	public int getCarkucunflag() {
		return carkucunflag;
	}


	public void setCarkucunflag(int carkucunflag) {
		this.carkucunflag = carkucunflag;
	}


	public CommonsMultipartFile getImg() {
		return img;
	}


	public void setImg(CommonsMultipartFile img) {
		this.img = img;
	}
	
	
	
	
}
