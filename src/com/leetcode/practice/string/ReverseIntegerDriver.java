package com.leetcode.practice.string;

/**
 * @author vel
 * @date 09.08.2022
 * Problem name : Reverse integer
 * Problem link :
 */
public class ReverseIntegerDriver {
    public static void main(String[] args) {

        int input = 123;//Test case #1 - happy flow - PASS
//        int input = 12345678;//Test case #2 Larger int (+ve) - PASS
//        int input = Integer.MAX_VALUE; //Test case #3 - Integer MAX value
//        int input = Integer.MIN_VALUE;//Test case #4 Integer min value - PASS
//        int input = -123;//Test case #5 - smaller (-ve value)  - PASS
//        int input = -12345678;//Test case #6 larger -ve value - PASS
//        int input = 2147447412;//Test case #7 - Max possible reverse integer (+ve) - PASS
//        int input = -2147447412;//Test case #8 - Max possible reverse integer (-ve) - PASS
//        int input = 2147447413;//Test case #9 - Threshold test - not reversible (+ve) - PASS
//        int input = -2147447413;//Test case #9 Threshold test - not reversible (-ve) - PASS
//        int input = 120;//Test case #
        //int input = ;//Test case #

//        System.out.println("Division");
//        System.out.println("100M : " + (input / 1000000000));
//        System.out.println("10M  : " + (input / 100000000) % 10);
//        System.out.println("1M   : " + (input / 10000000) % 10);
//        System.out.println("100K : " + (input / 1000000) % 10);
//        System.out.println("10K  : " + (input / 10000) % 10);
//        System.out.println("1K   : " + (input / 1000) % 10);
//        System.out.println("100  : " + (input / 100) % 10);
//        System.out.println("tens : " + (input / 10) % 10);
//        System.out.println("ones : " + (input / 1) % 10);

        ReverseIntegerFinder reverseIntegerFinder = new ReverseIntegerFinder();
        System.out.println("Input is : " + input + " | Reversed integer is : " + reverseIntegerFinder.reverse(input));
        System.out.println("lesser than : " + (Integer.MIN_VALUE < -21477412));
    }
}

/**
 *
 1. If number is zero or not-reversible - return zero
 2. Calculate the weights to power of tens - Use that number to find new result
 3. if modulo is > 0 then store it to the result
 4. Use two pointer to keep track of ten powers.
 5. If value is negative - multiply -1 with the values
 6. Return final zero.
 */
class ReverseIntegerFinder {
    public int reverse(int input) {

       long result = 0;
       while(input != 0){
           result = (result * 10) + (input % 10);
           input = input / 10;
           if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
               return 0;
           }
       }

       return (int) result;
    }
}