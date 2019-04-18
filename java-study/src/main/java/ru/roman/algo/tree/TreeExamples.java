package ru.roman.algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ru.roman.algo.tree.TreeOperations.getStatistics;
import static ru.roman.algo.tree.TreeOperations.insert;
import static ru.roman.algo.tree.TreeOperations.traverseBfs;
import static ru.roman.algo.tree.TreeOperations.traverseInOrder;
import static ru.roman.algo.tree.TreeOperations.traverseOutOrder;
import static ru.roman.algo.tree.TreeOperations.traversePostOrder;
import static ru.roman.algo.tree.TreeOperations.traversePreOrder;

public class TreeExamples {

    private static TreePrinter<Node> printer = new TreePrinter<>(n -> ("" + n.value), n -> n.left, n -> n.right);
    private static Random random = new Random();

    public static void main(String[] args) {
        printer.setSquareBranches(true);

        printCompleteInOrderTree();
        printCompleteLevelOrderTree();
        printCartesianTree();
        printCollatzTree();
        printBinarySearchTree();
        printRandomTree();

        //printEnumDAGTrees();
        //printEnumTrees();
    }

    private static void printRandomTree() {
        Node tree = randomTree(0, 200);
        System.out.printf("%n Random tree %n %s %n", getStatistics(tree));
        printer.printTree(tree);
    }

    private static void printEnumTrees() {
        System.out.printf("%n Enum trees%n");
        List<Node> trees = enumTrees(1, 6);
        printer.printTrees(trees, 120);
    }

    private static void printEnumDAGTrees() {
        System.out.printf("%n Enum DAG trees%n");
        List<Node> trees = enumTrees(7);
        printer.printTrees(trees, 120);
    }

    private static void printBinarySearchTree() {
        Node tree = createBinarySearchTree(7, 3, 12, 1, 6, 9, 13, 0, 2, 4, 8, 11, 15, 5, 14);
        System.out.printf("%n Binary, not balanced, search tree%n %s %n", getStatistics(tree));
        printer.printTree(tree);
        System.out.printf("In-order   (LNR) DFS : %s%n", traverseInOrder(tree));
        System.out.printf("Out-order  (RNL) DFS : %s%n", traverseOutOrder(tree));
        System.out.printf("Post-order (LRN) DFS : %s%n", traversePostOrder(tree));
        System.out.printf("Pre-order  (NLR) DFS : %s%n", traversePreOrder(tree));
        System.out.printf("Traversing BFS : %s%n", traverseBfs(tree));
    }

    private static void printCollatzTree() {
        // Collatz Conjecture: for every positive integer X, there is some N such that X appears in collatzTree(N)
        Node tree = collatzTree(1, 1, 15);
        System.out.printf("%n Collatz tree%n %s %n", getStatistics(tree));
        printer.printTree(tree);
    }

    private static void printCartesianTree() {
        int[] arr = {9, 3, 7, 1, 8, 12, 10, 20, 15, 18, 5};
        Node tree = cartesianTree(arr, 0, arr.length - 1);
        System.out.printf("%n Cartesian Tree%n %s %n", getStatistics(tree));
        printer.printTree(tree);
        System.out.printf("In-order   (LNR) DFS : %s%n", traverseInOrder(tree));
    }

    private static void printCompleteLevelOrderTree() {
        Node tree = completeLevelOrderTree(90);
        System.out.printf("%n Complete level order tree%n %s %n", getStatistics(tree));
        printer.printTree(tree);
        System.out.printf("Traversing BFS : %s%n", traverseBfs(tree));
    }

    private static void printCompleteInOrderTree() {
        Node tree = completeInOrderTree(1, 90);
        System.out.printf("%n Complete in order tree%n %s %n", getStatistics(tree));
        printer.printTree(tree);
        System.out.printf("In-order   (LNR) DFS : %s%n", traverseInOrder(tree));
        System.out.printf("Out-order  (RNL) DFS : %s%n", traverseOutOrder(tree));
    }

    private static Node randomTree(int firstValue, int lastValue) {
        if (firstValue > lastValue) return null;
        int treeSize = lastValue - firstValue + 1;
        int leftCount = random.nextInt(treeSize);
        int rightCount = treeSize - leftCount - 1;
        Node root = new Node(firstValue + leftCount);
        root.left = randomTree(firstValue, firstValue + leftCount - 1);
        root.right = randomTree(firstValue + leftCount + 1, lastValue);
        return root;
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

    private static Node cartesianTree(int[] data, int start, int end) {
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
        return new Node(min,
                cartesianTree(data, start, minIndex - 1),
                cartesianTree(data, minIndex + 1, end)
        );
    }

    private static Node createBinarySearchTree(int... val) {
        Node root = null;
        for (int i : val) {
            root = insert(root, i);
        }
        return root;
    }

    private static int maxPowerOf2Under(int limit) {
        int lzs = Integer.numberOfLeadingZeros(limit);
        return 1 << (32 - lzs - 1);
    }

    private static Node collatzTree(int start, int curLength, int maxLength) {
        Node root = new Node(start);
        if (curLength < maxLength) {
            // Forward Collatz sequence has that an even number N is followed by N/2, which is either an even or odd number.
            // So in reverse, either an even or odd number (any number) can be preceded by 2N.
            root.left = collatzTree(start * 2, curLength + 1, maxLength);
            // Forward Collatz sequence has that an odd number N (i.e. a number of form 2X+1) is followed
            // by 3N+1 (i.e. 3(2X+1)+1, or 6X+4).
            // So in reverse, a number N of the form 6X+4 can be preceded by (N-1)/3 (N-1 is divisible by 3)
            // But if N is 4, we don't want it preceded (in reverse) by 1, since in the forward direction,
            // the sequence stops at 1 (or, in the reverse direction, 1 is where we started).
            if (start % 6 == 4 && start > 4) root.right = collatzTree((start - 1) / 3, curLength + 1, maxLength);
        }
        return root;
    }

    private static List<Node> enumTrees(int n) {
        List<Node>[] subProblems = new ArrayList[n + 1];

        subProblems[0] = new ArrayList<>();
        subProblems[0].add(null);

        for (int totalNodes = 1; totalNodes <= n; totalNodes++) {
            subProblems[totalNodes] = new ArrayList<>();

            for (int rightCount = 0; rightCount < totalNodes; rightCount++) {
                int leftCount = totalNodes - rightCount - 1;
                List<Node> leftTrees = subProblems[leftCount];
                List<Node> rightTrees = subProblems[rightCount];
                for (Node leftNode : leftTrees) {
                    for (Node rightNode : rightTrees) {
                        Node newRoot = new Node(0, leftNode, rightNode);
                        subProblems[totalNodes].add(newRoot);
                    }
                }
            }
        }
        return subProblems[n];
    }

    private static List<Node> enumTrees(int firstValue, int lastValue) {
        List<Node> allTrees = new ArrayList<>();
        if (firstValue > lastValue) {
            allTrees.add(null);
        } else {
            for (int rootValue = firstValue; rootValue <= lastValue; rootValue++) {
                List<Node> leftTrees = enumTrees(firstValue, rootValue - 1);
                List<Node> rightTrees = enumTrees(rootValue + 1, lastValue);
                for (Node leftTree : leftTrees) {
                    for (Node rightTree : rightTrees) {
                        Node root = new Node(rootValue, leftTree, rightTree);
                        allTrees.add(root);
                    }
                }
            }
        }
        return allTrees;
    }
}