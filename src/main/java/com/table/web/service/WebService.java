package com.table.web.service;

import java.util.List;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.web.entity.Web;

public interface WebService {
	public Web getWeb(Integer id) ;
	
	public List<Web> getAllWeb();
	
	public void saveOrUpdate(Web web);
	
	public boolean deleteWeb(Integer id);
	
	public Pager<Web> getByPage(PageBean pageBean);
	
}
