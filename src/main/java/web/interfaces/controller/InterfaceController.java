package web.interfaces.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.BaseController;

import web.interfaces.service.InterfaceService;
import web.interfaces.vo.PassVo;
import web.interfaces.vo.RegisterVo;

@Controller 
@RequestMapping("interfaces")
public class InterfaceController extends BaseController{
	@Autowired
	private InterfaceService interfaceService;
	
	public PassVo quickPass(HttpServletRequest request,String verifyCode,String webName,String userName) {
		PassVo passVo = interfaceService.quickPass(request,verifyCode,webName,userName);
		return passVo;
	}

	public RegisterVo quickRegister(HttpServletRequest request,String verifyCode,String webName,String userName) {
		RegisterVo registerVo = interfaceService.quickRegister(request,verifyCode,webName,userName);
		return registerVo;
	}
}
