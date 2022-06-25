package com.algo.ArrayPractice;

import java.util.Arrays;

public class FirstAndLastPosition {

    private Integer[] solution(Integer[] sampleArray, int target) {
        Integer []position = {-1, -1};
        boolean firstOccurrence = true;
        for (int i = 0; i < sampleArray.length; i++) {
            if(target == sampleArray[i] && firstOccurrence) {
                position[0] = i;
                firstOccurrence = false;
            } else if (target == sampleArray[i]) {
                position[1] = i;
            }
        }

        return position;
    }

    public static void main(String[] args) {
        Integer []sampleArray = {1,2,3,4,5,5,6,5,1};
        int target = 5;
        FirstAndLastPosition firstAndLastPosition = new FirstAndLastPosition();
        Integer []result = firstAndLastPosition.solution(sampleArray, target);
        System.out.println(Arrays.toString(result));
    }
}
