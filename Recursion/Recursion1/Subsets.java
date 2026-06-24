package Recursion.Recursion1;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets sb = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = sb.subsets(nums);
        System.out.println("Subsets: " + subsets);
    }

    // Function to generate all possible subsets of an array.
    // Time complexity: O(2^n * n), Space complexity: O(n)
    // for recursion stack.

    // Approach: We use recursion with backtracking. At each
    // step, we have two choices: include the current element
    // or exclude it. We continue until we've considered all
    // elements.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result,
                           List<Integer> tempList,
                           int[] nums, int start) {
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
