package com.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpUtils {
	public static HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}

}
