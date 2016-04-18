package com.table.manager.service;

import java.util.List;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.manager.entity.Manager;

public interface ManagerService {
	public Manager getManager(Integer id) ;
	
	public List<Manager> getAllManager();
	
	public void saveOrUpdate(Manager manager);
	
	public boolean deleteManager(Integer id);
	
	public Pager<Manager> getByPage(PageBean pageBean);
	
}
