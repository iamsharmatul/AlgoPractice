package com.algo.StringPractice;

public class LongestPalindromicString {
    public static void main(String[] args) {
        LongestPalindromicString longestPalindromicString = new LongestPalindromicString();
        String s = "ababa";
        int result = longestPalindromicString.solution(s);
        System.out.println(result);
    }

    private int solution(String s) {
        // base case
        if (s==null || s.length()==0){
            return 0;
        }

        // define pointers
        int start = 0, end = 0;
        char []chrArr = s.toCharArray();

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += helper(s, i, i);
            result += helper(s, i, i + 1);
        }

        return result;
    }

    private int helper(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++count;
            --left;
            ++right;
        }

        return count;
    }
}
