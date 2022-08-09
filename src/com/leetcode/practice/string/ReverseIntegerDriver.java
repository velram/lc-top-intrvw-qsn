package com.leetcode.practice.string;

/**
 * @author vel
 * @date 09.08.2022
 * Problem name : Reverse integer
 * Problem link :
 */
public class ReverseIntegerDriver {
    public static void main(String[] args) {

        //int input = 123456789;//Test case #
        int input = Integer.MAX_VALUE; //Test case # - Integer MAX value
//        int input = Integer.MIN_VALUE;//Test case #
        //int input = ;//Test case #
        //int input = ;//Test case #
        //int input = ;//Test case #
        //int input = ;//Test case #
        //int input = ;//Test case #

        System.out.println("Division");
        System.out.println("100M : " + (input / 1000000000));
        System.out.println("10M  : " + (input / 100000000) % 10);
        System.out.println("1M   : " + (input / 10000000) % 10);
        System.out.println("100K : " + (input / 1000000) % 10);
        System.out.println("10K  : " + (input / 10000) % 10);
        System.out.println("1K   : " + (input / 1000) % 10);
        System.out.println("100  : " + (input / 100) % 10);
        System.out.println("tens : " + (input / 10) % 10);
        System.out.println("ones : " + (input / 1) % 10);
    }
}

class ReverseIntegerFinder {
    public int reverse(int x) {



        return 0;
    }
}