package com.wisdom.life.core.util;

import org.apache.commons.codec.digest.Md5Crypt;

public class MD5CryptUtil {

	public static void main(String[] args) {
		String tt1 = Md5Crypt.md5Crypt("333".getBytes());
		System.out.println(tt1);
		String mysalt = getSalts(tt1);
		System.out.println(Md5Crypt.md5Crypt("333".getBytes(), mysalt));

		String tt2 = Md5Crypt.md5Crypt("333".getBytes());
		System.out.println(tt2);
		mysalt = getSalts(tt2);
		System.out.println(Md5Crypt.md5Crypt("333".getBytes(), mysalt));
	}

	public static String getSalts(String password) {
		String[] salts = password.split("\\$");
		if (salts.length < 1) {
			return "";
		}
		String mysalt = "";
		for (int i = 1; i < 3; i++) {
			mysalt += "$" + salts[i];
		}
		mysalt += "$";
		return mysalt;
	}

}
