package com.lucas.etc;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES256_Sample {
    public static void main(String[] args) {
        Generate_256Key genKey = new Generate_256Key();
        Generate_IVKey genIV = new Generate_IVKey();

        String key = genKey.generateEncryptionKey();
        String iv = genIV.generateIVKey();
        String plainText = "Hello, World!";

        String encryptedText = encrypt(key, iv, plainText);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = decrypt(key, iv, encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    // Encryption
    public static String encrypt(String key, String iv, String plainText) {
        // AES-256 Encryption
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            byte[] decodedIV = Base64.getDecoder().decode(iv);

            SecretKeySpec secretKeySpec = new SecretKeySpec(decodedKey, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(decodedIV);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

            return Base64.getEncoder().encodeToString(encryptedBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Decryption
    public static String decrypt(String key, String iv, String encryptedText) {
        // AES-256 Decryption
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            byte[] decodedIV = Base64.getDecoder().decode(iv);
            byte[] decodedEncryptedText = Base64.getDecoder().decode(encryptedText);

            SecretKeySpec secretKeySpec = new SecretKeySpec(decodedKey, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(decodedIV);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] decryptedBytes = cipher.doFinal(decodedEncryptedText);

            return new String(decryptedBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
