package web.personal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.BaseController;
import com.base.Result;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.records.entity.Records;
import com.table.records.service.RecordsService;
import com.table.user.entity.User;
import com.table.user.service.UserService;

@Controller
@RequestMapping("/personal")
public class PersonalController extends BaseController{
	@Autowired
	private UserService UserService;
	@Autowired
	RecordsService recordsService;

	@RequestMapping("/toPersonal")
	public String toPersonal(HttpServletRequest request) {
		return "web/personal/personal";
	}

	@RequestMapping("/codeManage")
	public String codeManage(HttpServletRequest request, Integer page, Integer rows, Model model) {
		PageBean pageBean = new PageBean();
		if(null== page){
			page = 1;
		}
		if(null== rows){
			rows = 10;
		}
		pageBean.setPageNo(page);
		pageBean.setPageSize(rows);
		Pager<Records> pager = recordsService.getByPage(request, pageBean);
		model.addAttribute("pager", pager);
		return "web/personal/codeManage";
	}

	@RequestMapping("/update")
	public boolean update(HttpServletRequest request, User user) {
		UserService.saveOrUpdate(user);
		return true;
	}

	@RequestMapping("/delete")
	public boolean delete(HttpServletRequest request, String id) {
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
	public String setPhone(HttpServletRequest request, String phone) {
		return "web/personal/contactWay";
	}

	@RequestMapping("viewEmail")
	public String viewEmail(HttpServletRequest request) {
		return "web/personal/contactWay";
	}

	@RequestMapping("uploadImg")
	public String uploadImg(HttpServletRequest request) {
		return "web/personal/image";
	}

	@RequestMapping("setEmail")
	@ResponseBody
	public String setEmail(HttpServletRequest request, String email) {
		return "web/personal/contactWay";
	}

	@RequestMapping("setIDCard")
	@ResponseBody
	public Result setIDCard(HttpServletRequest request, String iDCard) {
		Result result = new Result("验证身份证成功！", true);
		return result;
	}
}
