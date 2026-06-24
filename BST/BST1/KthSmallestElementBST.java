package BST.BST1;

import BinaryTrees.BinaryTrees1.TreeNode;

public class KthSmallestElementBST {

    private int count = 0;
    private int result = 0;

    public static void main(String[] args) {
        KthSmallestElementBST kth =
                new KthSmallestElementBST();
        // BST: 3 -> 1, 4 -> null, 2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 2;
        int val = kth.kthSmallest(root, k);
        System.out.println("2nd smallest: " + val);
    }

    // Function to find the Kth smallest element in a BST.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Perform an inorder traversal (which visits
    // nodes in ascending order in a BST). Keep a counter.
    // When the counter reaches k, store the current node's
    // value and return.
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }

}
