package com.leetcode.practice.array;

import java.util.Arrays;

public class RemoveDuplicatesDriver {
    public static void main(String[] args) {

    DuplicateRemover duplicateRemover = new DuplicateRemover();
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; //Test case #1 - PASS
//        int[] nums = {1,1,2}; //Test case #2 - minimal numbers - PASS
//        int[] nums = {1}; //Test case #3 - No duplicates - PASS
//        int[] nums = {8,8,8,8,8,8,8}; //Test case #4 - All duplicates - PASS
//        int[] nums = {1,2,3,4,5,6,7,7}; //Test case #5 - Last two elements duplicates - PASS
//        int[] nums = {1, 1, 2,3,4,5,6}; //Test case #6 - First two elements duplicates - PASS
//        int[] nums = {}; //Test case #
//        int[] nums = {}; //Test case #
        int result = duplicateRemover.removeDuplicates(nums);
        System.out.println("Duplicate count : " + result + " \n");
        System.out.println("Array elements : " );
        Arrays.stream(nums).forEach(System.out::println);

    }
}

class DuplicateRemover {
    public int removeDuplicates(int[] nums) {

        int index = 0;

        for(int currentElement : nums) {
          if(index == 0 || currentElement > nums[index - 1])  {
              System.out.println("Index : " + index + " currentElement : " + currentElement);
              nums[index++] = currentElement;
          }
        }
        return index;
    }
}
