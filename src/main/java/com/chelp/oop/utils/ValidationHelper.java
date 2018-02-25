package com.chelp.oop.utils;

public class ValidationHelper {

	private ValidationHelper() {
	}

	private static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	public static String entryptPassword(String plainPassword) {
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
	}

	/**
	 * 
	 * @Title: validatePassword 
	 * @Description: 校验密码
	 * @param @param plainPassword 明文密码
	 * @param @param password 密文密码
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Encodes.decodeHex(password.substring(0, 16));
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
	}
}
