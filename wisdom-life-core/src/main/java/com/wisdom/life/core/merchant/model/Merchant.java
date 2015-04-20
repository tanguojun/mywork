package com.wisdom.life.core.merchant.model;

import java.util.List;

import org.springframework.data.annotation.Transient;

import com.wisdom.life.core.common.model.ContactInfo;
import com.wisdom.life.core.shop.model.Shop;

/**
 * 商户
 */
public class Merchant {

	public static final String ID = "id";
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";

	/**
	 * 商户id
	 */
	private String id;

	/**
	 * 商户名称
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 联系方式列表
	 */
	private List<ContactInfo> contactInfoList;

	/**
	 * 注册时间
	 */
	private Long registerTime;

	/**
	 * 商户上次登录时间
	 */
	private Long loginTime;

	/**
	 * 修改时间
	 */
	private Long updateTime;

	/**
	 * 商店列表
	 */
	@Transient
	private List<Shop> shopList;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}

	public List<ContactInfo> getContactInfoList() {
		return contactInfoList;
	}

	public void setContactInfoList(List<ContactInfo> contactInfoList) {
		this.contactInfoList = contactInfoList;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Long getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Long registerTime) {
		this.registerTime = registerTime;
	}

	public Long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}

}
