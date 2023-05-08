package model;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

public class EncryptionModel {
    private String inputText;
    private String key;

    public EncryptionModel(String inputText) {
        this.inputText = inputText;
    }

    public String generateKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        keyGenerator.init(256);
        SecretKey key = keyGenerator.generateKey();
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
    private static final String ALGORITHM = "AES";

    public static String encrypt(String key, String message) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(key.getBytes(StandardCharsets.UTF_8));
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, originalKey);
        byte[] encryptedMessage = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(encryptedMessage);
    }
    public String encryptText() {
        // Generate the key
//        Random rand = new Random();
//        int keyLength = inputText.length();
//        StringBuilder keyBuilder = new StringBuilder();
//        for (int i = 0; i < keyLength; i++) {
//            keyBuilder.append((char) (rand.nextInt(26) + 'A'));
//        }
//        key = keyBuilder.toString();
        key=generateKey();

        // Encrypt the text
        StringBuilder encryptedTextBuilder = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            char k = key.charAt(i);
            int encryptedChar = (c + k) % 26;
            encryptedTextBuilder.append((char) (encryptedChar + 'A'));
        }
        try {
            return encrypt(key,inputText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //return encryptedTextBuilder.toString();
    }

    public String getKey() {
        return key;
    }
}

