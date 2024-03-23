public class TreeHeightPrinter {
    public static void printElementAndHeight(TreeNode root) {
        if (root == null)
            return;

        postOrderTraversal(root);
    }

    private static int postOrderTraversal(TreeNode node) {
        if (node.children.isEmpty()) {
            System.out.println("Element: " + node.val + ", Height: 0");
            return 0;
        }

        int maxHeight = 0;
        for (TreeNode child : node.children) {
            int height = postOrderTraversal(child) + 1;
            maxHeight = Math.max(maxHeight, height);
        }

        System.out.println("Element: " + node.val + ", Height: " + maxHeight);
        return maxHeight;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);
        node3.children.add(node6);

        printElementAndHeight(root);
    }
}
