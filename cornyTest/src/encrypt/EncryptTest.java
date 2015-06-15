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

public class EncryptTest {

	public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		
		String msg = "corndot813";
		System.out.println("original string : "+msg);
		Security.addProvider(new SunJCE());
		
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		SecretKey key = keygen.generateKey();
		System.out.println("key : "+ key);
		
		Cipher cipher = Cipher.getInstance("AES");
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptBytes = cipher.doFinal(msg.getBytes());
		System.out.println("encrypt string : "+new String(encryptBytes));
		
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decryptBytes = cipher.doFinal(encryptBytes);
		System.out.println("decrypt string : "+new String(decryptBytes));
//		System.out.println("decrypt string : "+ decryptBytes.toString());
	}
}
