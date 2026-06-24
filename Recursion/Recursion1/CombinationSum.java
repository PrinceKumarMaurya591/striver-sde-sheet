package Recursion.Recursion1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = cs.combinationSum(
                candidates, target);
        System.out.println("Combinations: " + result);
    }

    // Function to find all combinations that sum to a target.
    // Each number can be used an unlimited number of times.
    // Time complexity: O(2^(t/m)), Space complexity: O(t/m)
    // where t is target and m is minimum candidate value.

    // Approach: Use backtracking. At each step, we can choose
    // the same element again (since unlimited usage is allowed).
    // We reduce the target and continue until target becomes 0
    // (found a combination) or negative (invalid).
    public List<List<Integer>> combinationSum(int[] candidates,
                                               int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
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
            tempList.add(candidates[i]);
            // Allow using the same element again
            backtrack(result, tempList, candidates,
                    remaining - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }

}
