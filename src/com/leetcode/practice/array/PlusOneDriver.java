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
 */
public class PlusOneDriver {
    public static void main(String[] args) {

        PlusOneFinder plusOneFinder = new PlusOneFinder();
        int[] digits = {}; //TestCase #
//        int[] digits = {}; //TestCase #
//        int[] digits = {}; //TestCase #
//        int[] digits = {}; //TestCase #
       int[] result = plusOneFinder.plusOne(digits);
        Arrays.stream(result).forEach(System.out::println);
    }
}

class PlusOneFinder {
    public int[] plusOne(int[] digits) {

        
        return null;
    }
}