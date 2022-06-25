package com.algo;

public class FrogJump {
    public static int solution(int []blocks) {
        int maxJumpDistance = 0;

        int n = blocks.length;
        int []forward = new int[n];
        int []backward = new int[n];

        // Traverse in forward direction and find the valleys
        forward[0] = 0;
        for (int i = 1; i < n; i++) {
            if (blocks[i] <= blocks[i - 1]) {
                forward[i] = forward[i-1] + 1;
            } else {
                forward[i] = 0;
            }
        }

        // Traverse in backward direction and count the valleys
        backward[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (blocks[i] <= blocks[i + 1]) {
                backward[i] = backward[i + 1] + 1;
            } else {
                backward[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            maxJumpDistance = Math.max(maxJumpDistance, forward[i] + backward[i] + 1);
        }

        return maxJumpDistance;
    }

    public static void main(String[] args) {
        //int []blocks = {2,6,8,5};
        //int []blocks = {1,5,5,2,6};
        int []blocks = {1,1};
        int result = solution(blocks);
        System.out.println(result);
    }
}
