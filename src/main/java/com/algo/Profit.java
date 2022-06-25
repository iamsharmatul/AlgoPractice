package com.algo;

public class Profit {
    public static void main(String[] args) {
        int [] prices = {7,6,4,3,1};

        int max_profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // Consider only peaks
            if (prices[i] > prices[i - 1]) {
                max_profit += prices[i] - prices[i - 1];
            }
        }
        System.out.println(max_profit);
    }
}
