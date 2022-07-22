package com.leetcode.practice.array;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Velmurugan Moorthy
 * @date 21.07.2022
 *
 * Problem Name : Two Sum
 * Question link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 * Problem description :
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSumDriver {
    public static void main(String[] args) {

        TwoSumFinder twoSumFinder = new TwoSumFinder();
        //Test case #1 - Happy flow - PASS
//        int[] inputArray = {2,7,11,15};
//        int target = 9;

        //Test case #2 - Two element array - PASS
//        int[] inputArray = {3,3};
//        int target = 6;

        //Test case #3
        int[] inputArray = {3,2,4};
        int target = 6;

        int[] result = twoSumFinder.twoSum(inputArray, target);
        System.out.println("Indices are : " + result[0] + " , " + result[1]);
    }
}

/**
 * Approach :
 *  a + b = target.
 *  We know target. We'll have 'a' an element from input[i]
 *  We need ot find 'b'
 *  Formula : b = (target - a)
 *
 *  Find difference (target - input[i])
 *  Store the difference, index in a map.
 *  When you find the target in the Map,
 *  return the current index and index of 'a' in the map.
 *
 *
 */
class TwoSumFinder {
    public int[] twoSum(int[] inputArray, int target) {

        int[] result = new int[2];

        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        int actualSum = 0;
        for(int loopIndex = 0; loopIndex < inputArray.length; loopIndex++){
            actualSum = target - inputArray[loopIndex];
            if(!valueIndexMap.containsKey(actualSum)){
                valueIndexMap.put(inputArray[loopIndex], loopIndex);
            }
            else {
                result[0] = valueIndexMap.get(actualSum);
                result[1] = loopIndex;
                //System.out.println("The indices are : " + result[0] + " | " + result[1]);
            }
        }
        return result;
    }
}
