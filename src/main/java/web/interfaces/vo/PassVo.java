package web.interfaces.vo;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.base.HttpUtils;
import com.base.random.RandomSecret;

public class PassVo implements Serializable {
	/**
	 * 
	 */
	
	public PassVo(HttpServletRequest request) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		this.userId = userId;
		this.time = HttpUtils.getTime();
		this.code = RandomSecret.getAccess();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	private String code;
	private String userId;
	private String time;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "PassVo [code=" + code + ", userId=" + userId + ", time=" + time + "]";
	}
}
