package com.leetcode.practice.array;

/**
 * @author Vel
 * @date 03.08.2022
 *
 * Problem name : Best Time to Buy and Sell Stock II
 * Problem link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
 *
 */
public class StockProfitCalculatorDriverV2 {
    public static void main(String[] args) {

//        int[] prices = {7,1,5,3,6,4};//Test case #1 - PASS
//        int[] prices = {1,2,3,4,5};//Test case #2 - PASS
        int[] prices = {7,6,4,3,1};//Test case #3 - No sale possible- PASS
//        int[] prices = {};//Test case #
//        int[] prices = {};//Test case #
//        int[] prices = {};//Test case #


        StockProfitCalculator stockProfitCalculator = new StockProfitCalculator();
        int maxProfit = stockProfitCalculator.maxProfit(prices);

        System.out.println("Max profit is : " + maxProfit);

    }
}

class StockProfitCalculator {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if(days == 0){
            return 0;
        }

        int lastPurchase = -prices[0];
        int lastSell = 0;

        for(int currentDay = 1; currentDay < days; currentDay++){

            int currentPurchase = Math.max(lastPurchase, lastSell - prices[currentDay]);
            int currentSell = Math.max(lastSell, lastPurchase + prices[currentDay]);
            lastPurchase = currentPurchase;
            lastSell = currentSell;
        }
     return lastSell;
    }
}
