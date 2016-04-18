package com.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
    /** 要检查的 session 的名称 */
    private String sessionKey; 

    /** 需要排除（不拦截）的URL的正则表达式 */
    private Pattern excepUrlPattern; 

    /** 检查不通过时，转发的URL */
    private String forwardUrl; 

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings("unused")
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest) req; 
        HttpServletResponse response = (HttpServletResponse) res; 
        String servletPath = request.getServletPath(); 
        if (servletPath.equals(forwardUrl) || excepUrlPattern.matcher(servletPath).matches()) { 
            chain.doFilter(req, res); 
            return; 
        } 
        Object sessionObj = request.getSession().getAttribute(sessionKey); 
        // 如果Session为空，则跳转到指定页面 
        if (sessionObj == null) { 
            String contextPath = request.getContextPath(); 
        } 
        else { 
            chain.doFilter(req, res); 
        } 
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}