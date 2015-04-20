package com.wisdom.life.supplier.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wisdom.life.core.util.ParseUtils;
import com.wisdom.life.core.web.auth.LoginChecker;
import com.wisdom.life.web.filter.AbstractExcludeUrlFilter;

/**
 * 登录过滤器,获取用户cookie,如果redis缓存中包含用户登录成功的认证cookie,则放行,否则进入登录页面<br/>
 * 配置此过滤器时,下列初始值需要配置,不配置实用默认值 <br/>
 * loginCheckerBean : 验证是否登录用户接口 loginUrl : 登录路径 <br/>
 * defaultSessionTime : 默认的redis存储时间,用于校验此cookie是否<br/>
 * exclude : 不拦截的URL<br/>
 * include : 需要拦截的URL<br/>
 */
public class AuthLoginFilter extends AbstractExcludeUrlFilter {

	/**
	 * 登录方法接口
	 */
	private String loginCheckerBean = "loginCheckerBean";

	private LoginChecker loginCheckerService = null;

	private FilterConfig filterConfig = null;

	/**
	 * 登录路径
	 */
	private String loginUrl = "login.jhtml";

	/**
	 * 缓存中存储会话的超时时间
	 */
	private long defaultSessionTime = new Long(30 * 60l);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		String loginUrl = filterConfig.getInitParameter("LOGINURL");
		if (!StringUtils.isBlank(loginUrl)) {
			this.loginUrl = loginUrl;
		}
		String loginCheckerBeanName = filterConfig
				.getInitParameter("loginCheckerBean");
		if (!StringUtils.isBlank(loginCheckerBeanName)) {
			loginCheckerBean = loginCheckerBeanName;
		}
		String sessionTime = filterConfig.getInitParameter("sessionTime");
		if (!StringUtils.isBlank(sessionTime)) {
			defaultSessionTime = ParseUtils.parseLong(sessionTime,
					defaultSessionTime);
		}
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(filterConfig
						.getServletContext());
		loginCheckerService = (LoginChecker) wac.getBean(loginCheckerBean);
		if (loginCheckerService == null) {
			throw new ServletException("loginCheckerService is null");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (doInclude(request, response, chain)) {
			chain.doFilter(request, response);
			return;
		}
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (loginCheckerService.isLogin(req, res)) {
			chain.doFilter(request, response);
			return;
		}
		res.sendRedirect(loginUrl);
		return;
	}

	@Override
	public void destroy() {

	}

	@Override
	public String getInitParameter(String param) {
		if (filterConfig == null) {
			return null;
		}
		return filterConfig.getInitParameter(param);
	}

}
