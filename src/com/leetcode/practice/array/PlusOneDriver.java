package com.leetcode.practice.array;

import java.util.Arrays;

/**
 *
 * @author Velmurugan Moorthy
 * @date 23.07.2022
 *
 * Problem Name : Plus One
 * Question link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
 * Problem description :
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Test cases :
 *  1. All zeros - (00000)
 *  2. All ones - (111111)
 *  3. All Nines - (999999)
 *  4. MSB - '9' - (9432101)
 *  5. LSB - '9' (123456789)
 *
 */
public class PlusOneDriver {
    public static void main(String[] args) {

        PlusOneFinder plusOneFinder = new PlusOneFinder();
//        int[] digits = {1,2,3}; //TestCase #1 - Happy flow with no carryBit - PASS
//        int[] digits = {9,9, 9,9, 9,9, 9,9}; //TestCase #2 - MSB '9' and with carryBit - PASS
//        int[] digits = {0}; //TestCase #3 Single digit - PASS
//        int[] digits = {4,3,2,9}; //TestCase #4 - LSB '9' - PASS
//        int[] digits = {9, 1, 2 , 3, 4}; //TestCase #5 - MSB '9' - PASS
        int[] digits = {8,9, 9,9};

       int[] result = plusOneFinder.plusOne(digits);
        System.out.print("The result is : ");
        Arrays.stream(result).forEach(System.out::print);
        System.out.println();
    }
}

/**
 * Approach :
 *  If the MSB is '9' then increase result size by 1.
 *  If not, result size is same as input array
 *  Use carryBit for each element.
 *  If element is '9' put '1' in the carryBit
 *
 *  For each element :
 *   - if element < 9 -> add one. carryBit = 0;
 *   - If element > 9 -> carry = 1.
 *   -
 *
 */
class PlusOneFinder {
    public int[] plusOne(int[] digits) {

        for(int loopIndex = digits.length-1; loopIndex >= 0; loopIndex--){
            if(digits[loopIndex] != 9){
                digits[loopIndex]++;
                break;
            }
            else {
                digits[loopIndex] = 0;
            }
        }

        if(digits[0] == 0){
            int[] newResult = new int[digits.length + 1];
            newResult[0] = 1;
            return newResult;
        }
        return digits;
    }
}