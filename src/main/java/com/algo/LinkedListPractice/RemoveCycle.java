package com.algo.LinkedListPractice;

public class RemoveCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static class Solution {
        Solution() {

        }

        public boolean hasCycle(ListNode head) {
            ListNode forward = head.next;
            ListNode current = head;
            ListNode backward = null;

            while(current != null) {
                if (forward == backward) {
                    return true;
                }

                backward = current;
                current = forward;
                forward = forward.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(2);
        boolean result = solution.hasCycle(listNode);
        System.out.println(result);
    }
}
