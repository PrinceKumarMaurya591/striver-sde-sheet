package BST.BST1;

import BinaryTrees.BinaryTrees1.TreeNode;

public class InsertIntoBST {

    public static void main(String[] args) {
        InsertIntoBST ibst = new InsertIntoBST();
        // BST: 4 -> 2, 7 -> 1, 3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root = ibst.insertIntoBST(root, 5);
        System.out.println("Inserted 5. Root: " + root.val);
    }

    // Function to insert a value into a BST.
    // Time complexity: O(h), Space complexity: O(1).

    // Approach: Use the BST property to find the correct
    // position. Traverse the tree. When we find a null
    // position (left or right child of a leaf), insert
    // the new node there.
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode curr = root;
        while (true) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }

        return root;
    }

}
