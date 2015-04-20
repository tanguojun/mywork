package com.wisdom.life.service.merchant.service.impl;

import static com.wisdom.life.core.merchant.model.Merchant.USER_NAME;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static com.wisdom.life.core.constants.MerchantConstants.*;

import com.wisdom.life.core.merchant.dao.MerchantDao;
import com.wisdom.life.core.merchant.model.Merchant;
import com.wisdom.life.core.util.CookieUtils;
import com.wisdom.life.core.util.MD5CryptUtil;
import com.wisdom.life.core.util.SerializeUtils;
import com.wisdom.life.core.util.SqlUtil;
import com.wisdom.life.service.cache.service.CacheService;
import com.wisdom.life.service.merchant.service.MerchantService;

public class MerchantServiceImpl implements MerchantService {

	@Override
	public boolean isLogin(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie cookies[] = request.getCookies();
		if (cookies == null || cookies.length == 0) {
			return false;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(LOGIN_COOKIE)) {
				Object user = redisService.get(cookie.getValue());
				if (user != null) {
					redisService.set(cookie.getName().getBytes(),
							SerializeUtils.serialize(user),
							LOGIN_COOKIE_CACHE_TIME);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Merchant loginValidate(String userName, String password) {
		Query query = new Query();
		query.addCriteria(new Criteria().and(USER_NAME).is(userName));
		List<Merchant> list = merchantDao.findAll(query);
		if (list == null || list.size() == 0) {
			return null;
		}
		Merchant merchant = list.get(0);
		if (merchant.getPassword() != null
				&& merchant.getPassword().equals(
						Md5Crypt.md5Crypt(password.getBytes(),
								MD5CryptUtil.getSalts(merchant.getPassword())))) {
			return merchant;
		}
		return null;
	}

	@Override
	public void loginSuccessSetCookie(HttpServletResponse response,
			Merchant merchant) {
		String cookieValue = SqlUtil.getUUIDByPk();
		redisService.set((cookieValue).getBytes(),
				SerializeUtils.serialize(merchant.getId()),
				LOGIN_COOKIE_CACHE_TIME);
		response.addCookie(CookieUtils.createCookie(LOGIN_COOKIE, cookieValue));
	}

	private CacheService redisService;

	private MerchantDao merchantDao;

	public void setRedisService(CacheService redisService) {
		this.redisService = redisService;
	}

	public void setMerchantDao(MerchantDao merchantDao) {
		this.merchantDao = merchantDao;
	}

}
