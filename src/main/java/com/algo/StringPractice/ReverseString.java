package com.algo.StringPractice;

import java.util.Arrays;

public class ReverseString {

    private String solution(char []charArr) {
        // base case
        if(charArr==null || charArr.length == 0) {
            return "";
        }

        //define pointers
        int start=0, end=charArr.length - 1;

        // start swapping
        while (start <= end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;

            start++;
            end--;
        }

        return Arrays.toString(charArr);
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();

        char []s = {'h','e', 'l','l','o'};
        String result = reverseString.solution(s);
        System.out.println(result);
    }

}
