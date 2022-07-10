package com.algo.TreePractice;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    Node root = null;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    void printPreorder(Node node) {
        if (node == null ) {
            return;
        }
        System.out.print(node.data);
        printPostorder(node.left);
        printPostorder(node.right);
    }
    void printInorder(Node node) {
        if (node == null ) {
            return;
        }
        printPostorder(node.left);
        System.out.print(node.data);
        printPostorder(node.right);
    }
    void printPostorder(Node node) {
        List<Integer> result = new ArrayList<>();

        if (node == null ) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data);
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        // level 0
        binaryTree.root = new Node(1);

        // level 1
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);

        // level 2
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);

        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(7);

        System.out.println("Printing Tree PreOrder");
        binaryTree.printPreorder(binaryTree.root);

        System.out.println("\n Printing Tree InOrder");
        binaryTree.printInorder(binaryTree.root);

        System.out.println("\n Printing Tree PostOrder");
        binaryTree.printPostorder(binaryTree.root);

        System.out.println("\nMax Depth: " + binaryTree.maxDepth(binaryTree.root));

    }
}
