package ru.roman.algo;

/**
 *
 */
class CartesianTreeExample {

    public static void main(String[] args) {

        int[] arr = {9, 3, 7, 1, 8, 12, 10, 20, 15, 18, 5};
        CartesianTree ct = new CartesianTree(arr);

        System.out.println("\nTree Details :");
        System.out.println("Empty status - " + ct.isEmpty());
        System.out.println("No of nodes - " + ct.countNodes());
        System.out.print("Post order : ");
        ct.traversePostOrder();
        System.out.print("\nPre order : ");
        ct.traversePreOrder();
        System.out.print("\nIn order : ");
        ct.traverseInOrder();
        System.out.println();
    }
}

class CtNode {
    CtNode left, right;
    int value;

    /* Constructor */
    CtNode() {
        left = null;
        right = null;
        value = 0;
    }
}

class CartesianTree {
    private CtNode root;

    CartesianTree(int[] data) {
        root = build(data);
    }

    static CtNode build(int[] data) {
        if (data == null || data.length == 0)
            return null;
        return build(data, 0, data.length - 1);
    }

    private static CtNode build(int[] data, int start, int end) {
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
        CtNode node = new CtNode();
        node.value = min;
        node.left = build(data, start, minIndex - 1);
        node.right = build(data, minIndex + 1, end);
        return node;
    }

    boolean isEmpty() {
        return root == null;
    }

    int countNodes() {
        return countNodes(root);
    }

    private int countNodes(CtNode r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }

    void traverseInOrder() {
        traverseInOrder(root);
    }

    void traversePreOrder() {
        traversePreOrder(root);
    }

    void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traverseInOrder(CtNode r) {
        if (r != null) {
            traverseInOrder(r.left);
            System.out.print(r.value + " ");
            traverseInOrder(r.right);
        }
    }

    private void traversePreOrder(CtNode r) {
        if (r != null) {
            System.out.print(r.value + " ");
            traversePreOrder(r.left);
            traversePreOrder(r.right);
        }
    }

    private void traversePostOrder(CtNode r) {
        if (r != null) {
            traversePostOrder(r.left);
            traversePostOrder(r.right);
            System.out.print(r.value + " ");
        }
    }
}