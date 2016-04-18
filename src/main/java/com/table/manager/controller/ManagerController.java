package com.table.manager.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.BaseController;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.manager.entity.Manager;
import com.table.manager.service.ManagerService;

@Controller
@RequestMapping("/managers")
public class ManagerController extends BaseController{

    /*
     * 在配置文件中， userManager会绑定bean中id为userManager的类 有注解就不需要set方法
     */
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/goList")
    public String goList(HttpServletRequest request) {
        return "manager/list";
    }

    @RequestMapping("/getAllManager")
    @ResponseBody
    public Pager<Manager> getAllManager(HttpServletRequest request,Integer page,Integer rows) {
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
    public String getManager(Integer id, HttpServletRequest request) {
        request.setAttribute("manager", managerService.getManager(id));
        return "/editManager";
    }

    @RequestMapping("/toAddManager")
    public String toAddManager() {
        return "/addManager";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public boolean SaveOrUpdate(Manager manager, HttpServletRequest request) {
        managerService.saveOrUpdate(manager);
        return true;
    }

    /**
     *
     * @param id
     * @param response
     */
    @RequestMapping("/delManager")
    public void delManager(Integer id, HttpServletResponse response) {

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

