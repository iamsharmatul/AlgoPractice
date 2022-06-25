package com.algo;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = 1;
        System.out.println(Arrays.toString(nums));
        int j;
        for (int i = 0; i < (nums.length - 1); i++) {
            // search for unique number
            for (j = i+1; j <= (nums.length - 1); j++) {
                if(nums[j] > nums[i]) {
                    k++;
                    break;
                }
            }
            if(nums.length == j) {
                nums[i+1] = nums[j-1];
            }else {
                nums[i+1] = nums[j];
            }

        }
        System.out.println("Array: "+Arrays.toString(nums)+" Has "+k+" Unique elements" );
    }
}
