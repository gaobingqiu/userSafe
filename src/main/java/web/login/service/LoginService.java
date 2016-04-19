package web.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.table.user.entity.User;
import com.table.user.service.UserService;

/**
 * 用户登录模块功能类
 * @author gbq
 * 2016年4月19日
 */
@Service
public class LoginService {
	@Autowired 
	private UserService userService;
	
	/**
	 * 登录验证
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 * @author gbq
	 * 2016年4月19日
	 */
	public boolean userLogin(HttpServletRequest request,String userName,String password){
		User user = userService.getUserByName(userName);
		if (user.getPassword().equals(password)) {
			HttpSession session=request.getSession();
			session.setAttribute("userId", user.getId());
			return true;
		}
		return false;
	}
	
	public String register(User user) {
		try {
			userService.saveOrUpdate(user);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	}
}
