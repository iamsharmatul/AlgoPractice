package com.algo;

import java.util.*;

public class BinaryRepresentation {
    public static int solution(int A, int B) {
        int activeBits = 0;
        int multiplicationResult = A * B;
        // Conversion of Integer to Binary representation
        String binaryString = Integer.toBinaryString(multiplicationResult);
        System.out.println(binaryString);

        // Split the string into a character array
        String []binaryCharacterArray = binaryString.split("");

        // Look for bits that are set to 1 in the charater
        for (String bit: binaryCharacterArray) {
            if(bit.equals("1")) {
                activeBits ++;
            }
        }

        return activeBits;
    }

    public static void main(String[] args) {
        int result = solution(10,2);
        System.out.println(result);
    }
}
