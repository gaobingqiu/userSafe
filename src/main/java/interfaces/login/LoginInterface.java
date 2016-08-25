package interfaces.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import web.index.service.IndexService;
import web.login.service.LoginService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.base.BaseController;
import com.table.user.entity.User;
import com.table.user.service.UserService;

@Controller
@RequestMapping("/loginInterface")
public class LoginInterface extends BaseController{
	@Autowired
	private LoginService loginService;
	@Autowired
	private IndexService indexService;
	@Autowired 
	private UserService userService;
	private String phoneMac;

	@RequestMapping("/login")
	@ResponseBody
	public void login(HttpServletRequest request, HttpServletResponse response, String password, String userName,String token)
			throws ServletException, IOException {
		User user = loginService.userLogin(request, userName, password,token);
		JSONObject json = (JSONObject) JSON.toJSON(user);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="/reset",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String reset(HttpServletRequest request, HttpServletResponse response, String password, String tel,String token)
			throws ServletException, IOException {
		User user = userService.getUserByPhone(tel);
		phoneMac = user.getMac();
		if(null==phoneMac||!phoneMac.equals(token)){
			return "你无权进行此操作！";
		}
		if(!loginService.resetPassword(user, password)){
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public String getUser(HttpServletRequest request, HttpServletResponse response, String userName,String token)
			throws ServletException, IOException {
		User user = userService.getUserByName(userName);
		JSONObject json = (JSONObject) JSON.toJSON(user);
		HttpSession session = request.getSession();
		session.setAttribute("mac", token);
		session.setAttribute("userId", user.getId());
		session.setMaxInactiveInterval(30 * 60);
		return json.toJSONString();
	}
	
	@RequestMapping("/getCode")
	@ResponseBody
	public void getCode(HttpServletRequest request, HttpServletResponse response, String password, String userName,String token)
			throws ServletException, IOException {
		User user = loginService.userLogin(request, userName, password,token);
		JSONObject json = (JSONObject) JSON.toJSON(user);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(HttpServletRequest request, HttpServletResponse response, String userName, String tel,String password, Integer code)
			throws Exception {
		if(null == code){
			return "404";
		}
		if (!indexService.checkCodeByTel(tel, code)) {
			return "404";
		}
		if (loginService.register(userName,tel, password)) {
			return userName;
		}
		return "404";
	}

}
