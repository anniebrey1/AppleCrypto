package com.apple.crypto.util;

import java.util.ArrayList;

/*
* MATH UTIL
*   this math util is for calculating the mean and standard deviation
*   findAverage takes in an arraylist of double and returns the average of all nums
*   findStdDev takes in an arraylist of double and the mean and returns the standard
*   deviation of all nums
*
* NEXT STEPS:
 *   We don't need to recalculate the mean and std dev every time (Reduce time complexity)
 *   We can have a running sum and count for the mean (Reduce time complexity)
 *       - we can just pass the Double (instead of numList) to findAverage
 *       - don't need to store values in arraylist (Reduce memory usage)
 *   We can also have the current stdDev and mean for the std dev (Reduce time complexity)
 *       - we can just pass the Double (instead of numList) to findStdDev
 *       - don't need to store values in arraylist (Reduce memory usage)
* */

public class MathUtil {

    public Double[] calculate(ArrayList<Double> numList){
        Double mean = findAverage(numList);
        Double stdDev = findStdDev(numList, mean);
        return new Double[]{mean, stdDev};
    }

    public Double findAverage(ArrayList<Double> numList){
        int count = 0;
        Double sum = 0.0;
        for (Double num : numList) {
            count++;
            sum += num;
        }
        return(sum/count);
    }

    public Double findStdDev(ArrayList<Double> numList, Double mean){
        int length = numList.size();
        Double stdDev = 0.0;
        for(Double num: numList) {
            stdDev += Math.pow(num - mean, 2);
        }
        return Math.sqrt(stdDev/length);
    }
}
