package Recursion.Recursion1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII cs = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = cs.combinationSum2(
                candidates, target);
        System.out.println("Combinations: " + result);
    }

    // Function to find all unique combinations that sum to a
    // target. Each number can be used only once. The result
    // should not contain duplicate combinations.
    // Time complexity: O(2^n), Space complexity: O(n).

    // Approach: Sort the array first. Use backtracking with
    // the constraint that each element can be used only once.
    // Skip duplicates at the same recursion level.
    public List<List<Integer>> combinationSum2(int[] candidates,
                                               int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates,
                target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result,
                           List<Integer> tempList,
                           int[] candidates, int remaining,
                           int start) {
        if (remaining < 0) return;
        if (remaining == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates,
                    remaining - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
