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

//        String inputString = "A man, a plan, a canal: Panama";//TestCase #1 - PASS
//        String inputString = "race a car";//TestCase #2 - Not palindrome PASS
//        String inputString = " ";//TestCase #3 - Empty space - PASS
//        String inputString = "   ";//TestCase #4 - Empty space - PASS
//        String inputString = "ABBA";//TestCase #5 - Upper case - even sized plaindrome - PASS
//        String inputString = "TUVWXYXWVUT";//TestCase #6 Upper case - odd sized palindrome - PASS
//        String inputString = "abcd";//TestCase #7 lower case - not palindrome - PASS
//        String inputString = "abracarba";//TestCase #8 lower case - palindrome
        String inputString = "Zeus was deified, saw Suez.";//TestCase #
//        String inputString = "";//TestCase #
//        String inputString = "";//TestCase #
//        String inputString = "";//TestCase #
//        String inputString = "";//TestCase #

        PalindromeFinder palindromeFinder = new PalindromeFinder();
        boolean isPalindrome = palindromeFinder.isPalindrome(inputString);
        System.out.println("Input is Palindrome : " + isPalindrome);
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
        char[] inputChars = inputString.toCharArray();
        int loopIndex = 0;
        while(loopIndex < inputChars.length){
            if(isUpperCase(inputChars[loopIndex])){
             inputChars[loopIndex] = (char) (inputChars[loopIndex] + 32);
            }
            loopIndex++;
        }

        while(start < end){
            if(isAlphaNumeric(inputChars[start]) && isAlphaNumeric(inputChars[end])){
                if(inputChars[start] != inputChars[end]){
                    return false;
                }
                else {
                    start++;
                    end--;
                    continue;
                }
            }
            if(!isAlphaNumeric(inputChars[start])){
                start++;
            }
            if(!isAlphaNumeric(inputChars[end])){
                end--;
            }
        }

        return true;
    }

    private boolean isAlphaNumeric(char inputString) {
        return isAlphabet(inputString) ||
               isNumeric(inputString);
    }

    private boolean isAlphabet(char inputChar){
       return isUpperCase(inputChar) || isLowerCase(inputChar);
    }

    private boolean isNumeric(char inputChar) {
        return inputChar >= 48 && inputChar <= 57;
    }

    private boolean isLowerCase(char inputChar) {
        return inputChar >= 97 && inputChar <= 122;
    }

    private boolean isUpperCase(char inputChar) {
        return inputChar >= 65 && inputChar <= 90;
    }
}
