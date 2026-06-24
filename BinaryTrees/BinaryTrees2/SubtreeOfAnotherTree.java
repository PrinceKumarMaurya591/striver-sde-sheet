package BinaryTrees.BinaryTrees2;

import BinaryTrees.BinaryTrees1.TreeNode;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        SubtreeOfAnotherTree sat = new SubtreeOfAnotherTree();
        // Main tree: 3 -> 4, 5 -> 1, 2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Subtree: 4 -> 1, 2
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        boolean isSub = sat.isSubtree(root, subRoot);
        System.out.println("Is subtree: " + isSub);
    }

    // Function to check if a binary tree contains another tree
    // as a subtree (identical structure and values).
    // Time complexity: O(m * n), Space complexity: O(n).

    // Approach: For each node in the main tree, check if the
    // subtree rooted at that node is identical to the target
    // subtree using the isSameTree helper.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

}
