package com.table.records.controller;

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
import com.table.records.entity.Records;
import com.table.records.service.RecordsService;

@Controller
@RequestMapping("/records")
public class RecordsController extends BaseController{

    /*
     * 在配置文件中， userManager会绑定bean中id为userManager的类 有注解就不需要set方法
     */
    @Autowired
    private RecordsService recordsService;

    @RequestMapping("/goList")
    public String goList(HttpServletRequest request) {
        return "records/list";
    }

    @RequestMapping("/getAllRecords")
    @ResponseBody
    public Pager<Records> getAllRecords(HttpServletRequest request,Integer page,Integer rows) {
        PageBean pageBean = new PageBean();
        pageBean.setPageNo(page);
        pageBean.setPageSize(rows);
        Pager<Records> pager = recordsService.getByPage(pageBean);
        return pager;
    }

    /**
     * 
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/getRecords")
    public String getRecords(Integer id, HttpServletRequest request) {
        request.setAttribute("records", recordsService.getRecords(id));
        return "/editRecords";
    }

    @RequestMapping("/toAddRecords")
    public String toAddRecords() {
        return "/addRecords";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public boolean SaveOrUpdate(Records records, HttpServletRequest request) {
        recordsService.saveOrUpdate(records);
        return true;
    }

    /**
     *
     * @param id
     * @param response
     */
    @RequestMapping("/delRecords")
    public void delRecords(Integer id, HttpServletResponse response) {

        String result = "{\"result\":\"error\"}";

        if (recordsService.deleteRecords(id)) {
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

