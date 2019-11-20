package controllers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionService {

	public static String encryptString(String input) throws NoSuchAlgorithmException
	{
		MessageDigest encryptor = MessageDigest.getInstance("SHA-256");
		byte[] hash = encryptor.digest(input.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(hash);
	}
	
	/*
	 * Origin: https://www.baeldung.com/sha-256-hashing-java
	 */
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}
