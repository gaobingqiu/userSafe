package web.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.BaseController;
import com.table.user.entity.User;

import web.login.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(User user){
		loginService.register(user);
		return "success";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,String userName,String password){
		if(loginService.userLogin(request, userName, password))
		return "web/personal/index";
		return "404";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request){
		log.debug("转到登录页面!");
		return "web/login/login";
	}
	
	@RequestMapping("/toRegister")
	public String toRegister(HttpServletRequest request){
		return "web/login/register";
	}
}
