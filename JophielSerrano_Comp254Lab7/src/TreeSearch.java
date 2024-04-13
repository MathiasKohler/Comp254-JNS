import java.util.Stack;

public class TreeSearch {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // Non-recursive tree search using a stack
    public static boolean treeSearch(TreeNode root, int target) {
        if (root == null)
            return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == target)
                return true;

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return false;
    }

    // Test the implementation
    public static void main(String[] args) {
        // Create a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Test cases
        System.out.println(treeSearch(root, 5)); // Should print true
        System.out.println(treeSearch(root, 8)); // Should print false
    }
}