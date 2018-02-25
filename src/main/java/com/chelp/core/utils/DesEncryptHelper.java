package com.chelp.core.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.chelp.core.common.ApiConfig;
import com.chelp.core.common.MessageEnum;
import com.chelp.core.exception.DecryptException;
import com.chelp.core.exception.EncryptException;

/**
 * 
 * @ClassName: DesEncryptHelper 
 * @Description: DES加解密
 * @author jiangjun
 * @date 2017年4月14日 下午2:23:03
 */
public class DesEncryptHelper {

	private DesEncryptHelper() {
	}

	/**
	 * 
	 * @Title: encryption 
	 * @Description: 数据加密、编码
	 * @param @param data 待加密、编码
	 * @param @param data
	 * @param @return
	 * @param @throws EncryptException
	 * @return String
	 * @throws
	 */
	public static String encryption(String data) throws EncryptException {
		return encodeBase64(encryptDES(data, ApiConfig.APP_KEY));
	}

	/**
	 * 
	 * @Title: encryption 
	 * @Description: 数据加密、编码
	 * @param @param data 待加密、编码
	 * @param @param data
	 * @param @param key
	 * @param @return
	 * @param @throws EncryptException
	 * @return String
	 * @throws
	 */
	public static String encryption(String data, String key) throws EncryptException {
		return encodeBase64(encryptDES(data, key));
	}

	/**
	 * 
	 * @Title: decryption 
	 * @Description: 数据解码、解密
	 * @param @param data 待解码、解密数据
	 * @param @return
	 * @param @throws DecryptException
	 * @return String
	 * @throws
	 */
	public static String decryption(String data) throws DecryptException {
		return decryptDES(decodeBase64(data.getBytes()), ApiConfig.APP_KEY);
	}

	/**
	 * 
	 * @Title: decryption 
	 * @Description: 数据解码、解密
	 * @param @param data 待解码、解密数据
	 * @param @param key des解密用key
	 * @param @return
	 * @param @throws DecryptException
	 * @return String
	 * @throws
	 */
	public static String decryption(String data, String key) throws DecryptException {
		return decryptDES(decodeBase64(data.getBytes()), key);
	}

	/**
	 * 
	 * @Title: encryptDES 
	 * @Description: DES加密
	 * @param @param data 待加密数据
	 * @param @param key 加密用key
	 * @param @return
	 * @param @throws EncryptException
	 * @return byte[]
	 * @throws
	 */
	private static byte[] encryptDES(String data, String key) throws EncryptException {
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(new DESKeySpec(key.getBytes(ApiConfig.DEFAULT_CHARSET)));
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, securekey, SecureRandom.getInstance("SHA1PRNG"));
			return cipher.doFinal(data.getBytes("UTF8"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new EncryptException(MessageEnum.DES_ENCRYPTION_FAILED.getMessage());
		}
	}

	/**
	 * 
	 * @Title: decryptDES 
	 * @Description: DES解密
	 * @param @param data 待加密数据
	 * @param @param key 加密用key
	 * @param @return
	 * @param @throws DecryptException
	 * @return String
	 * @throws
	 */
	private static String decryptDES(byte[] data, String key) throws DecryptException {
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(new DESKeySpec(key.getBytes(ApiConfig.DEFAULT_CHARSET)));
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, securekey, SecureRandom.getInstance("SHA1PRNG"));
			return new String(cipher.doFinal(data), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DecryptException(MessageEnum.DES_DECRYPTION_FAILED.getMessage());
		}
	}

	/**
	 * 
	 * @Title: encodeBase64 
	 * @Description: Base64编码
	 * @param @param binaryData
	 * @param @return
	 * @param @throws EncryptException
	 * @return String
	 * @throws
	 */
	private static String encodeBase64(byte[] binaryData) throws EncryptException {
		try {
			return Base64.encodeBase64String(binaryData);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EncryptException(MessageEnum.BASE64_ENCODING_FAILED.getMessage());
		}
	}

	/**
	 * 
	 * @Title: decodeBase64 
	 * @Description: Base64解码
	 * @param @param data
	 * @param @return
	 * @param @throws DecryptException
	 * @return byte[]
	 * @throws
	 */
	private static byte[] decodeBase64(byte[] binaryData) throws DecryptException {
		try {
			return Base64.decodeBase64(binaryData);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DecryptException(MessageEnum.BASE64_DECODING_FAILED.getMessage());
		}
	}
}
