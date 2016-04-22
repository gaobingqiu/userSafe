package web.personal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.table.user.entity.User;
import com.table.user.service.UserService;

public class PersonalController {
	@Autowired
	private UserService UserService;
	
	@RequestMapping("/update")
	public boolean update(HttpServletRequest request,User user) {
		UserService.saveOrUpdate(user);
		return true;
	}
	
	@RequestMapping("/delete")
	public boolean delete(HttpServletRequest request,Integer id) {
		UserService.disable(id);
		return true;
	}
}
