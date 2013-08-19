package com.jeefuse.system.security.service.spring;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public class Md5PasswordEncoder extends MessageDigestPasswordEncoder {

	public Md5PasswordEncoder() {
		super("MD5");
	}

	@Override
	public String encodePassword(String rawPass, Object salt) {
		String encodePassword = rawEncodePassword(rawPass, salt);
		return encodePassword;
	}

	public String encodePassword(String rawPass) {
		return encodePassword(rawPass, null);
	}

	private String rawEncodePassword(String rawPass, Object salt) {
		String saltedPass = mergePasswordAndSalt(rawPass, salt, false);
		MessageDigest messageDigest = getMessageDigest();
		byte digest[];
		try {
			digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("UTF-8 not supported!");
		}
		if (getEncodeHashAsBase64())
			return new String(Base64.encodeBase64(digest));
		else
			return new String(Hex.encodeHex(digest));
	}

	public boolean isPasswordValid(String servicePass, String clientPassDigest, String dynamicCode, @SuppressWarnings("unused") Object salt) {
		String reservedPass = servicePass.concat(dynamicCode);
		String reservedPassDigest = encodePassword(reservedPass);
		return reservedPassDigest.equals(clientPassDigest);
	}

}
