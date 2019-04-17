package ru.roman.algo.tree;

class Node {
    final int value;
    Node left, right;

    Node(int value) {
        this(value, null, null);
    }

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
