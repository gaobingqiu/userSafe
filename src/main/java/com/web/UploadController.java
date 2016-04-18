package com.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.base.BaseController;

@Controller
@RequestMapping("/file")
public class UploadController extends BaseController {
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
    public String upload(HttpServletRequest request,
            HttpServletResponse response) throws IllegalStateException,
            IOException {
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
                //文件类型限制
                List<String> fileTypes = new ArrayList<String>();
                fileTypes.add("jpg");
                fileTypes.add("jpeg");
                fileTypes.add("bmp");
                fileTypes.add("gif");
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    String ext = myFileName.substring(myFileName.lastIndexOf(".")+1,myFileName.length());
                    if(!fileTypes.contains(ext)) { 
                        return "/404";
                    }
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        System.out.println(myFileName);
                        // 重命名上传后的文件名
                        String fileName = "demoUpload"
                                + file.getOriginalFilename();
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
}