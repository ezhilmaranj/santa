package com.logica.srtracker.util;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public final class PasswordService {
	private static PasswordService instance;
	private static final Logger log = Logger.getLogger(PasswordService.class);
	private static String salt = "GK";
	private static final String ALGORITHM = "AES";
	private static final int ITERATIONS = 2;
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'i', 's',
			'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

	public static synchronized PasswordService getInstance() {
		if (instance == null) {
			instance = new PasswordService();
		}
		return instance;
	}

	public String encrypt(String value) {
		String eValue = null;
		String valueToEnc = null;
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.ENCRYPT_MODE, key);
			eValue = value;
			for (int i = 0; i < ITERATIONS; i++) {
				valueToEnc = salt + eValue;
				byte[] encValue = c.doFinal(valueToEnc.getBytes());
				eValue = Base64.encodeBase64String(encValue);
			}
		} catch (Exception e) {
			log.error("Exception during encrption", e);
		}
		return eValue;
	}

	public String decrypt(String value) {
		String dValue = null;
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			String valueToDecrypt = value;
			for (int i = 0; i < ITERATIONS; i++) {
				byte[] decordedValue = Base64.decodeBase64(valueToDecrypt);
				byte[] decValue = c.doFinal(decordedValue);
				dValue = new String(decValue).substring(salt.length());
				valueToDecrypt = dValue;
			}
		} catch (Exception e) {
			log.error("Exception during decrption", e);
		}
		return dValue;
	}

	private static Key generateKey() {
		Key key = new SecretKeySpec(keyValue, ALGORITHM);
		return key;
	}

}
