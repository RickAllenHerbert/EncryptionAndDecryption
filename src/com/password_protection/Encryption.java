package com.password_protection;

import javax.crypto.*;

public class Encryption {

    public SecretKey generateKey(String encryption) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(encryption);
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey;
        }
        catch (Exception e) {
            return null;
        }
    }
}
