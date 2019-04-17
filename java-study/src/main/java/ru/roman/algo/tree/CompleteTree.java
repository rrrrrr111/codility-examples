package ru.roman.algo.tree;

public class CompleteTree {

    static TreePrinter<Node> printer = new TreePrinter<>(n -> ("" + n.value), n -> n.left, n -> n.right);

    public static void main(String[] args) {
        printer.setHspace(2);
        printer.setSquareBranches(true);

        Node tree;
        tree = completeLevelOrderTree(90);

        printer.printTree(tree);
        System.out.println();

        tree = completeInOrderTree(1, 90);
        printer.printTree(tree);
        System.out.println();
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

    private static int maxPowerOf2Under(int limit) {
        int lzs = Integer.numberOfLeadingZeros(limit);
        return 1 << (32 - lzs - 1);
    }
}