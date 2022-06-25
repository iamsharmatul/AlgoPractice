package com.algo.LinkedListPractice;

public class SinglyLinkedList {
    Node head;

    class Node {
        int data;
        Node next = null;

        Node(){
            data = 0;
            next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Integer [] items = {1,2,3,2,5,6};
        for (int item : items) {
            singlyLinkedList.head = singlyLinkedList.addItemToLinkedList(item, singlyLinkedList.head);
        }
        singlyLinkedList.printLinkedList(singlyLinkedList.head);
        singlyLinkedList.hasCycle(singlyLinkedList.head);
    }

    public boolean hasCycle(Node head) {
        Node fast = head.next;
        Node slow = null;
        Node current = head;

        while(fast != null) {
            if(slow == fast) {
                System.out.println("Cycle Found");
                return true;
            }

            slow = current;
            current = current.next;
            fast = fast.next;
        }
        System.out.println("Cycle Not Found");
        return false;
    }

    public void printLinkedList(Node head) {
        Node temp = head;
        while (temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public SinglyLinkedList createList(int size, Integer[] items) {
        Node head = new Node(items[0]);
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        if(singlyLinkedList.head == null) {
            singlyLinkedList.head = head;
        }

        Node temp = singlyLinkedList.head;
        for (int item : items) {
            Node newNode = new Node(item);
            temp.next = newNode;
            temp = newNode;

        }

        return singlyLinkedList;
    }

    public Node addItemToLinkedList(int item, Node head) {
        Node temp = head;
        Node node = new Node(item);

        if (temp == null) {
            head = node;
            return head;
        }

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }
}
