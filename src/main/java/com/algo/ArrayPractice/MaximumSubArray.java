package com.algo.ArrayPractice;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int localSum = 0;
        int globalsum = nums[0];

        for (int num : nums) {

            // Reset the local sum whenever it goes below 0
            if (localSum < 0) {
                localSum = 0;
            }

            // Add all the elements sequentially
            localSum += num;

            // compare if we have found new globalSum
            globalsum = Math.max(localSum, globalsum);
        }
        return globalsum;
    }

    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int result = maximumSubArray.maxSubArray(nums);
        System.out.println("Sum: " + result);
    }
}
