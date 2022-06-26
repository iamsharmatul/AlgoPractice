package com.algo.ArrayPractice;

import java.util.Arrays;

public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int current = 0;
        int forward = current + 1;
        int uniqueElements = 1;

        while (forward < nums.length) {
            if (nums[current] != nums[forward]) {
                uniqueElements ++;
                current ++;
                nums[current] = nums[forward];
            }
            forward ++;
        }
        return uniqueElements;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        int k = removeDuplicate.removeDuplicates(nums);
        System.out.println("Array: "+Arrays.toString(nums)+" Has "+k+" Unique elements" );
    }
}
