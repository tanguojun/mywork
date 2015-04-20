package com.wisdom.life.supplier.index.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wisdom.life.web.controller.base.BaseController;

/**
 * 商户首页controller
 */
@Controller
@RequestMapping
public class IndexContoller extends BaseController {

	private static final String INDEX_VIEW = "index/index";

	/**
	 * 登录页面视图
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/index.jhtml")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(INDEX_VIEW);
		return mav;
	}

}
