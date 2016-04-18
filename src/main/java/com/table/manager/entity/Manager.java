package com.table.manager.entity;

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
@Table(name = "manager")
public class  Manager implements Serializable {
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

    @Column(length = 25)
    private String name;

    @Column
    private int type;
    
    @Column(name="pass_count")
    private int passCount;
    
    @Column(length = 50)
    private String password;

    @Column(name="last_pass_time",length = 50)
    private String lastPassTime;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPassCount() {
		return passCount;
	}

	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastPassTime() {
		return lastPassTime;
	}

	public void setLastPassTime(String lastPassTime) {
		this.lastPassTime = lastPassTime;
	}

}
