package com.wisdom.life.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * URL过滤器
 */
public abstract class AbstractExcludeUrlFilter implements Filter {

	public abstract String getInitParameter(String param);

	private static final String exclude = "excludeUrls";

	private static final String include = "includeUrls";

	private static final String splite = ";";

	/**
	 * 忽略的url
	 * 
	 * @param request
	 * @param response
	 * @param filterChain
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public boolean doExclude(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		String excludeUrls = getInitParameter(exclude);
		if (StringUtils.isBlank(excludeUrls)) {
			return false;
		}
		String[] excludes = excludeUrls.split(splite);

		HttpServletRequest httprequest = (HttpServletRequest) request;

		// 需要忽略的URL
		for (int i = 0; i < excludes.length; i++) {
			String path = httprequest.getServletPath();
			String regx = excludes[i].trim().replaceAll("\\.", "\\\\.");
			regx = regx.replaceAll("\\*", "\\.*");
			if (excludes[i].endsWith("/")) {
				regx += ".*";
			}
			if (path.matches(regx)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 包含的url
	 * 
	 * @param request
	 * @param response
	 * @param filterChain
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public boolean doInclude(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		String includeUrls = this.getInitParameter(include);
		if (StringUtils.isBlank(includeUrls)) {
			return false;
		}
		String[] includes = includeUrls.split(splite);

		HttpServletRequest httprequest = (HttpServletRequest) request;

		// 需要加载的URL
		for (int i = 0; i < includes.length; i++) {
			String path = httprequest.getServletPath();
			String regx = includes[i].trim().replaceAll("\\.", "\\\\.");
			regx = regx.replaceAll("\\*", "\\.*");
			if (includes[i].endsWith("/")) {
				regx += ".*";
			}
			if (path.matches(regx)) {
				return true;
			}
		}
		return false;
	}
}
