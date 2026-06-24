package BinaryTrees.BinaryTrees3;

import BinaryTrees.BinaryTrees1.TreeNode;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        // Tree: 3 -> 5, 1 -> 6, 2, 0, 8
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left;  // Node 5
        TreeNode q = root.right; // Node 1

        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 5 and 1: " + result.val);
    }

    // Function to find the lowest common ancestor of two nodes
    // in a binary tree. The LCA is the lowest node that has both
    // p and q as descendants.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Recursively search for p and q in the tree.
    // If the current node is null or matches p or q, return it.
    // Otherwise, search in left and right subtrees. If both
    // sides return non-null, the current node is the LCA.
    public TreeNode lowestCommonAncestor(TreeNode root,
                                          TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        return (left != null) ? left : right;
    }

}
