package BinaryTrees.BinaryTrees3;

import BinaryTrees.BinaryTrees1.TreeNode;

public class MaxPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        MaxPathSum mps = new MaxPathSum();
        // Tree: -10 -> 9, 20 -> null, null, 15, 7
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = mps.maxPathSum(root);
        System.out.println("Max path sum: " + result);
    }

    // Function to find the maximum path sum in a binary tree.
    // A path can start and end at any node, but must go through
    // parent-child connections (can't have branches).
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: For each node, compute the maximum sum of a path
    // that starts at this node and goes down through either the
    // left or right child. Update the global maxSum with the sum
    // of the path that goes through the current node (node.val +
    // leftGain + rightGain).
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Maximum gain from left and right subtrees (ignore negatives)
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Sum of path through the current node
        int currentPathSum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum gain from this node going down
        return node.val + Math.max(leftGain, rightGain);
    }

}
