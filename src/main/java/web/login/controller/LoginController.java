package web.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.BaseController;
import com.table.user.entity.User;
import com.table.user.service.UserService;

import web.index.service.IndexService;
import web.login.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private IndexService indexService;
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, String userName, String password, Model model) {
		User user = loginService.userLogin(request, userName, password);
		if(!indexService.limitAble(request, 1)){
			return "400";
		}
		if (null!=user) {
			model.addAttribute("image", user.getImage());
			model.addAttribute("tel", user.getTel());
			model.addAttribute("email", user.getEmail());
			model.addAttribute("idNum", user.getIdNum());
			return "web/personal/personal";
		}
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
	public String register(HttpServletRequest request, String userName, String password, Integer code)
			throws Exception {
		if (!indexService.checkCode(request,code)) {
			return "404";
		}
		if (loginService.register(userName, password)) {
			return "web/login/showResult";
		}
		return "404";
	}

	@RequestMapping("/toReset")
	public String toReset(HttpServletRequest request) {
		return "web/login/reset";
	}
	
	@RequestMapping("/resetTel")
	@ResponseBody
	public String resetTel(HttpServletRequest request, String phone, Integer code,String password) {
		User user = userService.getUserByPhone(phone);
		if (!indexService.resetCode(user.getId(), code)) {
			return "error";
		} else {
			user.setPassword(password);
			userService.saveOrUpdate(user);
			return "success";
		}

	}
	
	@RequestMapping("/toResetEmail")
	public String toResetEmail(HttpServletRequest request) {
		return "web/login/ResetEmail";
	}
	
	@RequestMapping("/resetEmail")
	@ResponseBody
	public String resetEmail(HttpServletRequest request, String email, Integer code,String password) {
		User user = userService.getUserByEmail(email);
		if (!indexService.resetCode(user.getId(), code)) {
			return "error";
		} else {
			user.setPassword(password);
			userService.saveOrUpdate(user);
			return "success";
		}
	}
}
