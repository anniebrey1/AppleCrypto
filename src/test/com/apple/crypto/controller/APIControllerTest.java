package com.apple.crypto.controller;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class APIControllerTest {

    APIController apiController = new APIController("template","crypto");
    Double mean = 5.0;
    Double input = 5.0;
    Double stdDev = 0.0;
    String encMean = "NJvq3LBcQBdtUQGb7dyllw==";
    String encStdDev = "Ueuzhv85k6D6E3qhiODr5g==";

    @Test
    public void testMeanStdDev() {
        Double[] ans = apiController.pushAndRecalculate(input);
        assertEquals(ans[0], mean);
        assertEquals(ans[1], stdDev);
    }

    @Test
    public void testEnc() {
        String[] ans = apiController.pushRecalculateAndEncrypt(input);
        assertEquals(ans[0], encMean);
        assertEquals(ans[1], encStdDev);
    }

    @Test
    public void testDec() {
        Double[] ans = apiController.decrypt(encMean);
        assertEquals(ans[0], mean);
        ans = apiController.decrypt(encStdDev);
        assertEquals(ans[0], stdDev);
    }

}
