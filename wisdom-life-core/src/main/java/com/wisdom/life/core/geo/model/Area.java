package com.wisdom.life.core.geo.model;

/**
 * 区县
 */
public class Area {

	/**
	 * id
	 */
	private String id;

	/**
	 * 编码
	 */
	private String code;

	/**
	 * 所属城市编码
	 */
	private String cityCode;

	/**
	 * 名称
	 */
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
