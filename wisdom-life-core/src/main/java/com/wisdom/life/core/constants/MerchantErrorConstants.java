package com.wisdom.life.core.constants;

public interface MerchantErrorConstants extends BaseErrorConstants {

	/**
	 * 用户名或密码错误
	 */
	public String LOGIN_FAIL = "用户名或密码错误";

	/**
	 * 用户名不能为空
	 */
	public String USERNAME_NULL = "用户名不能为空";

	/**
	 * 密码不能为空
	 */
	public String PASSWORD_NULL = "密码不能为空";

	/**
	 * 用户名由6-18位数字或字母组成
	 */
	public String USERNAME_LENGTH_ERROR = "用户名由6-18位数字或字母组成";
	
	/**
	 * 对不起,登录失败,请重新输入
	 */
	public String LOGIN_ERROR = "对不起,登录失败,请重新输入";

}
