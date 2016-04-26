package web.personal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.Result;
import com.table.user.entity.User;
import com.table.user.service.UserService;

@Controller
@RequestMapping("/personal")
public class PersonalController {
	@Autowired
	private UserService UserService;
	
	public String toPersonal(HttpServletRequest request) {
		return "web/personal/index";
	}
	
	@RequestMapping("/update")
	public boolean update(HttpServletRequest request,User user) {
		UserService.saveOrUpdate(user);
		return true;
	}
	
	@RequestMapping("/delete")
	public boolean delete(HttpServletRequest request,Integer id) {
		UserService.disable(id);
		return true;
	}
	
	@RequestMapping("viewIDCard")
	public String viewIDCard(HttpServletRequest request) {
		return "web/personal/iDCard";
	}
	
	@RequestMapping("setIDCard")
	@ResponseBody
	public Result setIDCard(HttpServletRequest request,String iDCard) {
		Result result = new Result("验证身份证成功！",true);
		return result;
	}
}
