package interfaces.personal;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.table.user.entity.User;
import com.table.user.service.UserService;

import web.upload.controller.UploadService;

@Controller
@RequestMapping("/imageUploadInterface")
public class ImageUploadInterface {
	@Autowired
	private UserService userService;

	@Autowired
	private UploadService uploadService;

	@RequestMapping("/uploadImg")
	@ResponseBody
	public void uploadImg(HttpServletRequest request, HttpServletResponse response,File image) throws IOException {
		if (image == null) // 图像数据为空
		{
			return ;
		}
		// 生成jpeg图片
		String imgFilePath = "E:/workplace/userSafe/src/main/webapp/images/upload/images/";// 新生成的图片F
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		User user = userService.getUser(userId);
		Long time = System.currentTimeMillis();// 获取当前时间戳
		imgFilePath = imgFilePath + userId + time + ".png";
		String truePath = "/images/upload/images/" + userId + time + ".png";
		if (uploadService.androidSaveManager(image, imgFilePath)) {
			user.setImage(truePath);
			userService.saveOrUpdate(user);
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		}
	}
}
