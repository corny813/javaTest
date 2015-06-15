package encrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.sun.crypto.provider.SunJCE;

public class EncryptAES {

	private KeyGenerator keygen;
	private SecretKey deskey;
	private Cipher cipher;
	private byte[] cipherByte;

	public EncryptAES() throws NoSuchAlgorithmException, NoSuchPaddingException {

		Security.addProvider(new SunJCE());

		keygen = KeyGenerator.getInstance("AES");
		deskey = keygen.generateKey();
		cipher = Cipher.getInstance("AES");
	}

	public byte[] Encrytor(String str) throws InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		
		cipher.init(Cipher.ENCRYPT_MODE, deskey);
		cipherByte = cipher.doFinal(str.getBytes());
		return cipherByte;
	}

	public byte[] Decryptor(byte[] buff) throws InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		
		cipher.init(Cipher.DECRYPT_MODE, deskey);
		cipherByte = cipher.doFinal(buff);
		return cipherByte;
	}

	public static void main(String[] args) throws Exception {
		EncryptAES de1 = new EncryptAES();
		String msg = "8135221368";
		byte[] encontent = de1.Encrytor(msg);
		byte[] decontent = de1.Decryptor(encontent);
		System.out.println("原文是: " + msg);
		System.out.println("加密后: " + new String(encontent));
		System.out.println("解密后: " + new String(decontent));
	}

}
