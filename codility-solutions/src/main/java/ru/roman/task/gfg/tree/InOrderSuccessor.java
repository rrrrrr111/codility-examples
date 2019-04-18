package ru.roman.task.gfg.tree;


import static com.google.common.base.Preconditions.checkState;

/**
 * Find next after specified node value, in binary search tree
 * <pre>
 *            7
 *      ┌─────┴─────┐
 *      3           12
 *   ┌──┴──┐     ┌──┴──┐
 *   1     6     9     13
 * ┌─┴─┐  ┌┘   ┌─┴─┐   └┐
 * 0   2  4    8   11   15
 *        └┐           ┌┘
 *         5           14
 * In-order   (LNR) DFS : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15]</pre>
 */
class InOrderSuccessor {

    public static void main(String[] args) {

        Node tree = createBinarySearchTree(7, 3, 12, 1, 6, 9, 13, 0, 2, 4, 8, 11, 15, 5, 14);
        checkState(inOrderSuccessor(searchFor(tree, 13)) == 14);
        checkState(inOrderSuccessor(searchFor(tree, 5)) == 6);
        checkState(inOrderSuccessor(searchFor(tree, 7)) == 8);
        checkState(inOrderSuccessor(searchFor(tree, 1)) == 2);
        checkState(inOrderSuccessor(searchFor(tree, 0)) == 1);
        checkState(inOrderSuccessor(searchFor(tree, 9)) == 11);
        checkState(inOrderSuccessor(searchFor(tree, 11)) == 12);
        checkState(inOrderSuccessor(searchFor(tree, 15)) == -1);
    }

    static Integer inOrderSuccessor(Node node) {

        if (node.right != null)
            return leftMost(node.right);

        if (node.parent == null) return -1;   // no successor found

        int val = node.value;
        while (node.parent != null && node.parent.value < val) {
            node = node.parent;
        }
        return node.parent != null ? node.parent.value : -1;
    }

    /* Binary search tree operations */
    private static Node searchFor(Node root, int value) {
        if (root.value == value) return root;
        if (root.value < value) return searchFor(root.right, value);
        return searchFor(root.left, value);
    }

    static int leftMost(Node root) {
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    private static Node createBinarySearchTree(int... val) {
        Node root = null;
        for (int i : val) root = insert(root, i);
        return root;
    }

    private static Node insert(Node node, int val) {
        if (node == null) return (new Node(val));
        if (val <= node.value) {
            node.left = insert(node.left, val);
            node.left.parent = node;
        } else {
            node.right = insert(node.right, val);
            node.right.parent = node;
        }
        return node;
    }
}
