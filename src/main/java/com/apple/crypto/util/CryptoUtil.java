package com.apple.crypto.util;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/*
 * CRYPTO UTIL
 *   this crypto util is for encrypting and decrypting Double values
 *   encrypt takes in a Double and returns the encrypted String
 *   decrypt takes in an encrypted String and returns the original Double
 *
 * NEXT STEPS
 *   randomize/secure encryption key
 *   store encryption key in keystore, so we are able to retrieve same key for encrypt and decrypt
 *   randomize init vector
 * */

public class CryptoUtil {
    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";
    private final IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
    private final SecretKeySpec secKey = new SecretKeySpec(CryptoUtil.key.getBytes(StandardCharsets.UTF_8), "AES");

    public String encrypt(Double number){
        try {
            String str = number.toString();
            //initialize the cipher
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secKey, iv);
            //encrypt and use base64 to encode
            byte[] encrypted = cipher.doFinal(str.getBytes());
            return Base64.getEncoder()
                    .encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Double decrypt(String encryptedNumber){
        try {
            //decode back to byte[]
            byte[] base64 = Base64.getDecoder()
                    .decode(encryptedNumber);
            //initialize the cipher
            Cipher decipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            decipher.init(Cipher.DECRYPT_MODE, secKey, iv);
            //decrypt and convert back to double
            byte[] original = decipher.doFinal(base64);
            return Double.valueOf(new String(original, StandardCharsets.UTF_8));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
