package ru.roman.algo.tree;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringJoiner;

class TreeOperations {

    /**
     * In-order   (LNR) DFS
     */
    static List<Integer> traverseInOrder(Node node) {
        List<Integer> list = new ArrayList<>(100);
        traverseInOrder(node, list);
        return list;
    }

    private static void traverseInOrder(Node node, List<Integer> list) {
        if (node != null) {
            traverseInOrder(node.left, list);
            list.add(node.value);
            traverseInOrder(node.right, list);
        }
    }

    /**
     * Out-order   (RNL) DFS
     */
    static List<Integer> traverseOutOrder(Node node) {
        List<Integer> list = new ArrayList<>(100);
        traverseOutOrder(node, list);
        return list;
    }

    private static void traverseOutOrder(Node node, List<Integer> list) {
        if (node != null) {
            traverseOutOrder(node.right, list);
            list.add(node.value);
            traverseOutOrder(node.left, list);
        }
    }

    /**
     * Pre-order  (NLR) DFS
     */
    static List<Integer> traversePreOrder(Node node) {
        List<Integer> list = new ArrayList<>(100);
        traversePreOrder(node, list);
        return list;
    }

    private static void traversePreOrder(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.value);
            traversePreOrder(node.left, list);
            traversePreOrder(node.right, list);
        }
    }

    /**
     * Post-order (LRN) DFS
     */
    static List<Integer> traversePostOrder(Node node) {
        List<Integer> list = new ArrayList<>(100);
        traversePostOrder(node, list);
        return list;
    }

    private static void traversePostOrder(Node node, List<Integer> list) {
        if (node != null) {
            traversePostOrder(node.left, list);
            traversePostOrder(node.right, list);
            list.add(node.value);
        }
    }

    /**
     * BFS
     */
    static List<Integer> traverseBfs(Node root) {
        List<Integer> list = new ArrayList<>(100);
        Queue<Node> queue = new LinkedList<>();

        while (root != null) {
            list.add(root.value);
            queue.add(root.left);
            queue.add(root.right);
            root = queue.poll();
        }
        return list;
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

    static int countNodes(Node root) {
        if (root == null)
            return 0;
        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);
        return count;
    }

    static int leftMost(Node root) {
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    static int rightMost(Node root) {
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    /**
     * Search node in Binary Search Tree
     */
    static Node searchFor(Node root, int value) {
        if (root.value == value) return root;
        if (root.value < value) return searchFor(root.right, value);
        return searchFor(root.left, value);
    }

    static TreeStatistics getStatistics(Node root) {
        return new TreeStatistics(countNodes(root), leftMost(root), rightMost(root), maxDepth(root));
    }

    static class TreeStatistics {
        private final int nodesCount;
        private final int leftMost;
        private final int rightMost;
        private final int maxDepth;


        TreeStatistics(int nodesCount, int leftMost, int rightMost, int maxDepth) {
            this.nodesCount = nodesCount;
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            this.maxDepth = maxDepth;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", "", "")
                    .add("nodes count: " + nodesCount)
                    .add("leftmost: " + leftMost)
                    .add("rightmost: " + rightMost)
                    .add("max depth: " + maxDepth)
                    .toString();
        }
    }
}
