package web.upload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.base.BaseController;
import com.table.user.entity.User;
import com.table.user.service.UserService;

import sun.misc.BASE64Decoder;

@Controller
@RequestMapping("/file")
public class UploadController extends BaseController {
	@Autowired
	private UserService userService;
	@RequestMapping("/toImage")
	public String toImage() {
		return "test/upload/image";
	}

	/**
	 * 应用解析器上传文件。
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 记录上传过程起始时的时间，用来计算上传时间
				int pre = (int) System.currentTimeMillis();
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				// 文件类型限制
				List<String> fileTypes = new ArrayList<String>();
				fileTypes.add("jpg");
				fileTypes.add("jpeg");
				fileTypes.add("bmp");
				fileTypes.add("gif");
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					String ext = myFileName.substring(myFileName.lastIndexOf(".") + 1, myFileName.length());
					if (!fileTypes.contains(ext)) {
						return "/404";
					}
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
						String fileName = "demoUpload" + file.getOriginalFilename();
						// 定义上传路径
						String path = "F:/design/files/" + fileName;
						File localFile = new File(path);
						file.transferTo(localFile);
					}
				}
				// 记录上传该文件后的时间
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}
			return "/success";
		}
		return "/404";
	}
	
	 @RequestMapping("/uploadImg")
	 @ResponseBody
	public boolean uploadImg(HttpServletRequest request,String image) {
	    	if (image == null) // 图像数据为空
	    		return false;
	    		BASE64Decoder decoder = new BASE64Decoder();
	    		try {
	    		// Base64解码
	    		byte[] b = decoder.decodeBuffer(image.substring(22));
	    		for (int i = 0; i < b.length; ++i) {
	    		if (b[i] < 0) {// 调整异常数据
	    		b[i] += 256;
	    		}
	    		}
	    		// 生成jpeg图片
	    		String imgFilePath = "E:/workplace/userSafe/src/main/webapp/images/upload/images/";// 新生成的图片
	    		HttpSession session = request.getSession();
	    		String userId = (String) session.getAttribute("userId");
	    		User user = userService.getUser(userId);
	    		Long time= System.currentTimeMillis();//获取当前时间戳
	    		imgFilePath = imgFilePath+userId+time+".png";
	    		String truePath = "/images/upload/images/"+userId+time+".png";
	    		user.setImage(truePath);
	    		userService.saveOrUpdate(user);
	    		OutputStream out = new FileOutputStream(imgFilePath);
	    		out.write(b);
	    		out.flush();
	    		out.close();
	    		return true;
	    		} catch (Exception e) {
	    		return false;
	    		}
	    }
}