package com.base.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.base.dao.BaseDao;
import com.base.dao.Pager;

@Repository("baseDao")
@SuppressWarnings("unchecked")
public class BaseDaoImpl implements BaseDao {
	@Resource
	private SessionFactory sessionFactory;
	private Session session;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public <T> T findObject(String hql) {
		// TODO Auto-generated method stub
		List<T> list = findList(hql);
		return (null == list || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public <T> T findObject(String hql, Object... objects) {
		// TODO Auto-generated method stub
		List<T> list = findList(hql, objects);
		return (null == list || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public <T> T getObject(Class<T> entity, Serializable id) {
		// TODO Auto-generated method stub
		session = this.getSession();
		return (T) session.get(entity, id);
	}

	@Override
	public <T> T findObjectBySql(String sql) {
		// TODO Auto-generated method stub
		List<T> list = findListBySql(sql);
		return (null == list || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public <T> T findObjectBySql(String sql, Object... objects) {
		// TODO Auto-generated method stub
		List<T> list = findListBySql(sql, objects);
		return (null == list || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public <T> List<T> findList(String hql) {
		// TODO Auto-generated method stub
		session = this.getSession();
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public <T> List<T> findList(String hql, Object... objects) {
		// TODO Auto-generated method stub
		session = this.getSession();
		Query query = session.createQuery(hql);
		setParameter(query, objects);
		return query.list();
	}

	@Override
	public <T> List<T> findList(Class<T> entity) {
		// TODO Auto-generated method stub
		String hql = "from " + entity.getName();
		return findList(hql);
	}

	@Override
	public <T> List<T> findListBySql(String sql) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}

	@Override
	public <T> List<T> findListBySql(String sql, Object... objects) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(sql);
		setParameter(query, objects);
		return query.list();
	}

	@Override
	public <T> void saveObject(T entity) {
		// TODO Auto-generated method stub
		getSession().save(entity);
	}

	@Override
	public <T> void updateObject(T entity) {
		// TODO Auto-generated method stub
		getSession().update(entity);
	}

	@Override
	public <T> void saveOrUpdateObject(T entity) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(entity);
	}

	@Override
	public int executeSql(String sql) {
		// TODO Auto-generated method stub
		session = this.getSession();
		Query query = session.createQuery(sql);
		return query.executeUpdate();
	}

	@Override
	public int executeSql(String sql, Object... objects) {
		// TODO Auto-generated method stub
		session = this.getSession();
		Query query = session.createQuery(sql);
		setParameter(query, objects);
		return query.executeUpdate();
	}

	@Override
	public int coutObjects(String hql) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		ScrollableResults sr = query.scroll();
		sr.last();
		return sr.getRowNumber() == -1 ? 0 : sr.getRowNumber() + 1;
	}

	@Override
	public int countObjects(String hql, Object... objects) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		setParameter(query, objects);
		ScrollableResults sr = query.scroll();
		sr.last();
		return sr.getRowNumber() == -1 ? 0 : sr.getRowNumber() + 1;
	}

	@Override
	public <T> Pager<T> findPager(String hql, int page, int rows) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		return this.findPager(query, page, rows);
	}

	@Override
	public <T> Pager<T> findPager(String hql, int page, int rows, Object... objects) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		setParameter(query, objects);
		return this.findPager(query, page, rows);
	}

	<T> Pager<T> findPager(Query query, int page, int rows) {
		ScrollableResults sr = query.scroll();
		sr.last();
		int count = sr.getRowNumber() == -1 ? 0 : sr.getRowNumber() + 1;
		Long cLong = new Long(count);
		query.setFirstResult((page - 1) * rows);
		query.setMaxResults(page * rows);
		return new Pager<T>(cLong, page, rows, query.list());
	}

	@Override
	public void delete(String hql) {
		// TODO Auto-generated method stub
		session = this.getSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public <T> void delete(Object entity) {
		// TODO Auto-generated method stub
		this.getSession().delete(entity);
	}

	@Override
	public void delete(String hql, Object... objects) {
		// TODO Auto-generated method stub
		session = this.getSession();
		Query query = session.createQuery(hql);
		setParameter(query, objects);
		query.executeUpdate();
	}

	void setParameter(Query query, Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
	}

}
