package BinaryTrees.BinaryTrees1;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    public static void main(String[] args) {
        PostorderTraversal pt = new PostorderTraversal();
        // Tree: 1 -> null -> 2 -> 3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = pt.postorderTraversal(root);
        System.out.println("Postorder: " + result);
    }

    // Function to perform postorder traversal
    // (Left -> Right -> Root).
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Recursively traverse the left subtree, then the
    // right subtree, then visit the root.
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(result, root);
        return result;
    }

    private void postorder(List<Integer> result, TreeNode node) {
        if (node == null) return;

        postorder(result, node.left);
        postorder(result, node.right);
        result.add(node.val);
    }

}
