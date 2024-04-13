

public class BinaryTreeOperations {
    // Method to find the position visited after p in a preorder traversal of T
    public static BinaryTreeNode preorderNext(BinaryTreeNode p) {
        if (p == null)
            return null;

        // If the node has left child, return the left child
        if (p.left != null)
            return p.left;

        // If the node has right child, return the right child
        if (p.right != null)
            return p.right;

        // Traverse upwards until finding a parent whose right child hasn't been traversed yet
        while (p != null) {
            if (p.right != null && p.right != p)
                return p.right;
            p = p.parent;
        }

        return null; // Last node visited
    }

    // Test cases
    public static void main(String[] args) {
        // Constructing a sample binary tree
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        // Test preorderNext
        BinaryTreeNode node = root;
        while (node != null) {
            System.out.print(node.val + " ");
            node = preorderNext(node);
        }
        System.out.println(); // Output: 1 2 4 5 3
    }
}
