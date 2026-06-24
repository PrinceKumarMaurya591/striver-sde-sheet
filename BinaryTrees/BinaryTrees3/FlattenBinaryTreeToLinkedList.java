package BinaryTrees.BinaryTrees3;

import BinaryTrees.BinaryTrees1.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList fb =
                new FlattenBinaryTreeToLinkedList();
        // Tree: 1 -> 2, 5 -> 3, 4, null, 6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        fb.flatten(root);

        System.out.print("Flattened: ");
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    // Function to flatten a binary tree to a linked list in-place
    // using the right pointers (preorder order). The left pointers
    // should be set to null.
    // Time complexity: O(n), Space complexity: O(n) for recursion.

    // Approach: Use a reverse postorder traversal (right, left,
    // root). Maintain a prev pointer that points to the previously
    // processed node. For each node, set its right to prev and
    // left to null, then update prev to the current node.
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Reverse postorder: right, left, root
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

}
