package com.leetcode.practice.array;

import java.util.Arrays;

public class SandboxDriver {
    public static void main(String[] args) {

//        int[] nums = {0,1,0,3,12};//Test case #1 - PASS
//        int[] nums = {1,0,1};//Test case #1 - PASS
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        int zeroIndex=0;
        for(int loopIndex = 0; loopIndex < nums.length; loopIndex++){
            if(nums[loopIndex] != 0){
                int temp = nums[loopIndex];
                nums[loopIndex] = nums[zeroIndex];
                nums[zeroIndex++] = temp;
            }
        }


        Arrays.stream(nums).forEach(System.out::println);
    }
}


