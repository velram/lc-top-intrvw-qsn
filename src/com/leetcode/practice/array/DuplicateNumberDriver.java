package com.leetcode.practice.array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Velmurugan Moorthy
 * @date 22.07.2022
 *
 * Problem Name : Contains Duplicate
 * Question link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 * Problem description : Given an integer array nums,
 * return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 */
public class DuplicateNumberDriver {
    public static void main(String[] args) {

        DuplicateNumberFinder duplicateNumberFinder = new DuplicateNumberFinder();
//        int[] inputArray = {1,2,3,1};//Test case #1 Happy flow - PASS
//        int[] inputArray = {1,2,3,4};//Test case #2 No duplicates - PASS
//        int[] inputArray = {1,1,1,3,3,4,3,2,4,2};//Test case #3 Multi-time present - PASS
//        int[] inputArray = {1,1,1,1,1,2};//Test case #4 Only one unique element - PASS
//        int[] inputArray = {1};//Test case #5 single element array - PASS
        int[] inputArray = {2,2,2,2,2,2};//Test case #6 only duplicates
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
        System.out.println("DuplicateNumberExists : " + duplicateNumberFinder.containsDuplicate(inputArray));
    }
}

/**
 * Approach #1 : Use Map to count frequency
 * Approach #2 - use Set to find the duplicate
 *
 * Test cases :
 *
 */
class DuplicateNumberFinder {
    public boolean containsDuplicate(int[] inputArray) {
       Set<Integer> uniqueNumbers = new HashSet<>();
       for(int currentElement : inputArray){
           if(!uniqueNumbers.add(currentElement)){
               return true;
           }
       }
       return false;
    }
}
