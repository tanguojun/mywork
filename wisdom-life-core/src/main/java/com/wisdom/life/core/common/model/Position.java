package com.wisdom.life.core.common.model;


/**
 * 位置信息
 */
public class Position {

	/**
	 * 坐标信息
	 */
	private Point point;

	/**
	 * 商店地址
	 */
	private String address;

	/**
	 * 省份编码
	 */
	private String provinceCode;

	/**
	 * 城市编码
	 */
	private String cityCode;

	/**
	 * 区县编码
	 */
	private String areaCode;

	/**
	 * 邮编
	 */
	private String zipCode;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
