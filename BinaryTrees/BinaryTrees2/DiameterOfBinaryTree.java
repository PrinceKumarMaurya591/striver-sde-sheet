package BinaryTrees.BinaryTrees2;

import BinaryTrees.BinaryTrees1.TreeNode;

public class DiameterOfBinaryTree {

    private int diameter = 0;

    public static void main(String[] args) {
        DiameterOfBinaryTree db = new DiameterOfBinaryTree();
        // Tree: 1 -> 2, 3 -> 4, 5, null, null
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int d = db.diameterOfBinaryTree(root);
        System.out.println("Diameter: " + d);
    }

    // Function to find the diameter of a binary tree. The
    // diameter is the length of the longest path between any
    // two nodes. The path may or may not pass through the root.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: For each node, compute the heights of its left
    // and right subtrees. The diameter passing through this node
    // is leftHeight + rightHeight. Track the maximum diameter
    // seen across all nodes using a class variable.
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update diameter with the path through this node
        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
