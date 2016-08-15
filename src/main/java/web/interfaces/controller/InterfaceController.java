package web.interfaces.controller;

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

import web.interfaces.service.InterfaceService;
import web.interfaces.vo.PassVo;
import web.interfaces.vo.RegisterVo;

@Controller
@RequestMapping("/interfaces")
public class InterfaceController extends BaseController {
	@Autowired
	private InterfaceService interfaceService;

	@RequestMapping("/login")
	@ResponseBody
	public PassVo quickPass(HttpServletRequest request, String verifyCode, String webName, String userName) {
		PassVo passVo = interfaceService.quickPass(request, verifyCode, webName, userName);
		return passVo;
	}

	@RequestMapping("/register")
	@ResponseBody
	public void quickRegister(HttpServletRequest request, String verifyCode, String webName, String userName,
			HttpServletResponse response) throws ServletException, IOException {
		RegisterVo registerVo = interfaceService.quickRegister(request, verifyCode, webName, userName);
		JSONObject json = (JSONObject) JSON.toJSON(registerVo);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
}
