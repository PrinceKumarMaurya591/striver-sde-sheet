package BinaryTrees.BinaryTrees1;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public static void main(String[] args) {
        PreorderTraversal pt = new PreorderTraversal();
        // Tree: 1 -> null -> 2 -> 3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = pt.preorderTraversal(root);
        System.out.println("Preorder: " + result);
    }

    // Function to perform preorder traversal (Root -> Left -> Right).
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Visit the root, recursively traverse the left
    // subtree, then recursively traverse the right subtree.
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(result, root);
        return result;
    }

    private void preorder(List<Integer> result, TreeNode node) {
        if (node == null) return;

        result.add(node.val);
        preorder(result, node.left);
        preorder(result, node.right);
    }

}
