package com.wisdom.life.core.util;

/**
 * 数字转换器
 */
public class NumberConverterUtils {

	private static char[] digits = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z' };

	/**
	 * 将整形转换为radix进制数
	 * 
	 * @param data
	 *            转换整数
	 * @param radix
	 *            进制
	 * @return
	 */
	public static String numberToRadix(int data, int radix) {
		char buf[] = new char[33];
		int charPos = 32;
		while (data > radix) {
			buf[charPos--] = digits[data % radix];
			data = data / radix;
		}
		buf[charPos] = digits[data];
		return new String(buf, charPos, (33 - charPos));
	}

}
