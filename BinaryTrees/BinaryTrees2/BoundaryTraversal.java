package BinaryTrees.BinaryTrees2;

import BinaryTrees.BinaryTrees1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    public static void main(String[] args) {
        BoundaryTraversal bt = new BoundaryTraversal();
        // Tree: 1 -> 2, 3 -> 4, 5, 6, 7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = bt.boundaryOfBinaryTree(root);
        System.out.println("Boundary: " + result);
    }

    // Function to traverse the boundary of a binary tree in
    // anticlockwise order: root, left boundary (except leaf),
    // leaves, right boundary (except leaf) in reverse.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: The boundary consists of three parts:
    // 1. Left boundary (excluding leaf nodes) - traverse top-down
    // 2. Leaf nodes - traverse left-to-right
    // 3. Right boundary (excluding leaf nodes) - traverse
    //    bottom-up (reverse order)
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        result.add(root.val);

        // Add left boundary
        addLeftBoundary(root.left, result);

        // Add leaf nodes
        addLeaves(root.left, result);
        addLeaves(root.right, result);

        // Add right boundary (in reverse)
        addRightBoundary(root.right, result);

        return result;
    }

    private void addLeftBoundary(TreeNode node,
                                 List<Integer> result) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;

        result.add(node.val);
        if (node.left != null) {
            addLeftBoundary(node.left, result);
        } else {
            addLeftBoundary(node.right, result);
        }
    }

    private void addRightBoundary(TreeNode node,
                                  List<Integer> result) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;

        if (node.right != null) {
            addRightBoundary(node.right, result);
        } else {
            addRightBoundary(node.left, result);
        }
        result.add(node.val); // Add after recursion (reverse)
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

}
