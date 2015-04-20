package com.wisdom.life.core.util;

public class ParseUtils {

	public static Long parseLong(Object value) {
		try {
			return Long.parseLong(value.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Long parseLong(Object value, Long defaultValue) {
		try {
			return Long.parseLong(value.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultValue;
	}

}
