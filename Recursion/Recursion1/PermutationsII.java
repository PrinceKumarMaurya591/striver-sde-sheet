package Recursion.Recursion1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII pm = new PermutationsII();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = pm.permuteUnique(nums);
        System.out.println("Unique permutations: " + result);
    }

    // Function to generate unique permutations when the array
    // contains duplicates.
    // Time complexity: O(n! * n), Space complexity: O(n).

    // Approach: Sort the array first. Use backtracking with a
    // boolean array to track used elements. Skip duplicates at
    // the same recursion level by checking if the previous
    // duplicate was used.
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums,
                new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result,
                           List<Integer> tempList,
                           int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // Skip duplicates: if current equals previous and
            // previous is not used, skip to avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

}
