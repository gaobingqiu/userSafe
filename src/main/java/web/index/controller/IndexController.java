package web.index.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.BaseController;

@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

	@RequestMapping("/goManager")
	public String goList(HttpServletRequest request) {
		return "manager";
	}
	
	@RequestMapping("/404")
	public String go404(HttpServletRequest request) {
		return "404";
	}
	
	@RequestMapping("/toUpload")
    //@ResponseBody 返回json数据
    public String toUpload() {
    	log.error("到了");
        return "test/upload/upload";
    }
}
