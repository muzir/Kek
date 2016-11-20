package com.muzir.kek.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author erhun.baycelik
 *
 */
@Component
public class Hashy {
	private String charEncoding = "UTF-8";
	@Value("${application.secretKey}")
	private String secretKey;

	public String calculateHash(String param) {
		if (StringUtils.isBlank(param)) {
			return "";
		}
		StringBuilder sbParamInput = new StringBuilder();
		sbParamInput.append(param);
		sbParamInput.append(secretKey);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] textBytes = sbParamInput.toString().getBytes(charEncoding);
			md.update(textBytes);
			byte[] hash = md.digest();
			String strHash = new String(Base64.encodeBase64(hash));
			return strHash;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Add a logger
		}
		return "";
	}

	public boolean verifyHash(String hash, String paramater) {
		String newHash = calculateHash(paramater);
		return hash.equals(newHash);
	}

}
