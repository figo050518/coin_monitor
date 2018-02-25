
package com.chelp.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @ClassName: MD5Helper 
 * @Description: MD5工具类
 * @author jiangjun
 * @date 2017年3月7日 下午3:09:35
 */
public class MD5Helper {

	private MD5Helper() {
	}

	public static String toMD5(String plainText) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(plainText.getBytes());
		byte b[] = md.digest();
		int i;
		StringBuffer buffer = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buffer.append("0");
			}
			buffer.append(Integer.toHexString(i));
		}
		return buffer.toString();
	}
}
