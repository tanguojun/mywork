package com.wisdom.life.core.product.model;

import java.util.List;
import java.util.Properties;

/**
 * 商品
 */
public class Product {

	/**
	 * 商品id
	 */
	private String id;

	/**
	 * 所属店铺id
	 */
	private String shopId;

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 商品原价
	 */
	private Double originalPrice;

	/**
	 * 商品现价
	 */
	private Double presentPrice;

	/**
	 * 商品关键字
	 */
	private String keys;

	/**
	 * 商品介绍
	 */
	private String intro;

	/**
	 * 商品参数
	 */
	private Properties prop;

	/**
	 * 商品图片
	 */
	private List<String> images;

	/**
	 * 创建时间
	 */
	private Long createTime;

	/**
	 * 修改时间
	 */
	private Long updateTime;

	/**
	 * 商品状态
	 */
	private int status;

}
