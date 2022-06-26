package com.algo.ArrayPractice;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char lastCharacter;
        Stack<Character> characterStack = new Stack<>();

        if (s.length() == 1) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(', '[', '{' -> characterStack.push(s.charAt(i));
                case ')' -> {
                    if (characterStack.isEmpty()) return false;
                    lastCharacter = characterStack.pop();
                    if (lastCharacter != '(') return false;
                }
                case ']' -> {
                    if (characterStack.isEmpty()) return false;
                    lastCharacter = characterStack.pop();
                    if (lastCharacter != '[') return false;
                }
                case '}' -> {
                    if (characterStack.isEmpty()) return false;
                    lastCharacter = characterStack.pop();
                    if (lastCharacter != '{') return false;
                }
                default -> throw new IllegalStateException("Unexpected value: " + s.charAt(i));
            }
        }
        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "){";
        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid(s);
        System.out.println("Given String " + s + " has validParentheses : " +  result);
    }
}
