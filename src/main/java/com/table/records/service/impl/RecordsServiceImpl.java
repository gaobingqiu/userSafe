package com.table.records.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.records.entity.Records;
import com.table.records.service.RecordsService;

@Service("recordsService")
public class RecordsServiceImpl extends BaseService implements RecordsService {
	
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

}
