package ru.roman.algo.tree;

import static ru.roman.algo.tree.TreeOperations.traverseInOrder;
import static ru.roman.algo.tree.TreeOperations.traversePostOrder;
import static ru.roman.algo.tree.TreeOperations.traversePreOrder;

public class TreeExamples {

    static TreePrinter<Node> printer = new TreePrinter<>(n -> ("" + n.value), n -> n.left, n -> n.right);

    public static void main(String[] args) {
        printer.setHspace(2);
        printer.setSquareBranches(true);
        Node tree;

        System.out.printf("%nComplete in order tree%n");
        tree = completeInOrderTree(1, 90);
        printer.printTree(tree);

        System.out.printf("%nComplete level order tree%n");
        tree = completeLevelOrderTree(90);
        printer.printTree(tree);

        System.out.printf("%nCartesian Tree%n");
        int[] arr = {9, 3, 7, 1, 8, 12, 10, 20, 15, 18, 5};
        tree = cartesianTree(arr, 0, arr.length - 1);
        printer.printTree(tree);
        System.out.printf("Traverse post order : %s%n", traversePostOrder(tree));
        System.out.printf("Traverse pre order : %s%n", traversePreOrder(tree));
        System.out.printf("Traverse in order : %s%n", traverseInOrder(tree));

        System.out.printf("%nBinary, not balanced tree%n");
//         7
//     3         12
// 1     6    9     13
// 0 2  4    8  11     15
//        5          14
        tree = createBinaryTree(7, 3, 12, 1, 6, 9, 13, 0, 2, 4, 8, 11, 15, 5, 14);
        printer.printTree(tree);
        System.out.printf("Traverse post order : %s%n", traversePostOrder(tree));
        System.out.printf("Traverse pre order : %s%n", traversePreOrder(tree));
        System.out.printf("Traverse in order : %s%n", traverseInOrder(tree));
    }

    private static Node completeInOrderTree(int first, int last) {
        if (first > last) return null;
        if (first == last) return new Node(first);
        // size = total number of nodes in tree
        int size = last - first + 1;
        // number of nodes on next to last level (a power of 2)
        int nextToLastLevelCount = maxPowerOf2Under(size / 2);
        // number of nodes on last level (which may be less than power of 2)
        int lastLevelCount = size - (nextToLastLevelCount * 2) + 1;
        // number of nodes in left subtree
        int leftSize = nextToLastLevelCount - 1 + Math.min(lastLevelCount, nextToLastLevelCount);
        int rootVal = first + leftSize;
        return new Node(rootVal, completeInOrderTree(first, rootVal - 1), completeInOrderTree(rootVal + 1, last));
    }

    private static Node completeLevelOrderTree(int size) {
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i + 1);
        }
        int i = 0;
        while (i * 2 + 1 < size) {
            nodes[i].left = nodes[i * 2 + 1];
            if (i * 2 + 2 < size) nodes[i].right = nodes[i * 2 + 2];
            i++;
        }
        return nodes[0];
    }

    static Node cartesianTree(int[] data, int start, int end) {
        if (end < start)
            return null;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = start; i <= end; i++) {
            if (data[i] < min) {
                min = data[i];
                minIndex = i;
            }
        }
        return new Node(
                min,
                cartesianTree(data, start, minIndex - 1),
                cartesianTree(data, minIndex + 1, end)
        );
    }

    /**
     * Binary != balanced
     */
    static Node createBinaryTree(int... val) {

        Node root = null;
        for (int i : val) {
            root = TreeOperations.insert(root, i);
        }
        return root;
    }

    private static int maxPowerOf2Under(int limit) {
        int lzs = Integer.numberOfLeadingZeros(limit);
        return 1 << (32 - lzs - 1);
    }
}