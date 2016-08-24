//package interfaces.personal;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping("/NewsInterface")
//public class NewsInterface {
//
//	@RequestMapping("/login")
//	@ResponseBody
//	public void login(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String httpUrl = "http://api.tianapi.com/wxnew/?key=您的key&num&rand";
//		String jsonResult = request(httpUrl);
//		System.out.println(jsonResult);
//	}
//
//	public static String request(String httpUrl, String httpArg) {
//	    BufferedReader reader = null;
//	    String result = null;
//	    StringBuffer sbf = new StringBuffer();
//	    httpUrl = httpUrl + "?" + httpArg;
//
//	    try {
//	        URL url = new URL(httpUrl);
//	        HttpURLConnection connection = (HttpURLConnection) url
//	                .openConnection();
//	        connection.setRequestMethod("GET");
//	        InputStream is = connection.getInputStream();
//	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//	        String strRead = null;
//	        while ((strRead = reader.readLine()) != null) {
//	            sbf.append(strRead);
//	            sbf.append("\r\n");
//	        }
//	        reader.close();
//	        result = sbf.toString();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return result;
//}
//}
