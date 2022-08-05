package com.leetcode.practice.string;

import java.util.Arrays;

/**
 * @author vel
 * @date 05.08.2022
 * Problem link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 * Problem name : Reverse String
 *
 */
public class StringReversalDriver {
    public static void main(String[] args) {

//        char[] input = {'h','e','l','l','o'};//TestCase #1 - Happy flow - PASS
//        char[] input = {'e'};//TestCase #2 - sing element - PASS
        char[] input = {'a', 'b'};//TestCase #3 even no.of elements - PASS
//        char[] input = {};//TestCase #
//        char[] input = {};//TestCase #
//        char[] input = {};//TestCase #
//        char[] input = {};//TestCase #

        System.out.println("Before reversal, string is : ");
        printCharArray(input);

        StringReverser stringReverser = new StringReverser();
        stringReverser.reverseString(input);
        System.out.println("\nReversed string is : ");
        printCharArray(input);

    }

    private static void printCharArray(char[] input) {
        for(char element : input){
            System.out.print(element);
        }
    }
}

class StringReverser {
    public void reverseString(char[] s) {

        int start = 0;
        int end = s.length - 1;

        while(start < end ){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }
}