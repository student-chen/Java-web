package com.bjpowernode.common.entity.base;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


/**
 * 
 * @author Administrator
 * 
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -145979597494506075L;

    /**
     * 主键标示
     */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(nullable=false,length=36)
	private String id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private  Date createTime  = new Date ();


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


}