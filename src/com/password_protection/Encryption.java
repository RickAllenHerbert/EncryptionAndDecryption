package com.password_protection;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;

public class Encryption {

    public SecretKey generateKey(String encryption) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(encryption);
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey;
        } catch (Exception e) {
            return null;
        }
    }

    public byte[] encryptData(String data, SecretKey secretKey, Cipher cipher) {
        try {
            byte[] text = data.getBytes(StandardCharsets.UTF_8);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textEncrypted = cipher.doFinal(text);

            System.out.println("ENCRYPTED PASSWORD: " + textEncrypted);
            return textEncrypted;
        } catch (Exception e) {
            return null;
        }
    }

    public String decryptData(byte[] data, SecretKey secretKey, Cipher cipher) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] textDecrypted = cipher.doFinal(data);
            String output = new String(textDecrypted);

            System.out.println("DECRYPTED PASSWORD: " + output);
            return output;
        } catch (Exception e) {
            return null;
        }
    }
}
