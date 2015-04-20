package com.wisdom.life.service.merchant.service;

import javax.servlet.http.HttpServletResponse;

import com.wisdom.life.core.merchant.model.Merchant;
import com.wisdom.life.core.web.auth.LoginChecker;

public interface MerchantService extends LoginChecker {

	/**
	 * 登录验证
	 * 
	 * @param userName
	 * @param password
	 * @return merchant
	 */
	public Merchant loginValidate(String userName, String password);

	/**
	 * 设置cookie,登录成功后设置cookie值,并且添加缓存
	 * 
	 * @param merchant
	 */
	public void loginSuccessSetCookie(HttpServletResponse response,
			Merchant merchant);

}
