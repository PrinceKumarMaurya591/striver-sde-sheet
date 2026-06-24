package BinaryTrees.BinaryTrees1;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        MaxDepthOfBinaryTree md = new MaxDepthOfBinaryTree();
        // Tree: 3 -> 9, 20 -> null, null, 15, 7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = md.maxDepth(root);
        System.out.println("Maximum depth: " + depth);
    }

    // Function to find the maximum depth (height) of a binary tree.
    // Time complexity: O(n), Space complexity: O(n) for recursion.

    // Approach: Recursively compute the height of the left and
    // right subtrees. The height of the current node is 1 plus
    // the maximum of the two subtree heights.
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

}
