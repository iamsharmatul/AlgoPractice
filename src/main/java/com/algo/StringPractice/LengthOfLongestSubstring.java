package com.algo.StringPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int withAtMostKRepetition(String s, int k) {
        // Base Case
        if(s == null || s.length()==0){
            return 0;
        }
        //Define dictionary or hashmap
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        // Define maxLen and pointers
        int start=0, end=0, maxLength=0;
        char []chrArr = s.toCharArray();

        // Find the longest substring
        while (end < chrArr.length) {
            characterIntegerHashMap.put(chrArr[end],characterIntegerHashMap.getOrDefault(chrArr[end],0) + 1);

            while (characterIntegerHashMap.size() > k) {
                characterIntegerHashMap.put(chrArr[start], characterIntegerHashMap.get(chrArr[start]) - 1);

                if (characterIntegerHashMap.get(chrArr[start]) == 0) {
                    characterIntegerHashMap.remove(chrArr[start]);
                }
                start++;
            }

            // compute maxLength
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }

    public int withAtLeastKRepetition(String s, int k) {
        int []alphabetOccurrenceArray = new int[26];
        char []chr = s.toCharArray();
        int maxLength=0;

        for (int uniqueCharacter = 1; uniqueCharacter <= 26; uniqueCharacter++) {
            Arrays.fill(alphabetOccurrenceArray, 0);

            int start=0, end = 0, unique=0, kUnique=0;
            while(end < chr.length){
                if(unique <= uniqueCharacter) {
                    int idx = chr[end] - 'a';

                    if (alphabetOccurrenceArray[idx] == 0) {
                        unique++;
                    }
                    ++alphabetOccurrenceArray[idx];

                    if (alphabetOccurrenceArray[idx] == k) {
                        kUnique++;
                    }
                    end++;
                }else {
                    int idx = chr[start] - 'a';

                    if (alphabetOccurrenceArray[idx] == k) {
                        kUnique--;
                    }
                    --alphabetOccurrenceArray[idx];

                    if (alphabetOccurrenceArray[idx] == 0) {
                        --unique;
                    }

                    start++;
                }

                if(unique == uniqueCharacter && kUnique == unique) {
                    int currentWindowLength = end - start;
                    maxLength = Math.max(maxLength, currentWindowLength);
                }
            }
        }

        return maxLength;
    }

    public int withoutRepetition(String s) {
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
        String s = "aa";
        int k = 1;
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int result = lengthOfLongestSubstring.withoutRepetition(s);
        int result2 = lengthOfLongestSubstring.withAtLeastKRepetition(s, k);
        int result3 = lengthOfLongestSubstring.withAtMostKRepetition(s, k);

        System.out.println("Length: "+ result3);
    }
}
