package com.table.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.base.BaseService;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.base.encrypt.rsa.RSAUtils;
import com.table.manager.entity.Manager;
import com.table.manager.service.ManagerService;

@Service("managerService")
public class ManagerServiceImpl extends BaseService implements ManagerService {
	public boolean login(HttpServletRequest request, String userName, String password) {
		Manager manager = this.getManagerByName(userName);
		String truePassWord;
		try {
			String privateKey = manager.getPrivateKey();
			byte[] data = Base64Utils.decodeFromString(manager.getPassword());
			byte[] decodedData = RSAUtils.decryptByPrivateKey(data, privateKey);
			truePassWord = Base64Utils.encodeToString(decodedData);
			password = password.substring(0, password.length()-1);
			truePassWord = truePassWord.substring(0, password.length());
			if (truePassWord.endsWith(password)) {
				String currentTime = this.refFormatNowDate();
				manager.setLastPassTime(currentTime);
				manager.setPassCount(manager.getPassCount() + 1);
				this.saveOrUpdate(manager);
				HttpSession session = request.getSession();
				session.setAttribute("managerName", manager.getName());
				return true;
			}
			return false;
		} catch (Exception e) {
			log.debug(e);
			return false;
		}
	}

	private Manager getManagerByName(String userName) {
		// TODO Auto-generated method stub
		String hql = "from Manager where name=?";
		return dao.findObject(hql, userName);
	}

	@Override
	public Manager getManager(String id) {
		// TODO Auto-generated method stub
		return dao.getObject(Manager.class, id);
	}

	@Override
	public List<Manager> getAllManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Manager manager) {
		// TODO Auto-generated method stub
		if (null == manager.getId() || manager.getId().length() == 0) {
			try {
				Map<String, Object> keyMap = RSAUtils.genKeyPair();
				String publicKey = RSAUtils.getPublicKey(keyMap);
				String privateKey = RSAUtils.getPrivateKey(keyMap);
				String safePassWord;
				byte[] data = Base64Utils.decodeFromString(manager.getPassword());
				byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
				safePassWord = Base64Utils.encodeToString(encodedData);
				manager.setPassword(safePassWord);
				manager.setLastPassTime(null);
				manager.setPassCount(0);
				manager.setPrivateKey(privateKey);
				dao.saveObject(manager);
			} catch (Exception e) {
				// TODO: handle exception
				log.debug(e);
			}

		} else {
			dao.updateObject(manager);
		}
	}

	@Override
	public boolean deleteManager(String id) {
		// TODO Auto-generated method stub
		Manager manager = this.getManager(id);
		dao.delete(manager);
		return true;
	}

	@Override
	public Pager<Manager> getByPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		String hql = "from Manager";
		int page = pageBean.getPageNo();
		int rows = pageBean.getPageSize();
		return dao.findPager(hql, page, rows);
	}

	public String refFormatNowDate() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		return retStrFormatNowDate;
	}

}
