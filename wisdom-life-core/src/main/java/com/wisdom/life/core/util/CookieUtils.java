package com.wisdom.life.core.util;

import javax.servlet.http.Cookie;

public class CookieUtils {

	/**
	 * 创建cookie
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public static Cookie createCookie(String name, String value) {
		return createCookie(name, value, null, null, null, null, null, null,
				null);
	}

	/**
	 * 创建cookie
	 * 
	 * @param name
	 * @param value
	 * @param domain
	 * @param path
	 * @param maxAge
	 * @param secure
	 * @param purpose
	 * @param isHttpOnly
	 * @param version
	 * @return
	 */
	public static Cookie createCookie(String name, String value, String domain,
			String path, Integer maxAge, Boolean secure, String purpose,
			Boolean isHttpOnly, Integer version) {
		Cookie cookie = new Cookie(name, value);
		if (domain != null) {
			cookie.setDomain(domain);
		}
		if (path != null) {
			cookie.setPath(path);
		}
		if (maxAge != null) {
			cookie.setMaxAge(maxAge);
		}
		if (secure != null) {
			cookie.setSecure(secure);
		}
		if (purpose != null) {
			cookie.setComment(purpose);
		}
		if (isHttpOnly != null) {
			cookie.setHttpOnly(isHttpOnly);
		}
		if (version != null) {
			cookie.setVersion(version);
		}
		return cookie;
	}

}
