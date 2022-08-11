package com.leetcode.practice.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vel
 * @date 11.08.2022
 * Question link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/
 * Problem statement :
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 *     Read in and ignore any leading whitespace.
 *     Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 *     Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 *     Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 *     If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 *     Return the integer as the final result.
 *
 * Note:
 *
 *     Only the space character ' ' is considered a whitespace character.
 *     Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 *     Example 1:
 *
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 *
 * Example 2:
 *
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -42" ("42" is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 *
 * Example 3:
 *
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 *              ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 *
 *
 *
 * Constraints:
 *
 *     0 <= s.length <= 200
 *     s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */
public class IntegerConversionDriver {
    public static void main(String[] args) {

//        String input = "1234";//Test case #1 - Happy flow - positive int - PASS
//        String input = "-54321";//Test case #2 - Negative int - PASS
//        String input = "   7890";//Test case #3 - leading spaces - PASS
//        String input = "4567890    ";//Test case #4 trailing spaces - PASS
//        String input = "000000000034";//Test case #5 - leading zeroes - PASS
//        String input = "156323 2342343";//#Test case #6 - spaces in middle - PASS
//        String input = "83937abcdef";//Test case #7 Trailing Non digit chars - PASS
//        String input = "abcdef83939";//Test case #8 Leading non-digit chars - PASS
//        String input = "2343773abcde8989";//Test case #9 - non-digit chars in mid - PASS
//        String input = "   -42";//Test case #10 - leading spaces & negative int - PASS
//        String input = "   +42";//Test case #10 leading spaces with '+' - PASS
//        String input = "+938383938";//Test case #11 - leading '+' positive int - PASS
//        String input = "2147483647";//Test case #12 Integer.MAX - PASS
//        String input = "-2147483648";//Test case #13 Integer.MIN - PASS
        String input = "21474836460";//Test case #13 greater than INT.MAX - PASS
//        String input = "-2147483699";//Test case #14 lesser than INT.MIN - PASS
//        String input = "+-12";//Test case #
//        String input = "";//Test case #
//        String input = "";//Test case #
//        String input = "";//Test case #

        StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter();

        System.out.println("Converted integer is : " + stringToIntegerConverter.myAtoi(input));
    }
}

class StringToIntegerConverter {
    public int myAtoi(String input) {

        boolean firstDigitEncountered = false;
        boolean firstNonZeroEncountered = false;
        boolean isPositive = true;
        boolean signCharFound = false;

        List<Integer> extractedDigits = new ArrayList<>();

        for(char currentElement : input.toCharArray()){
            //System.out.println("current element is : " + currentElement);
            if(currentElement == ' ' && !firstDigitEncountered){
                continue;
            }
            if(currentElement == '0' && !firstNonZeroEncountered){
                continue;
            }
            if(!signCharFound && currentElement == '-'){
                isPositive = false;
                signCharFound = true;
                continue;
            }
            else if(!signCharFound && currentElement == '+'){
                signCharFound = true;
                continue;
            }

            if(isDigit(currentElement)){
                if(!firstDigitEncountered){
                    firstDigitEncountered = true;
                    if(firstDigitEncountered && currentElement != '0'){
                        firstNonZeroEncountered = true;
                    }
                }
                extractedDigits.add(currentElement - '0');
            }
            else {
                break;
            }
        }

        return computeResult(extractedDigits, isPositive);
    }

    private int computeResult(List<Integer> extractedDigits, boolean isPositive) {

        long result = 0;
        int tenPower = 0;

        for(int loopIndex = extractedDigits.size() - 1; loopIndex >=0;  loopIndex--){
            if(!isPositive){
                result += extractedDigits.get(loopIndex) * (long) Math.pow(10, tenPower++) * (-1);
            }
            else {
                result += extractedDigits.get(loopIndex) * (long) Math.pow(10, tenPower++);
            }
            if(result < Integer.MIN_VALUE){
                int difference = (int) result + Integer.MIN_VALUE;
                result = result - difference;
                return (int) result;
            }
            else if(result > Integer.MAX_VALUE){
             int difference = (int) result - Integer.MAX_VALUE;
             result = result - difference;
             return (int) result;
            }
        }

        return (int) result;
    }

    public boolean isDigit(char inputChar){
        return inputChar >= '0' && inputChar <= '9';
    }
}