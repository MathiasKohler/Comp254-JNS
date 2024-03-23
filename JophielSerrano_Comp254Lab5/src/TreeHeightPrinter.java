public class TreeHeightPrinter {
    public static void printElementAndHeight(NormalTreeNode root) {
        if (root == null)
            return;

        postOrderTraversal(root);
    }

    private static int postOrderTraversal(NormalTreeNode node) {
        if (node.children.isEmpty()) {
            System.out.println("Element: " + node.val + ", Height: 0");
            return 0;
        }

        int maxHeight = 0;
        for (NormalTreeNode child : node.children) {
            int height = postOrderTraversal(child) + 1;
            maxHeight = Math.max(maxHeight, height);
        }

        System.out.println("Element: " + node.val + ", Height: " + maxHeight);
        return maxHeight;
    }

    public static void main(String[] args) {
        NormalTreeNode root = new NormalTreeNode(1);
        NormalTreeNode node2 = new NormalTreeNode(2);
        NormalTreeNode node3 = new NormalTreeNode(3);
        NormalTreeNode node4 = new NormalTreeNode(4);
        NormalTreeNode node5 = new NormalTreeNode(5);
        NormalTreeNode node6 = new NormalTreeNode(6);

        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);
        node3.children.add(node6);

        printElementAndHeight(root);
    }
}
