package com.algo.StringPractice;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String []str = {"abbb","a","accc","b"};
        String result = longestCommonPrefix.longestCommonPrefix(str);
//        String result = longestCommonPrefix.solution(str);
        System.out.println(result);
    }

    public int smallestString(String[] strs){
        int minLength = strs[0].length();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                index = i;
            }
        }

        return index;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
    private String solution(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }

        int smallestIdx = smallestString(strs);
        String smallest = strs[smallestIdx];

        int globalCommonSubstringCount = smallest.length();
        for(int j = 0; j<strs.length; j++) {
            if(j == smallestIdx) {
                continue;
            }
            int localCommonSubstringCount = 0;
            for (int i = 0; i < smallest.length(); i++) {
                if(strs[j].charAt(i) != smallest.charAt(i)) {
                    if(i == 0) {
                        return "";
                    }
                    break;
                }
                localCommonSubstringCount += 1;
            }

            if (localCommonSubstringCount <= globalCommonSubstringCount ) {
                globalCommonSubstringCount = localCommonSubstringCount;
            }
        }
        return smallest.substring(0,globalCommonSubstringCount);
    }
}
