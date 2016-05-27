package web.interfaces.controller;

import java.util.List;

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
	
	public List<PassVo> quickPass(HttpServletRequest request,String verifyCode,String url,String userName) {
		List<PassVo> list = interfaceService.quickPass(request,verifyCode,url,userName);
		return list;
	}

	public List<RegisterVo> quickRegister(HttpServletRequest request,String verifyCode,String webName,String userName) {
		List<RegisterVo> list = interfaceService.quickRegister(request,verifyCode,webName,userName);
		return list;
	}
}
