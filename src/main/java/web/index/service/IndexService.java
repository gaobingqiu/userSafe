package web.index.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.HttpUtils;
import com.table.securityCode.entity.SecurityCode;
import com.table.securityCode.service.SecurityCodeService;

@Service
public class IndexService {
	@Autowired
	SecurityCodeService securityCodeService;

	public boolean checkCode(HttpServletRequest request, Integer code) {
		HttpSession session = HttpUtils.getSession(request);
		String userId = (String) session.getAttribute("userId");
		SecurityCode securityCode = securityCodeService.getSecurityCodeByUserId(userId);
		if (securityCode.getCode() == code) {
			return true;
		}
		return false;
	}

}
