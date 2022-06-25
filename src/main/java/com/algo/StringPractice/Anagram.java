package com.algo.StringPractice;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

    public boolean solution(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        HashMap<Character, Integer> firstStringccurrence = new HashMap<>();
        HashMap<Character, Integer> secondStringccurrence = new HashMap<>();

        computeOccurrence(s1, firstStringccurrence);

        computeOccurrence(s2, secondStringccurrence);

        for (char key : firstStringccurrence.keySet()) {
            if (firstStringccurrence.get(key) != secondStringccurrence.get(key)) {
                return false;
            }
        }

        return true;
    }

    public boolean sortingSolution(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        char [] firstString = s1.toCharArray();
        char [] secondString = s2.toCharArray();

        Arrays.sort(firstString);
        Arrays.sort(secondString);

        if (Arrays.equals(firstString,secondString)){
            return true;
        }
        return  false;
    }

    private void computeOccurrence(@NotNull String s2, HashMap<Character, Integer> StringOccurrence) {
        for (int i=0; i<s2.length();i++ ) {
            if(StringOccurrence.containsKey(s2.charAt(i))) {

                // StringOccurrence.put(s1.charAt(i), StringOccurrence.get(s1.charAt(i)) + 1);
                StringOccurrence.computeIfPresent(s2.charAt(i), (character, count) -> count + 1);
            } else {
                StringOccurrence.put(s2.charAt(i), 1);
            }
        }
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String s1 = "Danger";
        String s2 = "Garden";
        boolean result = anagram.solution(s1, s2);
        System.out.println("Given String is anagram -> " + result);
        result = anagram.sortingSolution(s1, s2);
        System.out.println("Given String is anagram -> " + result + " by using sorting solution");
    }
}
