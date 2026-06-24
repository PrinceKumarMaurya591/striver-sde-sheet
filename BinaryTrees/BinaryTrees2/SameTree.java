package BinaryTrees.BinaryTrees2;

import BinaryTrees.BinaryTrees1.TreeNode;

public class SameTree {

    public static void main(String[] args) {
        SameTree st = new SameTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean isSame = st.isSameTree(p, q);
        System.out.println("Is same tree: " + isSame);
    }

    // Function to check if two binary trees are structurally
    // identical and have the same node values.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Recursively compare each node. Both nodes must
    // be null (equal), or both non-null with same value and
    // identical left and right subtrees.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

}
