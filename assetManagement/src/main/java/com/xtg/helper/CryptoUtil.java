package com.xtg.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public interface CryptoUtil {

	public String encrypt(String secretKey, String plainText) throws NoSuchAlgorithmException, InvalidKeySpecException,
	NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,
	UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException;
	
	public String decrypt(String secretKey, String encryptedText) throws NoSuchAlgorithmException,
	InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,
	UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, IOException;
}
