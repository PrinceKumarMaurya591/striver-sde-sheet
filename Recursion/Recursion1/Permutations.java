package Recursion.Recursion1;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations pm = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = pm.permute(nums);
        System.out.println("Permutations: " + result);
    }

    // Function to generate all permutations of a distinct array.
    // Time complexity: O(n! * n), Space complexity: O(n).

    // Approach: Use backtracking by swapping elements. For each
    // position, we try putting every remaining element by swapping
    // it into the current position and recursing.
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result,
                           int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) permutation.add(num);
            result.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(result, nums, start + 1);
            swap(nums, start, i); // Backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
