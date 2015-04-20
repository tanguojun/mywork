package com.wisdom.life.core.geo.model;

/**
 * 城市
 */
public class City {

	/**
	 * id
	 */
	private String id;
	
	/**
	 * 编码
	 */
	private String code;
	
	/**
	 * 所属省份编码
	 */
	private String provinceCode;
	
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

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
