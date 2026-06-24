package BinaryTrees.BinaryTrees3;

import BinaryTrees.BinaryTrees1.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInorderPreorder {

    public static void main(String[] args) {
        BuildTreeFromInorderPreorder bt =
                new BuildTreeFromInorderPreorder();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = bt.buildTree(preorder, inorder);
        System.out.println("Root: " + root.val);
    }

    // Function to build a binary tree from preorder and inorder
    // traversal arrays.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: The first element of preorder is the root. Find
    // the root's index in inorder. Elements to the left of the
    // root in inorder form the left subtree, and elements to the
    // right form the right subtree. Recursively build both
    // subtrees using the preorder and inorder arrays.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1,
                     inorderMap);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderMap.get(rootVal);
        int leftSize = rootIndex - inStart;

        root.left = build(preorder, preStart + 1,
                         preStart + leftSize,
                         inorder, inStart, rootIndex - 1,
                         inorderMap);
        root.right = build(preorder, preStart + leftSize + 1,
                          preEnd,
                          inorder, rootIndex + 1, inEnd,
                          inorderMap);

        return root;
    }

}
