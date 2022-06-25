package com.algo.LinkedListPractice;

class MyLinkedList {
    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
    }

    public int get(int index) {
        Node temp = this.head;
        for(int i=0; i<index; i++) {
            if (temp == null) {
                return -1;
            }
            temp = temp.next;
        }
        if(temp==null){
            return -1;
        }

        int result = temp.val;
        return result;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        newNode.next = this.head;
        this.head = newNode;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node temp = this.head;
        if(head == null) {
            this.head = newNode;
            return;
        }

        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        Node slow = this.head;
        Node newNode = new Node(val);

        if (index == 0) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        for(int i=1; i<=index-1; i++) {
            if (slow == null) {
                return;
            }
            slow = slow.next;
        }
        Node fast = slow.next;
        slow.next = newNode;
        newNode.next = fast;
    }

    public void deleteAtIndex(int index) {
        Node slow = this.head;
        if (slow == null) {
            return;
        }

        if (index == 0) {
            this.head = this.head.next;
            return;
        }

        for(int i=1; i<=index-1 && slow.next != null; i++) {
            slow = slow.next;
        }

        if (slow.next == null) {
            return;
        }

        Node fast = slow.next;
        slow.next = fast.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
        myLinkedList.get(5);
        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
