package com.algo.ArrayPractice;

import java.util.HashMap;
import java.util.List;

public class BuyAndSellStocks {

    private int maxProfitWithMultipleTransaction(int[] prices) {
        // Solve it using hill valley approach
        // sum of differences between (valley - hill) returns the maximum profit.

        int profit = 0;
        for (int nextDay = 1; nextDay < prices.length; nextDay++) {
            int currentDay = nextDay - 1;

            // Make transaction only when price of current day is lower than next day
            if (prices[currentDay] < prices[nextDay]) {
                profit += prices[nextDay] - prices[currentDay];
            }
            // Skip when the next day price is lower than current day
        }
        return profit;
    }
    private int maxProfitWithOneTransaction(int[] prices) {
        int maxProfit = 0;
        int globalMinIdx = 0;
        int localProfit;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[globalMinIdx]) {
                globalMinIdx = i;
            }
            if (prices[i] > prices[globalMinIdx]) {
                localProfit = prices[i] - prices[globalMinIdx];
                maxProfit = Math.max(maxProfit, localProfit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int []prices = {7,1,5,3,6,4};
        BuyAndSellStocks buyAndSellStocks = new BuyAndSellStocks();
        int result = buyAndSellStocks.maxProfitWithOneTransaction(prices);
        int result2 = buyAndSellStocks.maxProfitWithMultipleTransaction(prices);
        System.out.println("Maximum profit with One Transaction: " + result);
        System.out.println("Maximum profit with Multiple Transactions: " + result2);
    }
}
