package com.table.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.manager.entity.Manager;
import com.table.manager.service.ManagerService;

@Service("managerService")
public class ManagerServiceImpl extends BaseService implements ManagerService {
	public boolean login(HttpServletRequest request, String userName, String password) {
		Manager manager = this.getManagerByName(userName);
		if (manager.getPassword().endsWith(password)) {
			String currentTime = this.refFormatNowDate();
			manager.setLastPassTime(currentTime);
			manager.setPassCount(manager.getPassCount() + 1);
			this.saveOrUpdate(manager);
			HttpSession session = request.getSession(); 
			session.setAttribute("managerName", manager.getName()); 
			return true;
		}
		return false;
	}

	private Manager getManagerByName(String userName) {
		// TODO Auto-generated method stub
		String hql = "from Manager where name=?";
		return dao.findObject(hql, userName);
	}

	@Override
	public Manager getManager(String id) {
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
		if (null == manager.getId()||manager.getId().length()==0) {
			dao.saveObject(manager);
		} else {
			dao.updateObject(manager);
		}
	}

	@Override
	public boolean deleteManager(String id) {
		// TODO Auto-generated method stub
		Manager manager = this.getManager(id);
		dao.delete(manager);
		return true;
	}

	@Override
	public Pager<Manager> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql = "from Manager";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}

	public String refFormatNowDate() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		return retStrFormatNowDate;
	}

}
