package com.table.records.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.records.entity.Records;
import com.table.records.service.RecordsService;
import com.table.user.entity.User;
import com.table.user.service.UserService;
import com.table.web.entity.Web;
import com.table.web.service.WebService;

@Service("recordsService")
public class RecordsServiceImpl extends BaseService implements RecordsService {
	@Autowired
	WebService webService;
	
	@Autowired
	UserService userService;
	
	@Override
	public Records getRecords(Integer id) {
		// TODO Auto-generated method stub
		return dao.getObject(Records.class, id);
	}

	@Override
	public List<Records> getAllRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Records records) {
		// TODO Auto-generated method stub
		if (null==records.getId()) {
			dao.saveObject(records);
		}
		else {
			dao.updateObject(records);
		}
	}

	@Override
	public boolean deleteRecords(Integer id) {
		// TODO Auto-generated method stub
		Records records = this.getRecords(id);
		dao.delete(records);
		return true;
	}

	@Override
	public Pager<Records> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql="from Records";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}
	
	public String getWeb(String userName,String title){
		Web web = webService.getWebByName(title); 
		User user = userService.getUserByName(userName);
		String hql="from Records where userId=? and webId = ?";
		Records  records = dao.findObject(hql, user.getId(),web.getId());
		if(null!=records)
		return title;
		return null;
	}
}
