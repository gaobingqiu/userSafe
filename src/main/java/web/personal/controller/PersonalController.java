package web.personal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.BaseController;
import com.base.HttpUtils;
import com.base.Result;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.records.entity.Records;
import com.table.records.service.RecordsService;
import com.table.user.entity.User;
import com.table.user.service.UserService;

import web.index.service.IndexService;

@Controller
@RequestMapping("/personal")
public class PersonalController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private IndexService indexService;
	@Autowired
	RecordsService recordsService;

	@RequestMapping("/toPersonal")
	public String toPersonal(HttpServletRequest request) {
		return "web/personal/personal";
	}

	@RequestMapping("/codeManage")
	public String codeManage(HttpServletRequest request, Integer page, Integer rows, Model model) {
		PageBean pageBean = new PageBean();
		if (null == page) {
			page = 1;
		}
		if (null == rows) {
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
		userService.saveOrUpdate(user);
		return true;
	}

	@RequestMapping("/delete")
	public boolean delete(HttpServletRequest request, String id) {
		userService.disable(id);
		return true;
	}

	@RequestMapping("realName")
	public String viewIDCard(HttpServletRequest request, Model model) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		User user = userService.getUser(userId);
		String realName = user.getUserName();
		String idNum = user.getIdNum();
		model.addAttribute("realName", realName);
		model.addAttribute("idNum", idNum);
		return "web/personal/realName";
	}

	@RequestMapping("viewPhone")
	public String viewPhone(HttpServletRequest request, Model model) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		User user = userService.getUser(userId);
		String tel = user.getTel();
		model.addAttribute("tel", tel);
		return "web/personal/contactTel";
	}

	@RequestMapping("setPhone")
	@ResponseBody
	public String setPhone(HttpServletRequest request, String phone, Integer code) {
		if (!indexService.checkCode(request, code)) {
			return "error";
		} else {
			HttpSession session = HttpUtils.getSession(request);
			String userId = (String) session.getAttribute("userId");
			User user = userService.getUser(userId);
			user.setTel(phone);
			userService.saveOrUpdate(user);
			return "success";
		}

	}

	@RequestMapping("viewEmail")
	public String viewEmail(HttpServletRequest request, Model model) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		User user = userService.getUser(userId);
		String email = user.getEmail();
		model.addAttribute("email", email);
		return "web/personal/contactEmail";
	}

	@RequestMapping("uploadImg")
	public String uploadImg(HttpServletRequest request) {
		return "web/personal/image";
	}

	@RequestMapping("setEmail")
	@ResponseBody
	public String setEmail(HttpServletRequest request, String email, Integer code) {
		if (!indexService.checkCode(request, code)) {
			return "error";
		} else {
			HttpSession session = HttpUtils.getSession(request);
			String userId = (String) session.getAttribute("userId");
			User user = userService.getUser(userId);
			user.setEmail(email);
			userService.saveOrUpdate(user);
			return "success";
		}
	}

	@RequestMapping("setIDCard")
	@ResponseBody
	public Result setIDCard(HttpServletRequest request, String iDCard) {
		Result result = new Result("验证身份证成功！", true);
		return result;
	}
}
