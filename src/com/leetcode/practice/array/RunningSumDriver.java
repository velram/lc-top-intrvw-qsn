package com.leetcode.practice.array;

import java.util.Arrays;

/**
 * @author Vel
 * @date 31.07.2022
 *
 * link : https://leetcode.com/problems/running-sum-of-1d-array/
 * Problem name : Running sum of 1-D array
 */
public class RunningSumDriver {
    public static void main(String[] args) {
        RunningSumFinder runningSumFinder = new RunningSumFinder();
//        int[] nums = {1,2,3,4};//Test case #1 - Happy flow - PASS
//        int[] nums = {-32};//Test case #2 - single element - PASS
//        int[] nums = {1,1,1,1,1};//Test case #3 - PASS
        int[] nums = {3,1,2,10,1};//Test case #4 - PASS
//        int[] nums = {};//Test case #
//        int[] nums = {};//Test case #
        runningSumFinder.findRunningSum(nums);
    }
}

class RunningSumFinder {
    public int[] findRunningSum(int[] nums) {

        int[] runningSum = new int[nums.length];

        runningSum[0] = nums[0];
        for(int loopIndex = 1; loopIndex < nums.length; loopIndex++){
            runningSum[loopIndex] = runningSum[loopIndex - 1] + nums[loopIndex];
        }

       // Arrays.stream(runningSum).forEach(System.out::println);
        return runningSum;
    }
}
