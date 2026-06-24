package Recursion.Recursion1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII sb = new SubsetsII();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = sb.subsetsWithDup(nums);
        System.out.println("Subsets (no duplicates): " + subsets);
    }

    // Function to generate all subsets of an array that may
    // contain duplicates. The result should not contain
    // duplicate subsets.
    // Time complexity: O(2^n * n), Space complexity: O(n).

    // Approach: Sort the array first. Use backtracking but
    // skip duplicate elements at the same recursion level
    // to avoid generating duplicate subsets.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result,
                           List<Integer> tempList,
                           int[] nums, int start) {
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same level
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
