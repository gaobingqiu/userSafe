package com.table.limit.service;

import java.util.List;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.limit.entity.Limit;

public interface LimitService {
	public Limit getLimit(Integer id) ;
	
	public List<Limit> getAllLimit();
	
	public void saveOrUpdate(Limit manager);
	
	public boolean deleteLimit(Integer id);
	
	public Pager<Limit> getByPage(PageBean pageBean);
	
	public int getCurrentCount(String userId,Integer type);
	
	public int countAdd(String userId,Integer type);
	
	public int PassLimit(String userId,Integer type);
}
