package com.algo;

import java.util.Arrays;

public class FindMinPositiveInteger {

    public static int solution(int[] A) {
        int i;

        // Sort the array
        Arrays.sort(A);

        // Go through all the positive integers starting from 1 to the length of array
        for (i = 1; i <= A.length; i++) {
            // check if the positive integer i exist in array
            int integerIdx = Arrays.binarySearch(A,i);
            if(integerIdx < 0) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int []a = {1, 2, 3};

        int ans = solution(a);
        System.out.println(ans);

    }
}
