package com.algo.StringPractice;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstringWithoutRepetition(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Store character with its position
        Map<Character, Integer> hm = new HashMap<>();

        int start = 0, end = 0, maxLength = 0;

        while (end < s.length()) {
            if (hm.containsKey(s.charAt(end))) {
                // slide the start of the window
                start = Math.max(start, hm.get(s.charAt(end)) + 1);
            }

            hm.put(s.charAt(end), end);
            end++;

            // MaxLengthOfSubstring
            int currentWindowLength = end - start;
            maxLength = Math.max(maxLength, currentWindowLength);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int result = lengthOfLongestSubstring.lengthOfLongestSubstringWithoutRepetition(s);
        System.out.println("Length: "+ result);
    }
}
