package com.table.manager.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.manager.entity.Manager;

public interface ManagerService {
	public Manager getManager(String id) ;
	
	public List<Manager> getAllManager();
	
	public void saveOrUpdate(Manager manager);
	
	public boolean deleteManager(String id);
	
	public Pager<Manager> getByPage(PageBean pageBean);

	public boolean login(HttpServletRequest request, String userName, String password);
	
}
