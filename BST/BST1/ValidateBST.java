package BST.BST1;

import BinaryTrees.BinaryTrees1.TreeNode;

public class ValidateBST {

    public static void main(String[] args) {
        ValidateBST vbst = new ValidateBST();
        // Valid BST: 2 -> 1, 3
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean isValid = vbst.isValidBST(root);
        System.out.println("Is valid BST: " + isValid);
    }

    // Function to validate if a binary tree is a valid BST.
    // A BST is valid if for every node, all nodes in its left
    // subtree have smaller values and all nodes in its right
    // subtree have larger values.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Use recursion with min and max bounds. For each
    // node, ensure its value is within the valid range. The left
    // child must be less than the current node, and the right
    // child must be greater than the current node.
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node,
                             Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) ||
            (max != null && node.val >= max)) {
            return false;
        }

        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }

}
