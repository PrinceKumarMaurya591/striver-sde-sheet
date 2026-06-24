package BinaryTrees.BinaryTrees1;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        // Balanced tree: 3 -> 9, 20 -> null, null, 15, 7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        boolean isBal = bbt.isBalanced(root);
        System.out.println("Is balanced: " + isBal);
    }

    // Function to check if a binary tree is height-balanced.
    // A tree is balanced if the height difference between left
    // and right subtrees is at most 1 for every node.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Use a recursive helper that returns the height
    // of a node or -1 if the subtree is unbalanced. For each
    // node, compute the heights of left and right subtrees. If
    // the difference is more than 1, return -1 (unbalanced).
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
