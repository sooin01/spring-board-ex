package com.my.app.common.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class SecurityUtil {

	private static final ThreadLocal<String> KEYPAIR_THREAD_LOCAL = new ThreadLocal<>();

	public static String getPublicKey() throws Exception {
		SecureRandom random = new SecureRandom();
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(512, random);

		KeyPair keyPair = generator.genKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();

		byte[] bPrivateKey = privateKey.getEncoded();
		byte[] bPublicKey = publicKey.getEncoded();

		String sPrivateKey = Base64.encodeBase64String(bPrivateKey);
		String sPublicKey = Base64.encodeBase64String(bPublicKey);
		System.out.println(sPrivateKey);
		System.out.println(sPublicKey);

		KEYPAIR_THREAD_LOCAL.set(sPrivateKey);
		return sPublicKey;
	}

	public static String encryption(String input) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		String sPublicKey = getPublicKey();
		byte[] bPublicKey = Base64.decodeBase64(sPublicKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bPublicKey);
		PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

		// 공개키 이용 암호화
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] bCipher1 = cipher.doFinal(input.getBytes("UTF-8"));
		String sCipher1 = Base64.encodeBase64String(bCipher1);
		return sCipher1;
	}

	public static String decryption(String encryptionValue) throws Exception {
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		String sPrivateKey = KEYPAIR_THREAD_LOCAL.get();
		byte[] bPrivateKey = Base64.decodeBase64(sPrivateKey.getBytes("UTF-8"));
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bPrivateKey);
		PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

		Cipher cipher = Cipher.getInstance("RSA");
		byte[] bCipher2 = Base64.decodeBase64(encryptionValue.getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] bPlain2 = cipher.doFinal(bCipher2);
		String sPlain2 = new String(bPlain2);
		return sPlain2;
	}

	public static void main(String[] args) throws Exception {
		String input = "Hello World!";
		String encryptionValue = encryption(input);
		System.out.println(encryptionValue);

		String decryptionValue = decryption(encryptionValue);
		System.out.println(decryptionValue);
	}

}
