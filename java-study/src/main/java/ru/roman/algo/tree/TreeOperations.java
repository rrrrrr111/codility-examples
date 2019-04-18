package ru.roman.algo.tree;

import java.util.IdentityHashMap;
import java.util.Map;

class TreeOperations {


    static int countNodes(Node root) {
        if (root == null)
            return 0;
        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);
        return count;
    }

    static String traverseInOrder(Node node) {
        StringBuilder sb = new StringBuilder(100);
        traverseInOrder(node, sb);
        return sb.toString();
    }

    static void traverseInOrder(Node node, StringBuilder sb) {
        if (node != null) {
            traverseInOrder(node.left, sb);
            sb.append(node.value).append(", ");
            traverseInOrder(node.right, sb);
        }
    }

    static String traversePreOrder(Node node) {
        StringBuilder sb = new StringBuilder(100);
        traversePreOrder(node, sb);
        return sb.toString();
    }

    static void traversePreOrder(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.value).append(", ");
            traversePreOrder(node.left, sb);
            traversePreOrder(node.right, sb);
        }
    }

    static String traversePostOrder(Node node) {
        StringBuilder sb = new StringBuilder(100);
        traversePostOrder(node, sb);
        return sb.toString();
    }

    static void traversePostOrder(Node node, StringBuilder sb) {
        if (node != null) {
            traversePostOrder(node.left, sb);
            traversePostOrder(node.right, sb);
            sb.append(node.value).append(", ");
        }
    }

    static int maxDepth(Node node) {

        final Map<Node, Node> map = new IdentityHashMap<>(1_000);
        int currDepth = 0, maxDepth = 0;

        while (node != null) {
            Node child = null;
            if (node.right != null && !map.containsKey(node.right)) {
                child = node.right;
            } else if (node.left != null && !map.containsKey(node.left)) {
                child = node.left;
            }
            if (child != null) {
                currDepth++;
                map.put(child, node);
                maxDepth = Math.max(maxDepth, currDepth);
                node = child;
            } else {
                node = map.get(node);
                currDepth--;
            }
        }
        return maxDepth;
    }

    static Node insert(Node node, int val) {
        if (node == null) return (new Node(val));

        if (val <= node.value)
            node.left = insert(node.left, val);
        else
            node.right = insert(node.right, val);
        return node;
    }

    static int leftMostValue(Node root) {
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    static int rightMostValue(Node root) {
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    //    public Node inorderSuccessor(Node node) {
//
//        if (node.getParent() == null) {
//            return node.getRight();
//
//        } else {
//            if (node.getParent().getLeft() == node) {
//                return node.getParent();
//            }
//            return node.getRight();
//        }
//    }
}
