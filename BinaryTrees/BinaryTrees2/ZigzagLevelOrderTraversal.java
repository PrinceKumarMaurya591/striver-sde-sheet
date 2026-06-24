package BinaryTrees.BinaryTrees2;

import BinaryTrees.BinaryTrees1.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        ZigzagLevelOrderTraversal zlot =
                new ZigzagLevelOrderTraversal();
        // Tree: 3 -> 9, 20 -> null, null, 15, 7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zlot.zigzagLevelOrder(root);
        System.out.println("Zigzag order: " + result);
    }

    // Function to perform zigzag level order traversal. At each
    // level, nodes alternate between left-to-right and
    // right-to-left order.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Use a queue for level order traversal. Use a
    // boolean flag to track direction. For even levels, add
    // nodes left-to-right. For odd levels, add nodes
    // right-to-left (by inserting at the front of the list).
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    currentLevel.addLast(node.val);
                } else {
                    currentLevel.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }

}
