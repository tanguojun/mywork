package com.wisdom.life.core.validate.utils;

/**
 * 校验类
 * 
 * @author LoLo
 */
public class ValidateUtils {

	/**
	 * 校验字符串长度是否大于等于begin
	 * 
	 * @param str
	 * @param begin
	 * @return
	 */
	public static boolean isGetLength(String str, int begin) {
		return isInLength(str, begin, Integer.MAX_VALUE);
	}

	/**
	 * 校验字符串长度是否在begin和end之间(包含)
	 * 
	 * @param str
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean isInLength(String str, int begin, int end) {
		if (str == null) {
			return false;
		}
		int len = str.length();
		if (len >= begin && len <= end) {
			return true;
		}
		return false;
	}

}
