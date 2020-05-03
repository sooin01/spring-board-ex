package com.my.app.common.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

public class SignatureUtil {

	public static void main(String[] args) throws Exception {
		// KeyPair 생성
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(2048, new SecureRandom());
		KeyPair keyPair = generator.genKeyPair();

		// PrivateKey, PublicKey 생성
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();

		// Signature 생성
		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initVerify(publicKey);
		signature.update("Hello World!".getBytes("UTF-8"));
	}

}
