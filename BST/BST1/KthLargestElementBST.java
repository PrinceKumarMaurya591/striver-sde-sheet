package BST.BST1;

import BinaryTrees.BinaryTrees1.TreeNode;

public class KthLargestElementBST {

    private int count = 0;
    private int result = 0;

    public static void main(String[] args) {
        KthLargestElementBST kth =
                new KthLargestElementBST();
        // BST: 3 -> 1, 4 -> null, 2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 2;
        int val = kth.kthLargest(root, k);
        System.out.println("2nd largest: " + val);
    }

    // Function to find the Kth largest element in a BST.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Perform a reverse inorder traversal (right,
    // root, left) which visits nodes in descending order.
    // Keep a counter. When the counter reaches k, store the
    // current node's value.
    public int kthLargest(TreeNode root, int k) {
        count = 0;
        result = 0;
        reverseInorder(root, k);
        return result;
    }

    private void reverseInorder(TreeNode node, int k) {
        if (node == null) return;

        reverseInorder(node.right, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        reverseInorder(node.left, k);
    }

}
