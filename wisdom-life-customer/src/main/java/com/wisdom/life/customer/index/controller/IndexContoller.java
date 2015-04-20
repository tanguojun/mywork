package com.wisdom.life.customer.index.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wisdom.life.web.controller.base.BaseController;

/**
 * 首页controller
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
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(INDEX_VIEW);
		return mav;
	}

}
