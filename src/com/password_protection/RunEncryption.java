package com.password_protection;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.util.Scanner;

public class RunEncryption {

    public static void main(String args[]) {
        Encryption encryption = new Encryption();

        Scanner input = new Scanner(System.in);
        System.out.print("ENTER CUSTOMER NAME: ");
        String username = input.nextLine();
        System.out.print("ENTER YOUR PASSWORD: ");
        String password = input.nextLine();

        try {
            SecretKey secretKey = encryption.generateKey("AES");
            Cipher cipher = Cipher.getInstance("AES");

            byte[] encryptedData = encryption.encryptData(password, secretKey, cipher);
            encryption.decryptData(encryptedData, secretKey, cipher);
        }
        catch (Exception e) {

        }



    }
}
