package com.my.app.common.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class SecurityUtil {

	public static void main(String[] args) throws Exception {
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

		Cipher cipher = Cipher.getInstance("RSA");

		// 공개키 이용 암호화
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] bCipher1 = cipher.doFinal("Hello World!".getBytes());
		String sCipher1 = Base64.encodeBase64String(bCipher1);
		System.out.println(sCipher1);

		// 개인키 이용 복호화
		byte[] bCipher2 = Base64.decodeBase64(sCipher1.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] bPlain2 = cipher.doFinal(bCipher2);
		String sPlain2 = new String(bPlain2);
		System.out.println(sPlain2);
	}

}
