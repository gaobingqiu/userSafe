package interfaces.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.base.BaseController;
import com.table.user.entity.User;

import web.login.service.LoginService;

@Controller
@RequestMapping("/loginInterface")
public class LoginInterface extends BaseController{
	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	@ResponseBody
	public void login(HttpServletRequest request, HttpServletResponse response, String password, String userName)
			throws ServletException, IOException {
		User user = loginService.userLogin(request, userName, password);
		JSONObject json = (JSONObject) JSON.toJSON(user);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

}
