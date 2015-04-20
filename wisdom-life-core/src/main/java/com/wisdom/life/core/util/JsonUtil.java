package com.wisdom.life.core.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {

	public static JSONArray getJSONArray(JSONObject json, String key) {
		JSONArray value = null;
		try {
			value = json.getJSONArray(key);
		} catch (Exception e) {
		}
		return value;
	}

	public static Boolean getBooleanValue(JSONObject json, String key) {
		Boolean value = null;
		try {
			value = json.getBoolean(key);
		} catch (Exception e) {
		}
		return value;
	}

	public static String getStringValue(JSONObject json, String key) {
		String value = null;
		try {
			value = json.getString(key);
		} catch (Exception e) {
		}
		return value;
	}

	public static Long getLongValue(JSONObject json, String key) {
		Long value = null;
		try {
			value = json.getLong(key);
		} catch (Exception e) {
		}
		return value;
	}

	public static Integer getIntValue(JSONObject json, String key) {
		Integer value = null;
		try {
			value = json.getInt(key);
		} catch (Exception e) {
		}
		return value;
	}

	public static Double getDoubleValue(JSONObject json, String key) {
		Double value = null;
		try {
			value = json.getDouble(key);
		} catch (Exception e) {
		}
		return value;
	}

}
