package com.algo;

public class MaxNumber {
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,5,1,2,2,3,3,4};
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        System.out.println("Maximum number: " + max);
    }
}
