package web.interfaces.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.BaseService;
import com.base.random.RandomSecret;
import com.table.records.service.RecordsService;
import com.table.web.entity.Web;
import com.table.web.service.WebService;

import web.interfaces.vo.PassVo;
import web.interfaces.vo.RegisterVo;

/**
 * 用户登录模块功能类
 * @author gbq
 * 2016年4月19日
 */
@Service
public class InterfaceService extends BaseService{
	@Autowired 
	private RecordsService recordsService;
	
	@Autowired 
	private WebService webService;

	public List<PassVo> quickPass(HttpServletRequest request,String verifyCode, String webName, String userName) {
		// TODO Auto-generated method stub
		Web web = webService.getWebByName(webName);
		HttpSession session = request.getSession();
		String currentName = (String) session.getAttribute("userName");
		if(null==currentName||!currentName.equals(userName)){
			return null;
		} 
		if(web.getTitle().endsWith(recordsService.getWeb(userName, webName)))
			return null;
		return null;
	}

	public List<RegisterVo> quickRegister(HttpServletRequest request,String verifyCode, String webName, String userName) {
		// TODO Auto-generated method stub
		String password = RandomSecret.genRandomNum();
		log.debug(password);
		return null;
	}
	
}
