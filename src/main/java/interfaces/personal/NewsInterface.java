package interfaces.personal;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.http.HttpRequest;

@Controller
@RequestMapping("/NewsInterface")
public class NewsInterface {
	String url;
	// 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	String param;
	String httpUrl;
	String httpArg = "num=10&page=1";

	@RequestMapping("/getGlobalNews")
	@ResponseBody
	public void getGlobalNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		httpUrl = "http://apis.baidu.com/txapi/world/world";
		String jsonResult = HttpRequest.request(httpUrl, httpArg);
		PrintWriter out = response.getWriter();
		out.print(jsonResult);
		out.flush();
		out.close();
	}

	@RequestMapping("/getPElNews")
	@ResponseBody
	public void getPElNews(HttpServletRequest request,
			HttpServletResponse response)

	throws ServletException, IOException {
		httpUrl = "http://apis.baidu.com/txapi/world/world";
		String jsonResult = HttpRequest.request(httpUrl, httpArg);
		PrintWriter out = response.getWriter();
		out.print(jsonResult);
		out.flush();
		out.close();
	}

	@RequestMapping("/getTeNews")
	@ResponseBody
	public void getTeNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		httpUrl = "http://apis.baidu.com/txapi/world/world";
		String jsonResult = HttpRequest.request(httpUrl, httpArg);
		PrintWriter out = response.getWriter();
		out.print(jsonResult);
		out.flush();
		out.close();
	}

}
