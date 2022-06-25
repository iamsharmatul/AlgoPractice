package com.algo;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int  k = 3;
        int temp = k;
        int i;
        int [] nums = {1,2,3,4,5,6,7};
        int [] rotated_array = new int[nums.length];
        int start_idx = 0;
        int end_idx = nums.length - 1;

        if (k >= nums.length) {
            throw new RuntimeException("K out of bounds");
        }

        for (i = 0; i < k; i++) {
            rotated_array[i] = nums[end_idx - temp];
            temp--;
        }
        System.out.println(Arrays.toString(rotated_array));

        for (int j = 0; j <= nums.length - i; j++) {
            rotated_array[k-1] = nums[j];
            k++;
        }
        System.out.println(Arrays.toString(rotated_array));
    }
}
