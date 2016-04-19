package com.table.user.controller;

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
import com.table.user.entity.User;
import com.table.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    /*
     * 在配置文件中， userManager会绑定bean中id为userManager的类 有注解就不需要set方法
     */
    @Autowired
    private UserService userService;

    @RequestMapping("/goList")
    public String goList(HttpServletRequest request) {
        return "table/user/list";
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    public Pager<User> getAllUser(HttpServletRequest request,Integer page,Integer rows) {
        PageBean pageBean = new PageBean();
        pageBean.setPageNo(page);
        pageBean.setPageSize(rows);
        Pager<User> pager = userService.getByPage(pageBean);
        return pager;
    }

    /**
     * 
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/getUser")
    public String getUser(Integer id, HttpServletRequest request) {
        request.setAttribute("user", userService.getUser(id));
        return "/editUser";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "/addUser";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public boolean SaveOrUpdate(User user, HttpServletRequest request) {
        userService.saveOrUpdate(user);
        return true;
    }

    /**
     *
     * @param id
     * @param response
     */
    @RequestMapping("/delUser")
    public void delUser(Integer id, HttpServletResponse response) {

        String result = "{\"result\":\"error\"}";

        if (userService.deleteUser(id)) {
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

