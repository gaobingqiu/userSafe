package com.table.manager.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.manager.entity.Manager;
import com.table.manager.service.ManagerService;

@Service("managerService")
public class ManagerServiceImpl extends BaseService implements ManagerService {
	public boolean login(HttpServletRequest request, String userName, String password){
		return true;
	}
	
	@Override
	public Manager getManager(Integer id) {
		// TODO Auto-generated method stub
		return dao.getObject(Manager.class, id);
	}

	@Override
	public List<Manager> getAllManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Manager manager) {
		// TODO Auto-generated method stub
		if (null==manager.getId()) {
			dao.saveObject(manager);
		}
		else {
			dao.updateObject(manager);
		}
	}

	@Override
	public boolean deleteManager(Integer id) {
		// TODO Auto-generated method stub
		Manager manager = this.getManager(id);
		dao.delete(manager);
		return true;
	}

	@Override
	public Pager<Manager> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql="from Manager";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}

}
