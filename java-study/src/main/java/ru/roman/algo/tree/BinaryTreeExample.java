package ru.roman.algo.tree;

import java.util.IdentityHashMap;
import java.util.Map;

class BinaryTreeExample {

    public static void main(String[] args) {

//         7
//     3         12
// 1     6    9     13
// 0 2  4    8  11     15
//        5          14

        Node root = createBinaryTree(1, 0, 2, 3, 6, 4, 5, 7, 8, 9, 12, 11, 13, 15, 14);
        //System.out.println(TreePrinter.print(root));
    }


    /**
     * Binary do not mean balanced!
     */
    static Node createBinaryTree(int... val) {

        Node root = null;
        for (int i : val) {
            root = insert(root, i);
        }
        return root;
    }

    static Node insert(Node node, int val) {
        if (node == null) return (new Node(val));

        if (val <= node.value)
            node.left = insert(node.left, val);
        else
            node.right = insert(node.right, val);
        return node;
    }

    static int minValueNode(Node root) {
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
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