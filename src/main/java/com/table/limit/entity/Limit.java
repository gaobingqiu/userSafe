package com.table.limit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 此实体的定义应用了springmvc的注解，省去了传统的Hibernate跟数据库之间的映射配置文件
 * @author gbq
 */
@Entity
@Table(name = "limit")
public class Limit implements Serializable {
    /**
     * 2016年3月3日
     */
    private static final long serialVersionUID = 1L;

    //指定主键
    @Id  
    //主键自动增长型
    @GeneratedValue 
    @Column(name="Id",length = 11)
    private Integer id;

    @Column(name="user_id",length = 50)
    private String userId;

    @Column
    private int type;
    
    @Column(name="current_count")
    private int currentCount;
    
    @Column(name="pass_count")
    private int passCount;
    
    @Column(name="enable")
    private int enable;
    
    @Column(name="current_time",length = 50)
    private String currentTime;

    @Column(name="enable_time",length = 50)
    private String enableTime;
    
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getPassCount() {
		return passCount;
	}

	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getEnableTime() {
		return enableTime;
	}

	public void setEnableTime(String enableTime) {
		this.enableTime = enableTime;
	}

}
