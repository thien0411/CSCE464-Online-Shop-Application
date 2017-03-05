package util;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

public class Cookies {
	public static List<String> getValueList (HttpServletRequest request, String cookieName) {
		List<String> valueList = new LinkedList<String>();
		Cookie[] cookies = request.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(cookieName)) {
				valueList.add(cookies[i].getValue());
			}
		}
		
		return valueList;
	}
	
	public static String getValue (HttpServletRequest request, String cookieName, String defaultValue) {
		Cookie[] cookies = request.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(cookieName)) {
				return cookies[i].getValue();
			}
		}
		
		return defaultValue;
	}
	
	/*TODO: For extra credit, add other functions for remembering login info.*/
}
