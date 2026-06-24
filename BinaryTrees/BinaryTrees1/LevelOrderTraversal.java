package BinaryTrees.BinaryTrees1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();
        // Tree: 3 -> 9, 20 -> null, null, 15, 7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = lot.levelOrder(root);
        System.out.println("Level order: " + result);
    }

    // Function to perform level order traversal of a binary tree.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach: Use a queue. Start by adding the root. While the
    // queue is not empty, process all nodes at the current level
    // and add their children to the queue for the next level.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }

}
