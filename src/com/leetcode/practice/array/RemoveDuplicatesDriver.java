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

/*
Approach :

 Sub-tasks :
  - Find duplicates - DONE
  - remove duplicates (replace with values) - DONE
  - re-arrange the values - WIP

 -----------------
  1. Find duplicates (use 2 pointers)
      - Since it's sorted it'll be easy & adjacent elements will be duplicates
      - Pickup the 1st element (1st pointer)
      - Move the second pointer
      - if 2nd pointer has same elements -
      - replace it with a flag value (lyk underscore)
      - increase the duplicate count

  2. Re-arrange values :
      - Do another iteration (after identifying duplicates)
      - Now, start with where there's a duplicate - 1st pointer
      - Move 2nd pointer
      - Find where there's an integer.
      - Swap those two elements.
      - Move 1st pointer to the next index of 2nd pointer

      Note : Handle the index overflow
 */
class DuplicateRemover {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 1){
            return 0;
        }

        int duplicateCount = replaceDuplicateValues(nums);
        int start = 0;
        int end = 1;

        while(start < nums.length - 1 && end < nums.length){
            if(nums[start] == -1000 && nums[end] != -1000){
                swap(nums, start, end);
                start++;
                end ++;
            }
            else if(nums[start] != -1000){
                start++;
                end++;
            }
            else if(nums[end] == -1000){
                end++;
            }
        }

        return duplicateCount;
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }


    private int replaceDuplicateValues(int[] nums) {
        int start = 0;
        int end = 1;
        int duplicateCount = 0;
        while(start < nums.length - 1 && end < nums.length){
            if(nums[start] != -1000 && nums[start] == nums[end] ){
                nums[end] = -1000;
                end++;
                duplicateCount++;
            }
            else if (nums[start] != nums[end]){
                start = end;
                end++;
            }
        }
        return duplicateCount;
    }
}
