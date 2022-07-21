package com.leetcode.practice.array;


/**
 *
 * @author Velmurugan Moorthy
 * @date 21.07.2022
 *
 * Problem Name : Single Number
 *
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1

Example 2:

Input: nums = [4,1,2,1,2]
Output: 4

Example 3:

Input: nums = [1]
Output: 1



Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

 */
public class SingeNumberDriver {
    public static void main(String[] args) {
        SingleNumberFinder singleNumberFinder = new SingleNumberFinder();
//        int[] nums = {4,1,2,1,2};//Test case#1 - Happy flow - PASS
//        int[] nums = {1};//Test case#2 - Single element - PASS
        int[] nums = {2,2,1};//Test case#3 Three elements - PASS
//        int[] nums = {};//Test case#
//        int[] nums = {};//Test case#

        System.out.println("Single number is : " + singleNumberFinder.findSingleNumber(nums));
    }
}

/**
 * Approach :
 *  1. Perform XOR on each and every element
 *  2. Store the result in a variable
 *  3. After exiting the loop return the varaible.
 *
 */
class SingleNumberFinder {
    public int findSingleNumber(int[] inputArray) {

        if(inputArray.length == 1){
            return inputArray[0];
        }

        int singleNumber = inputArray[0];
        for(int loopIndex = 1; loopIndex < inputArray.length; loopIndex++){
            singleNumber = singleNumber ^ inputArray[loopIndex];
        }
        //System.out.println("singleNumber is : " + singleNumber);
        return singleNumber;
    }
}