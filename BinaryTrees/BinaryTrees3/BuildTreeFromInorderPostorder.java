package BinaryTrees.BinaryTrees3;

import BinaryTrees.BinaryTrees1.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInorderPostorder {

    public static void main(String[] args) {
        BuildTreeFromInorderPostorder bt =
                new BuildTreeFromInorderPostorder();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = bt.buildTree(inorder, postorder);
        System.out.println("Root: " + root.val);
    }

    // Function to build a binary tree from inorder and postorder
    // traversal arrays.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: The last element of postorder is the root. Find
    // the root's index in inorder. Elements to the left of the
    // root in inorder form the left subtree, and elements to the
    // right form the right subtree. Recursively build both
    // subtrees using postorder and inorder arrays.
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1,
                     inorder, 0, inorder.length - 1,
                     inorderMap);
    }

    private TreeNode build(int[] postorder, int postStart,
                           int postEnd,
                           int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> inorderMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderMap.get(rootVal);
        int leftSize = rootIndex - inStart;

        root.left = build(postorder, postStart,
                         postStart + leftSize - 1,
                         inorder, inStart, rootIndex - 1,
                         inorderMap);
        root.right = build(postorder, postStart + leftSize,
                          postEnd - 1,
                          inorder, rootIndex + 1, inEnd,
                          inorderMap);

        return root;
    }

}
