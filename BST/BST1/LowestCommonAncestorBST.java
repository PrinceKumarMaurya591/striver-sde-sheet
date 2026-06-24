package BST.BST1;

import BinaryTrees.BinaryTrees1.TreeNode;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        LowestCommonAncestorBST lca =
                new LowestCommonAncestorBST();
        // BST: 6 -> 2, 8 -> 0, 4, 7, 9 -> null, null, 3, 5
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;  // 2
        TreeNode q = root.right; // 8

        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 2 and 8: " + result.val);
    }

    // Function to find the LCA in a BST. Uses the BST property
    // to avoid exploring unnecessary subtrees.
    // Time complexity: O(h), Space complexity: O(1).

    // Approach: Since it's a BST, we can compare the values.
    // If both p and q are less than root, LCA is in left subtree.
    // If both are greater, LCA is in right subtree.
    // Otherwise, the current node is the LCA.
    public TreeNode lowestCommonAncestor(TreeNode root,
                                          TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

}
