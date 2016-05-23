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
	
	@RequestMapping("/toPersonal")
	public String toPersonal(HttpServletRequest request) {
		return "web/personal/personal";
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
	
	@RequestMapping("realName")
	public String viewIDCard(HttpServletRequest request) {
		return "web/personal/realName";
	}
	
	@RequestMapping("viewPhone")
	public String viewPhone(HttpServletRequest request) {
		return "web/personal/contactWay";
	}
	
	@RequestMapping("setPhone")
	@ResponseBody
	public String setPhone(HttpServletRequest request,String phone) {
		return "web/personal/contactWay";
	}
	
	@RequestMapping("viewEmail")
	public String viewEmail(HttpServletRequest request) {
		return "web/personal/contactWay";
	}
	
	@RequestMapping("uploadImg")
	public String uploadImg(HttpServletRequest request) {
		return "test/upload/image";
	}
	
	@RequestMapping("setEmail")
	@ResponseBody
	public String setEmail(HttpServletRequest request,String email) {
		return "web/personal/contactWay";
	}
	
	@RequestMapping("setIDCard")
	@ResponseBody
	public Result setIDCard(HttpServletRequest request,String iDCard) {
		Result result = new Result("验证身份证成功！",true);
		return result;
	}
}
