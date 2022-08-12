package com.leetcode.practice.array;

import java.util.Arrays;

public class ZeroMovingDriver {
    public static void main(String[] args) {

        ZeroMover zeroMover = new ZeroMover();
//        int[] nums = {0,1,0,3,12};//Test case #1 - Happy flow - PASS
//        int[] nums = {0};//Test case #2 - Single elemen array - PASS
//        int[] nums = {1,0};//Test case #3  two element array - PASS
//        int[] nums = {0,1};//Test case #4 - two element array - PASS
//        int[] nums = {1,2,3,4,5,6,7,0,0,0,0,0};//Test case #5 zeros @ end - PASS
//        int[] nums = {0,0,0,0,0,1,2,3,4,5,6,7};//Test case #6 - zeros @ start - PASS
        int[] nums = {1,2,3,4,5,0,0,0,0,0,6,7,8,9,10};//Test case #7 zeros @ middle - PASS
//        int[] nums = {};//Test case #
//        int[] nums = {};//Test case #

        zeroMover.moveZeroes(nums);
        System.out.println("Array after moving zeros");
        Arrays.stream(nums).forEach(System.out::println);
    }
}

class ZeroMover {
    public void moveZeroes(int[] nums) {

        int zeroIndex = 0;
        for(int loopIndex = 0; loopIndex < nums.length; loopIndex++){
            if(nums[loopIndex] != 0){
                int temp = nums[loopIndex] ;
                nums[loopIndex] = nums[zeroIndex];
                nums[zeroIndex++] = temp;
            }
        }

    }
}