package com.hibernate.model;

import java.sql.Date;


/**
 * DocuStuRegister generated by MyEclipse - Hibernate Tools
 */

public class DocuStuRegister  implements java.io.Serializable {
    // Fields    

     private String lsh;
     private SystemClassInfo systemClassInfo;
     private DocuStuInfo docuStuInfo;
     private Date djrq;
     private String jbr;
     private double lqfs;
     private String zymc;


    // Constructors

    /** default constructor */
    public DocuStuRegister() {
    }

	/** minimal constructor */
    public DocuStuRegister(String lsh) {
        this.lsh = lsh;
    }
    
    /** full constructor */
    public DocuStuRegister(String lsh, SystemClassInfo systemClassInfo, DocuStuInfo docuStuInfo, Date djrq, String jbr, double lqfs, String zymc) {
        this.lsh = lsh;
        this.systemClassInfo = systemClassInfo;
        this.docuStuInfo = docuStuInfo;
        this.djrq = djrq;
        this.jbr = jbr;
        this.lqfs = lqfs;
        this.zymc = zymc;
    }

   
    // Property accessors

    public String getLsh() {
        return this.lsh;
    }
    
    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    public SystemClassInfo getSystemClassInfo() {
        return this.systemClassInfo;
    }
    
    public void setSystemClassInfo(SystemClassInfo systemClassInfo) {
        this.systemClassInfo = systemClassInfo;
    }

    public DocuStuInfo getDocuStuInfo() {
        return this.docuStuInfo;
    }
    
    public void setDocuStuInfo(DocuStuInfo docuStuInfo) {
        this.docuStuInfo = docuStuInfo;
    }

    public Date getDjrq() {
        return this.djrq;
    }
    
    public void setDjrq(Date djrq) {
        this.djrq = djrq;
    }

    public String getJbr() {
        return this.jbr;
    }
    
    public void setJbr(String jbr) {
        this.jbr = jbr;
    }

    public double getLqfs() {
        return this.lqfs;
    }
    
    public void setLqfs(double lqfs) {
        this.lqfs = lqfs;
    }

    public String getZymc() {
        return this.zymc;
    }
    
    public void setZymc(String zymc) {
        this.zymc = zymc;
    }
   








}