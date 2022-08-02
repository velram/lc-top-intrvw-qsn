package com.leetcode.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author Velmurugan
 * @date 02.08.2022
 * Question link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
 *
 * Problem name : Intersection of Two Arrays II
 */
public class ArrayIntersectionDriverV2 {
    public static void main(String[] args) {

        ArrayIntersectionFinder arrayIntersectionFinder = new ArrayIntersectionFinder();
        //Test case #1 - Happy flow - PASS
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        //Test case #2 - PASS
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};

        //Test case #3 - No intersection - PASS
//        int[] nums1 = {1,2};
//        int[] nums2 = {3,4};

        //Test case #4 - all elements are same - PASS
//        int[] nums1 = {34, 34, 34, 34};
//        int[] nums2 = {34, 34, 34, 34};


        //Test case #5 nums1.size < nums2.size - PASS
//        int[] nums1 = {1,2,3,4};
//        int[] nums2 = {3,4,5,6,7,8};

        //Test case #
//        int[] nums1 = {};
//        int[] nums2 = {};

        //Test case #
//        int[] nums1 = {};
//        int[] nums2 = {};

       int[] result = arrayIntersectionFinder.intersect(nums1, nums2);
        System.out.println("Array intersection is : ");
        if(null == result){
            System.out.println("No intersection found");
            return;
        }
        Arrays.stream(result).forEach(System.out::println);
    }
}

class ArrayIntersectionFinder {
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] frequency1 = new int[1001];
        int[] frequency2 = new int[1001];

        for(int loopIndex = 0; loopIndex < nums1.length; loopIndex++){
            frequency1[nums1[loopIndex]]++;
        }

        for(int loopIndex = 0; loopIndex < nums2.length; loopIndex++){
            frequency2[nums2[loopIndex]]++;
        }

        int resultSize = 0;
        for(int loopIndex = 0; loopIndex < 1001; loopIndex++){
           int frequency = Math.min(frequency1[loopIndex], frequency2[loopIndex]);
           if(frequency > 0){
               resultSize += frequency;
           }
       }
        int[] result = new int[resultSize];
        if(resultSize == 0){
            return new int[0];
        }
        int resultIndex = 0;
        for(int loopIndex = 0; loopIndex < 1001; loopIndex++){
            int frequency = Math.min(frequency1[loopIndex], frequency2[loopIndex]);
            if(frequency > 0){
                int duplicateCount = 1;
                while(duplicateCount <= frequency){
                    result[resultIndex++] = loopIndex;
                    duplicateCount++;
                }
            }
        }

        //System.out.println("Result array size : " + resultSize);
        return result;
    }

}