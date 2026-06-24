package BST.BST1;

import BinaryTrees.BinaryTrees1.TreeNode;

public class SearchInBST {

    public static void main(String[] args) {
        SearchInBST sbst = new SearchInBST();
        // BST: 4 -> 2, 7 -> 1, 3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = sbst.searchBST(root, 2);
        System.out.println("Found node with value: "
                + (result != null ? result.val : "null"));
    }

    // Function to search for a value in a BST.
    // Time complexity: O(h), Space complexity: O(1).

    // Approach: Use the BST property. Compare the target value
    // with the current node. If equal, return the node. If
    // target is smaller, go to the left child. If larger, go
    // to the right child. Continue until found or null.
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = (val < root.val) ? root.left : root.right;
        }
        return root;
    }

}
