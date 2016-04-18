package com.table.records.service;

import java.util.List;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.records.entity.Records;

public interface RecordsService {
	public Records getRecords(Integer id) ;
	
	public List<Records> getAllRecords();
	
	public void saveOrUpdate(Records manager);
	
	public boolean deleteRecords(Integer id);
	
	public Pager<Records> getByPage(PageBean pageBean);
	
}
