package com.leetcode.practice.array;

import java.util.Arrays;

/**
 *
 * @author Velmurugan Moorthy
 * @date 26.07.2022
 *
 * Problem Name :  Rotate Array
 * Question link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 * Problem description : Given an array, rotate the array to the right by k steps, where k is non-negative.
 * return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 */
public class ArrayRotateDriver {
    public static void main(String[] args) {
        ArrayRotator arrayRotator = new ArrayRotator();
        //Test case #1 - Happy flow - PASS
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;

//        //Test case #2 - even size array and 'k' is even - PASS
//        int[] nums = {-1,-100,3,99};
//        int k = 2;

//        //Test case #3 - small sized array - PASS
        int[] nums = {1,2};
        int k = 1;

//        //Test case #4
//        int[] nums = {-1};
//        int k = 2;

//        //Test case #
//        int[] nums = {};
//        int k = 0;
//        //Test case #
//        int[] nums = {};
//        int k = 0;
        arrayRotator.rotate(nums,k);
    }
}

class ArrayRotator {
    public void rotate(int[] nums, int k) {

        int[] result = new int[nums.length];

        //No rotation required
        if(nums.length <= 1 || nums.length <= k && nums.length % k == 0){
            //System.out.println("No rotation required");
            return;
        }

        if(k > nums.length){
            k = (k % nums.length);
        }

        int firstHalfStart = 0;
        int firstHalfEnd =  nums.length - k - 1;
        int secondHalfStart = nums.length - k;
        int secondHalfEnd = nums.length - 1;

        int newArrayIndex = 0;


        while(secondHalfStart <= secondHalfEnd){
            result[newArrayIndex++] = nums[secondHalfStart++];
        }
        while(firstHalfStart <= firstHalfEnd){
            result[newArrayIndex++] = nums[firstHalfStart++];
        }

        for(int loopIndex = 0; loopIndex < nums.length; loopIndex++){
            nums[loopIndex] = result[loopIndex];
        }

        //Arrays.stream(result).forEach(System.out::println);
    }
}