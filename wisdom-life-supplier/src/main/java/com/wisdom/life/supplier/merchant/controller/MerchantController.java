package com.wisdom.life.supplier.merchant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wisdom.life.web.controller.base.BaseController;

/**
 * 商户controller
 */
@Controller
@RequestMapping("/user")
public class MerchantController extends BaseController {

	@RequestMapping(value = "/login.jhtml")
	public ModelAndView login(HttpServletRequest request, Pageable pageable) {
		ModelAndView mav = new ModelAndView(JSON_VIEW);
		return mav;
	}

}
