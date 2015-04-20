package com.wisdom.life.core.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginChecker {

	/**
	 * 验证是否登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean isLogin(HttpServletRequest request,
			HttpServletResponse response);

}
