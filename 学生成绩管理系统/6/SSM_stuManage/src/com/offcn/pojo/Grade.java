package com.offcn.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Grade {
    private Integer id;

    private Integer sid;

    private Integer cid;

    private Integer tid;

    @NotNull
    @Min(value=0,message="成绩最小值为{value}")    //最小值
    @Max(value=30,message="成绩最大值为{value}")    //最大值
    private Double pgrade;

    @NotNull
    @Min(value=0,message="成绩最小值为{value}")    //最小值
    @Max(value=70,message="成绩最大值为{value}")    //最大值
    private Double kgrade;

    private Double zgrade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Double getPgrade() {
        return pgrade;
    }

    public void setPgrade(Double pgrade) {
        this.pgrade = pgrade;
    }

    public Double getKgrade() {
        return kgrade;
    }

    public void setKgrade(Double kgrade) {
        this.kgrade = kgrade;
    }

    public Double getZgrade() {
        return zgrade;
    }

    public void setZgrade(Double zgrade) {
        this.zgrade = zgrade;
    }
}