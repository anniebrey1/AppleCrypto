package com.apple.crypto.controller;

import com.apple.crypto.util.CryptoUtil;
import com.apple.crypto.util.MathUtil;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/*
* API CONTROLLER
*   this is the main controller for our calculations and crypto service - there are 3 endpoints
*   /PushAndRecalculate - insert a double into the arraylist and returns the average and standard
*       deviation of the list
*   /PushRecalculateAndEncrypt - insert a double to the arraylist and returns encrypted strings
*       of the average and standard deviation of the list
*   /Decrypt - input an encrypted string, and it returns the decrypted Double value
* */

@Path("/crypto")
@Produces(MediaType.APPLICATION_JSON)
public class APIController {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    ArrayList<Double> numberList = new ArrayList<>();
    MathUtil mathUtil = new MathUtil();
    CryptoUtil cryptoUtil = new CryptoUtil();

    public APIController(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @Path("/PushAndRecalculate")
    @POST
    public Double[] pushAndRecalculate(@QueryParam("number") Double number) {
        numberList.add(number);
        return mathUtil.calculate(numberList);
    }

    @Path("/PushRecalculateAndEncrypt")
    @POST
    public String[] pushRecalculateAndEncrypt(@QueryParam("number") Double number) {
        numberList.add(number);
        Double[] ans = mathUtil.calculate(numberList);
        String[] encrypted = new String [2];
        encrypted[0] = cryptoUtil.encrypt(ans[0]);
        encrypted[1] = cryptoUtil.encrypt(ans[1]);
        return encrypted;
    }

    @Path("/Decrypt")
    @POST
    public Double[] decrypt(@QueryParam("encryptedNumber") String encryptedNumber) {
        Double[] ans = new Double[1];
        ans[0] = cryptoUtil.decrypt(encryptedNumber);
        return ans;
    }
    /*
    * NEXT STEPS
    *   Inject utils
    * */
}
