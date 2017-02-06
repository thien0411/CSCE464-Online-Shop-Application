package util;

import javax.servlet.http.HttpServletRequest;

public class Images {
	public static String resolveExtension(HttpServletRequest request, String imageLocation) {
		String accept = request.getHeader("accept");

		if(accept.contains("webp")) {
			return imageLocation + ".webp";
		}
		else {
			return imageLocation + ".jpg";
		}
	}
}
