package BinaryTrees.BinaryTrees1;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public static void main(String[] args) {
        InorderTraversal it = new InorderTraversal();
        // Tree: 1 -> null -> 2 -> 3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = it.inorderTraversal(root);
        System.out.println("Inorder: " + result);
    }

    // Function to perform inorder traversal (Left -> Root -> Right).
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Recursively traverse the left subtree, visit the
    // root, then recursively traverse the right subtree.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(result, root);
        return result;
    }

    private void inorder(List<Integer> result, TreeNode node) {
        if (node == null) return;

        inorder(result, node.left);
        result.add(node.val);
        inorder(result, node.right);
    }

}
