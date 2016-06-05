package com.table.manager.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.BaseController;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.manager.entity.Manager;
import com.table.manager.service.ManagerService;

@Controller
@RequestMapping("/managers")
public class ManagerController extends BaseController {

	/*
	 * 在配置文件中， userManager会绑定bean中id为userManager的类 有注解就不需要set方法
	 */
	@Autowired
	private ManagerService managerService;

	@RequestMapping("/top")
	public String top(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		model.addAttribute("managerName", session.getAttribute("managerName"));
		return "top";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, String loginName, String password, Model model) {
		if(loginName.length()==0)
		return "manager";
		if (managerService.login(request, loginName, password)) {
			HttpSession session = request.getSession();
			model.addAttribute("managerName", session.getAttribute("managerName"));
			return "manager";
		}
		return "404";
	}

	@RequestMapping("/goList")
	public String goList(HttpServletRequest request) {
		return "table/manager/list";
	}

	@RequestMapping("/getAllManager")
	@ResponseBody
	public Pager<Manager> getAllManager(HttpServletRequest request, Integer page, Integer rows) {
		PageBean pageBean = new PageBean();
		pageBean.setPageNo(page);
		pageBean.setPageSize(rows);
		Pager<Manager> pager = managerService.getByPage(pageBean);
		return pager;
	}

	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getManager")
	public String getManager(String id, HttpServletRequest request) {
		request.setAttribute("manager", managerService.getManager(id));
		return "/editManager";
	}

	@RequestMapping("/toAddManager")
	public String toAddManager() {
		return "/addManager";
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public boolean saveOrUpdate(Manager manager, HttpServletRequest request) {
		managerService.saveOrUpdate(manager);
		return true;
	}

	/**
	 *
	 * @param id
	 * @param response
	 */
	@RequestMapping("/delManager")
	public void delManager(String id, HttpServletResponse response) {

		String result = "{\"result\":\"error\"}";

		if (managerService.deleteManager(id)) {
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
