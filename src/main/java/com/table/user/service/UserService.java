package com.table.user.service;

import java.util.List;

import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.user.entity.User;

public interface UserService {
	public User getUser(Integer id) ;
	
	public List<User> getAllUser();
	
	public void saveOrUpdate(User user);
	
	public boolean deleteUser(Integer id);
	
	public Pager<User> getByPage(PageBean pageBean);
	
}
