package com.algo;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int [] nums = {5,6,7,10,2,1};
        System.out.println("Old: " + Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println("Sorted" + Arrays.toString(nums));
    }
}
