package com.apple.crypto.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CryptoUtilTest {
    Double secret = 12.5;
    String enc = "WP68RXM1WSoqdatp9mORpA==";
    CryptoUtil cryptoUtil = new CryptoUtil();

    @Test
    public void testEncryptDecrypt() {
        String enc = cryptoUtil.encrypt(secret);
        Double dec = cryptoUtil.decrypt(enc);
        assertEquals(dec,secret);
    }

    @Test
    public void testDecrypt() {
        Double dec = cryptoUtil.decrypt(enc);
        assertEquals(dec,secret);
    }

    @Test
    public void testEncrypt() {
        String ans = cryptoUtil.encrypt(secret);
        assertEquals(ans,enc);
    }

}
