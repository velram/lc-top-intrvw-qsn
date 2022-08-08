package com.leetcode.practice.string;

/**
 * @author vel
 * @date 08.05.2022
 * Problem link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/
 * Problem name : Valid Anagram
 *
 */
public class AnagramDriver {
    public static void main(String[] args) {

        //Test case #1 - Happy flow - PASS
//        String firstString = "anagram";
//        String secondString = "nagaram";

        //Test case #2 - Not matching
//        String firstString = "rat";
//        String secondString = "car";

        //Test case #
        String firstString = "nl";
        String secondString = "cx";

        //Test case #
//        String firstString = "";
//        String secondString = "";

        AnagramFinder anagramFinder = new AnagramFinder();
        boolean isAnagram = anagramFinder.isAnagram(firstString, secondString);

        System.out.println("isAnagram : " + isAnagram);

    }
}

/**
 * Approach :
 *
 * 1. If two str length same - continue. If not break & return false - DONE
 * 2. Create two array of letters to count frequency
 * 3. Use a loop to count frequency of both arrays
 * 4. After populating the array, iterate thru frequency array
 * 5. If any element is mismatching break the loop & return false;
 */

class AnagramFinder {
    public boolean isAnagram(String firstString, String secondString) {

        if(firstString.length() != secondString.length()){
            return false;
        }

        int[] firstArrayFrequencyCount = new int[26];
        int[] secondArrayFrequencyCount = new int[26];

        for(int loopIndex = 0; loopIndex < firstString.length(); loopIndex++){
            firstArrayFrequencyCount[firstString.charAt(loopIndex) - 97]++;
            secondArrayFrequencyCount[secondString.charAt(loopIndex) - 97]++;
        }

        for(int loopIndex = 0; loopIndex < firstArrayFrequencyCount.length; loopIndex++){
            if(firstArrayFrequencyCount[loopIndex] != secondArrayFrequencyCount[loopIndex]){
                return false;
            }
        }

        return true;
    }
}