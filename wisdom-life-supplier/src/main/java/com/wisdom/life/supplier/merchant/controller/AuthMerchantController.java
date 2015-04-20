package com.wisdom.life.supplier.merchant.controller;

import static com.wisdom.life.core.constants.MerchantErrorConstants.LOGIN_ERROR;
import static com.wisdom.life.core.constants.MerchantErrorConstants.LOGIN_FAIL;
import static com.wisdom.life.core.constants.MerchantErrorConstants.PASSWORD_NULL;
import static com.wisdom.life.core.constants.MerchantErrorConstants.USERNAME_LENGTH_ERROR;
import static com.wisdom.life.core.constants.MerchantErrorConstants.USERNAME_NULL;
import static com.wisdom.life.core.validate.utils.ValidateUtils.isInLength;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.wisdom.life.core.merchant.model.Merchant;
import com.wisdom.life.service.merchant.service.MerchantService;
import com.wisdom.life.supplier.merchant.dto.MerchantDto;
import com.wisdom.life.web.controller.base.BaseController;

/**
 * 商户认证、注册、找回密码Controller
 */
@Controller
@RequestMapping
public class AuthMerchantController extends BaseController {

	/**
	 * 登录页面
	 */
	private static final String LOGIN_VIEW = "login/login";

	/**
	 * 登录成功URL
	 */
	private static final String LOGIN_SUCCESS_URL = "index.jhtml";

	/**
	 * 登录页面视图
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login.jhtml")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView(LOGIN_VIEW);
		if (merchantService.isLogin(request, response)) {
			mav.setView(new RedirectView(LOGIN_SUCCESS_URL, true, false, false));
			return mav;
		}
		return mav;
	}

	/**
	 * 商户登录提交
	 * 
	 * @param request
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loginSubmit.jhtml")
	public String loginSubmit(HttpServletRequest request,
			HttpServletResponse response, MerchantDto mt) {
		JSONObject result = new JSONObject();
		String msg = validateLoginSubmit(mt);
		if (msg != null) {
			result.put(ERROR, getI18nString(request, msg));
			return result.toString();
		}
		try {
			Merchant merchant = merchantService.loginValidate(mt.getUserName(),
					mt.getPassword());
			if (merchant == null) {
				result.put(ERROR, getI18nString(request, LOGIN_FAIL));
			} else {
				merchantService.loginSuccessSetCookie(response, merchant);
				result.put(RESULT, TRUE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put(ERROR, getI18nString(request, LOGIN_ERROR));
		}
		return result.toString();
	}

	// validate method

	/**
	 * 商户登录提交-校验方法
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	private String validateLoginSubmit(MerchantDto mt) {
		String msg = null;
		try {
			if (mt == null) {
				msg = USERNAME_NULL;
			} else if (StringUtils.isBlank(mt.getUserName())) {
				msg = USERNAME_NULL;
			} else if (StringUtils.isBlank(mt.getPassword())) {
				msg = PASSWORD_NULL;
			} else if (!isInLength(mt.getUserName(), 6, 18)) {
				msg = USERNAME_LENGTH_ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = LOGIN_ERROR;
		}
		return msg;
	}

	@Autowired
	private MerchantService merchantService;

}
