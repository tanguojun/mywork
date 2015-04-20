package com.wisdom.life.web.controller.base;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	/**
	 * JSON VIEW : 返回JSON视图
	 */
	protected String JSON_VIEW = "jsonView";

	/**
	 * 错误信息-页面取值变量名称
	 */
	protected String ERROR = "error";

	/**
	 * 结果
	 */
	protected String RESULT = "result";

	protected String TRUE = "true";

	protected String FALSE = "false";

	/**
	 * 获取国际化
	 * 
	 * @param code
	 * @return
	 */
	public String getI18nString(HttpServletRequest request, String code) {
		return code;
	}

}
