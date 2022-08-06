package com.leetcode.practice.string;


/**
 *
 * @author Velmurugan Moorthy
 * @date 22.07.2022
 *
 * Problem Name : Valid Palindrome
 * Question link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
 * Problem description :
 *
 */
public class PalindromeDriver {
    public static void main(String[] args) {

    }
}

/**
 *
 Approach :

 1. Have 2 pointers (start & end)
 2. Check if the element is alphanumeric?
 3. If yes go ahead.
 4. If it's upper case, add (uppercase - lowercase) diff - add
 5. If it's number compare as it is.
 6. If not alphanumeric - move the pointer.
 7. At any point the values not matching @ start & end pointer - break the loop

 */
class PalindromeFinder {
    public boolean isPalindrome(String inputString) {

        int start = 0;
        int end = inputString.length() - 1;

        while(start < end){
            if(isAlphaNumeric(inputString, start) && isAlphaNumeric(inputString, end)){
            
            }
        }



        return false;
    }

    private boolean isAlphaNumeric(String inputString, int start) {
        return isAlphabet(inputString.charAt(start)) ||
               isNumeric(inputString.charAt(start));
    }

    private boolean isAlphabet(char inputChar){
       return isUpperCase(inputChar) || isLowerCase(inputChar);
    }

    private boolean isNumeric(char inputChar) {
        return inputChar >= 48 || inputChar <= 57;
    }

    private boolean isLowerCase(char inputChar) {
        return inputChar >= 97 || inputChar <= 122;
    }

    private boolean isUpperCase(char inputChar) {
        return inputChar >= 65 || inputChar <= 90;
    }
}
