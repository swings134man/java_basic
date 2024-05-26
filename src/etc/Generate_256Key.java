package etc;

import java.security.SecureRandom;
import java.util.Base64;


/**
 * Google Cloud Platform (GCP) - Generate AES-256 Encryption Key Example
 */
public class Generate_256Key {

    public static void main(String[] args) {
        generateEncryptionKey();
    }

    public static String generateEncryptionKey() {
        byte[] key = new byte[32];
        new SecureRandom().nextBytes(key);
        String encryptionKey = Base64.getEncoder().encodeToString(key);
//        String encryptionKey = BaseEncoding.base64().encode(key); // com.google.common.io.BaseEncoding

        System.out.println("Generated Base64-encoded AES-256 encryption key: " + encryptionKey);
        return encryptionKey;
    }
}
