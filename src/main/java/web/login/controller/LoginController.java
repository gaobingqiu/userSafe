package web.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.BaseController;

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
	public String login(HttpServletRequest request, String userName, String password, Model model) {
		HttpSession session = request.getSession();
		if (loginService.userLogin(request, userName, password)) {
			model.addAttribute("userId", session.getAttribute("userId"));
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
		if (!indexService.checkCode(code)) {
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
}
