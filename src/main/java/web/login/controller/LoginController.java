package web.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.BaseController;
import com.table.user.entity.User;

import web.index.service.IndexService;
import web.login.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private IndexService indexService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, String userName, String password) {
		if (loginService.userLogin(request, userName, password))
			return "web/personal/personal";
		return "404";
	}

	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request) {
		log.debug("转到登录页面!");
		return "web/login/login";
	}

	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request) {
		if (loginService.loginOut(request)) {
			log.debug("退出登录");
			return "web/login/loginOut";
		}
		return "404";
	}

	@RequestMapping("/toRegister")
	public String toRegister(HttpServletRequest request) {
		return "web/login/register";
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request,String userName, String password,Integer code) {
		if(!indexService.checkCode(code)){
			return "404";
		}
		User user = new User();
		user.setPassword(password);
		user.setUserName(userName);
		if (loginService.register(user)) {
			return "web/login/showResult";
		}
		return "404";
	}
	
	@RequestMapping("/toReset")
	public String toReset(HttpServletRequest request) {
		return "web/login/reset";
	}
}
