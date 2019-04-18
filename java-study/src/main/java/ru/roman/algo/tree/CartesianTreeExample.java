package ru.roman.algo.tree;

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

class CartesianTree {
    private Node root;

    CartesianTree(int[] data) {
        root = build(data);
    }

    static Node build(int[] data) {
        if (data == null || data.length == 0)
            return null;
        return build(data, 0, data.length - 1);
    }

    private static Node build(int[] data, int start, int end) {
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
                build(data, start, minIndex - 1),
                build(data, minIndex + 1, end)
        );
    }

    boolean isEmpty() {
        return root == null;
    }

    int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node r) {
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

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.value + ", ");
            traverseInOrder(node.right);
        }
    }

    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + ", ");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    private void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.value + ", ");
        }
    }
}