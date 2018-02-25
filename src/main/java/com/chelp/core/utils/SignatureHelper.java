package com.chelp.core.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

import com.chelp.core.common.ApiConfig;
import com.chelp.core.common.MessageEnum;
import com.chelp.core.exception.DecryptException;
import com.chelp.core.exception.EncryptException;
import com.chelp.core.exception.SignatureException;

/**
 * 
 * @ClassName: SignatureHelper 
 * @Description: 签名工具类
 * @author jiangjun
 * @date 2017年3月7日 下午3:11:25
 */
public class SignatureHelper {

	private SignatureHelper() {
	}

	/**
	 * 
	 * @Title: encryption 
	 * @Description: 数据加密、编码
	 * @param @param data 待加密、编码数据
	 * @param @return
	 * @param @throws EncryptException
	 * @return String
	 * @throws
	 */
	public static String encryption(String data) throws EncryptException {
		return encodeBase64(encryptDES(encodeURL(data, ApiConfig.DEFAULT_CHARSET), ApiConfig.APP_KEY));
	}

	/**
	 * 
	 * @Title: encryption 
	 * @Description: 数据编码、加密
	 * @param @param data 待加密、编码数据
	 * @param @param key des加密用key
	 * @param @return
	 * @param @throws EncryptException
	 * @return String
	 * @throws
	 */
	public static String encryption(String data, String key) throws EncryptException {
		return encodeBase64(encryptDES(encodeURL(data, ApiConfig.DEFAULT_CHARSET), key));
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
		return decodeURL(decryptDES(decodeBase64(data.getBytes()), ApiConfig.APP_KEY), ApiConfig.DEFAULT_CHARSET);
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
		return decodeURL(decryptDES(decodeBase64(data.getBytes()), key), ApiConfig.DEFAULT_CHARSET);
	}

	/**
	 * 
	 * @Title: encodeURL 
	 * @Description: URLEncoder编码
	 * @param @param data
	 * @param @param character
	 * @param @return
	 * @param @throws EncryptException
	 * @return String
	 * @throws
	 */
	private static String encodeURL(String data, String character) throws EncryptException {
		try {
			return URLEncoder.encode(data, character);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EncryptException(MessageEnum.ENCODING_FAILED.getMessage());
		}
	}

	/**
	 * 
	 * @Title: decodeURL 
	 * @Description: URLDecoder解码
	 * @param @param data
	 * @param @param character
	 * @param @return
	 * @param @throws EncryptException
	 * @return String
	 * @throws
	 */
	private static String decodeURL(String data, String character) throws DecryptException {
		try {
			return URLDecoder.decode(data, character);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DecryptException(MessageEnum.DECODING_FAILED.getMessage());
		}
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
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			return cipher.doFinal(data.getBytes());
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
	private static String decryptDES(String data, String key) throws DecryptException {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, securekey, random);
			return new String(cipher.doFinal(data.getBytes()));
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
	 * @param @param binaryData
	 * @param @return
	 * @param @throws DecryptException
	 * @return String
	 * @throws
	 */
	private static String decodeBase64(byte[] binaryData) throws DecryptException {
		try {
			return new String(Base64.decodeBase64(binaryData));
		} catch (Exception e) {
			e.printStackTrace();
			throw new DecryptException(MessageEnum.BASE64_DECODING_FAILED.getMessage());
		}
	}

	/**
	 * 
	 * @Title: checkSignature 
	 * @Description: 校验签名
	 * @param @param request
	 * @param @throws SignatureException
	 * @return void
	 * @throws
	 */
	public static void checkSignature(HttpServletRequest request) throws SignatureException {
		try {
			// 如果调用方没有提交签名过来，则直接抛出异常
			String sign = request.getParameter("sign");
			if (CodeHelper.isNullOrEmpty(sign))
				throw new SignatureException(MessageEnum.PARAMETER_DOES_NOT_EXIST.getMessage());

			StringBuffer buffer = new StringBuffer();
			Enumeration<?> enumerations = request.getParameterNames();
			Map<String, Object> params = new HashMap<String, Object>();
			// 取出所有请求的参数，封装进map里
			while (enumerations.hasMoreElements()) {
				String key = (String) enumerations.nextElement();
				Object value = request.getParameter(key);
				// 除参数不为sign（调用方生成的签名），并且参数值不能为空
				if (!key.equalsIgnoreCase("sign") && null != value && !value.toString().equalsIgnoreCase("")) {
					params.put(key, value);
				}
			}
			// 将所有请求参数按参数名字母升序排序
			Object[] keys = params.keySet().toArray();
			Arrays.sort(keys);
			boolean isFirst = true;
			// 将参数按URL格式拼接成字符串
			for (Object key : keys) {
				if (isFirst)
					isFirst = false;
				else
					buffer.append("&");
				buffer.append(key).append("=");
				buffer.append(params.get(key).toString());
			}
			buffer.append("&appSecret=" + ApiConfig.APP_SECRET);
			// MD5加密转大写
			String md5 = MD5Helper.toMD5(buffer.toString()).toUpperCase();
			// 签名不匹配则直接抛出异常，由上层捕获
			if (!sign.equals(md5))
				throw new SignatureException(MessageEnum.SIGNATURE_INCONSISTENCY.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SignatureException(MessageEnum.SIGNATURE_VERIFICATION_FAILED.getMessage());
		}
	}
}
