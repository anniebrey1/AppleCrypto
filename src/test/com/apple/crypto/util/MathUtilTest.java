package com.apple.crypto.util;

import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MathUtilTest {
    ArrayList<Double> nums = new ArrayList<>();
    MathUtil mathUtil = new MathUtil();
    Double stdDev, mean;

    @Before
    public void init(){
        nums.add(5.0);
        nums.add(10.0);
        nums.add(15.0);
        nums.add(20.0);
        stdDev = 5.5902;
        mean = 12.5;
    }

    @Test
    public void testMean() {
        assertEquals(mathUtil.findAverage(nums),mean);
    }

    @Test
    public void testStdDev() {
        DecimalFormat df = new DecimalFormat("#.####");
        Double ans = Double.valueOf(df.format(mathUtil.findStdDev(nums,12.5)));
        assertEquals(ans,stdDev);
    }
}
