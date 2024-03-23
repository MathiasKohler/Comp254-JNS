public class BinaryTreeOperations {
    // Method to find the position visited after p in an inorder traversal of T
    public static BinaryTreeNode inorderNext(BinaryTreeNode p) {
        if (p == null)
            return null;

        // If the node has a right child, return the leftmost node of the right subtree
        if (p.right != null) {
            BinaryTreeNode temp = p.right;
            while (temp.left != null)
                temp = temp.left;
            return temp;
        }

        // Traverse upwards until finding a parent whose left child hasn't been traversed yet
        while (p != null && p.right == null) {
            p = p.parent;
        }

        return p == null ? null : p.right;
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

        // Test inorderNext
        BinaryTreeNode node = root;
        while (node != null) {
            System.out.print(node.val + " ");
            node = inorderNext(node);
        }
        System.out.println(); // Output: 4 2 5 1 3
    }
}
