package com.leetcode.practice.string;

public class FirstUniqueCharDriver {
    public static void main(String[] args) {

        FirstUniqueCharFinder firstUniqueCharFinder = new FirstUniqueCharFinder();
//        String inputString = "leetcode"; //Test case #1 - PASS
//        String inputString = "loveleetcode"; //Test case #2 - PASS
        String inputString = "aabb"; //Test case #3 - PASS
//        String inputString = ""; //Test case #
//        String inputString = ""; //Test case #
//        String inputString = ""; //Test case #
        System.out.println("First unique char index is : " + firstUniqueCharFinder.firstUniqChar(inputString));
    }
}

class FirstUniqueCharFinder {
    public int firstUniqChar(String inputString) {

        int[] lowerCaseChars = new int[26];

        for(int loopIndex = 0; loopIndex < inputString.length(); loopIndex++){
            int charIndex = inputString.charAt(loopIndex) - 97;
                lowerCaseChars[charIndex]++;
        }

        for(int loopIndex = 0; loopIndex < inputString.length(); loopIndex++){
            if(lowerCaseChars[inputString.charAt(loopIndex) - 97] == 1){
                return loopIndex;
            }
        }
        return -1;
    }
}