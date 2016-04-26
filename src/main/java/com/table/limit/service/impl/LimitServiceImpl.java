package com.table.limit.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.limit.entity.Limit;
import com.table.limit.entity.PassType;
import com.table.limit.service.LimitService;

/**
 * 错误次数限制
 * @author gbq
 * 2016年4月24日
 */
@Service("limitService")
public class LimitServiceImpl extends BaseService implements LimitService {

	@Override
	public Limit getLimit(Integer id) {
		// TODO Auto-generated method stub
		return dao.getObject(Limit.class, id);
	}

	@Override
	public List<Limit> getAllLimit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Limit limit) {
		// TODO Auto-generated method stub
		if (null == limit.getId()) {
			dao.saveObject(limit);
		} else {
			dao.updateObject(limit);
		}
	}

	@Override
	public boolean deleteLimit(Integer id) {
		// TODO Auto-generated method stub
		Limit limit = this.getLimit(id);
		dao.delete(limit);
		return true;
	}

	@Override
	public Pager<Limit> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql = "from Limit";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}

	@Override
	public int PassLimit(String userId, Integer type) {
		int currentCount = this.getCurrentCount(userId, type);
		int maxCount = PassType.getCount(type);
		String hql = "from Limit where userId=? and type=?";
		Limit limit = dao.findObject(hql, userId, type);
		Long time = System.currentTimeMillis();
		if (currentCount >= maxCount) {
			if (time >= Integer.parseInt(limit.getEnableTime())) {
				this.reSet(userId, type);
				return 1;
			} else {
				this.disable(userId, type);
				return 0;
			}
		}
		return 0;
	}

	public void reSet(String userId, Integer type) {
		String hql = "from Limit where userId=? and type=?";
		Limit limit = dao.findObject(hql, userId, type);
		limit.setEnableTime(""+0);
		limit.setEnable(1);
		this.saveOrUpdate(limit);
	}

	public void disable(String userId, Integer type) {
		String hql = "from Limit where userId=? and type=?";
		Limit limit = dao.findObject(hql, userId, type);
		Long time = System.currentTimeMillis();
		Long adds = PassType.getTime(type) * 60 + time;
		limit.setEnableTime("" + adds);
		limit.setEnable(0);
		this.saveOrUpdate(limit);
	}

	@Override
	public int getCurrentCount(String userId, Integer type) {
		String hql = "from Limit where userId=? and type=?";
		int count = dao.countObjects(hql, userId, type);
		if (count == 0) {
			Long time = System.currentTimeMillis();
			Long adds = PassType.getTime(type) * 60 + time;
			Limit limit = new Limit();
			limit.setCurrentCount(0);
			limit.setEnable(1);
			limit.setType(type);
			limit.setUserId(userId);
			limit.setEnableTime("" + adds);
			this.saveOrUpdate(limit);
			return 1;
		} else {
			this.countAdd(userId, type);
			return ++count;
		}
	}

	@Override
	public int countAdd(String userId, Integer type) {
		try {
			String hql = "from Limit where userId=? and type=?";
			Limit limit = dao.findObject(hql, userId, type);
			limit.setCurrentCount(limit.getCurrentCount() + 1);
			dao.updateObject(limit);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
}
