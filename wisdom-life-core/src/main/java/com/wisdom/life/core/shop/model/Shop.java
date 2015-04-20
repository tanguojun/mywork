package com.wisdom.life.core.shop.model;

import java.util.List;

import com.wisdom.life.core.common.model.Position;

/**
 * 店铺
 */
public class Shop {

	/**
	 * 店铺id
	 */
	private String id;

	/**
	 * 店铺名称
	 */
	private String shopName;

	/**
	 * 位置信息
	 */
	private Position position;

	/**
	 * 商户id
	 */
	private String merchantId;

	/**
	 * 店铺类型id
	 */
	private String shopTypeId;

	/**
	 * 店铺标签
	 */
	private String tag;

	/**
	 * 介绍
	 */
	private String intro;

	/**
	 * 创建时间
	 */
	private Long createTime;

	/**
	 * 修改时间
	 */
	private Long updateTime;

	/**
	 * 联系电话
	 */
	private List<String> phone;

	/**
	 * 店铺图片地址
	 */
	private List<String> images;

	/**
	 * 店铺最新公告
	 */
	private String notice;

	/**
	 * 店铺关键字
	 */
	private String keys;

	/**
	 * 状态
	 */
	private int status;
	
}
