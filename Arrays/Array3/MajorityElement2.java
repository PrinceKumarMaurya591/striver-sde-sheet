package Array3;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

    public static void main(String[] args) {
        MajorityElement2 me = new MajorityElement2();
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(me.majorityElement(nums)); // Output: [1, 2]
    }

    // Function to find all elements that appear more than n/3 times in an array
    // The function takes an array of integers as input and returns a list of elements that appear more than n/3 times
    // The function uses an extended Boyer-Moore Voting Algorithm to solve the problem (at most 2 elements can appear more than n/3 times)
    // The time complexity of the function is O(n), where n is the length of the array. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Since there can be at most 2 majority elements (n/3 threshold), maintain two candidates and their counts.
    // First pass: Find potential candidates using the voting algorithm.
    // Second pass: Verify the candidates by counting their actual occurrences.
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int candidate1 = nums[0], count1 = 0;
        int candidate2 = nums[0], count2 = 0;

        // Phase 1: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) { // If the current element matches candidate1, increment count1
                count1++;
            } else if (num == candidate2) { // If the current element matches candidate2, increment count2
                count2++;
            } else if (count1 == 0) { // If count1 is 0, set the current element as candidate1
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) { // If count2 is 0, set the current element as candidate2
                candidate2 = num;
                count2 = 1;
            } else { // If the current element matches neither candidate, decrement both counts
                count1--;
                count2--;
            }
        }

        // Phase 2: Verify the candidates by counting their actual occurrences
        count1 = 0;
        count2 = 0;
        int threshold = nums.length / 3;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Add candidates to the result if they exceed the threshold
        if (count1 > threshold) {
            result.add(candidate1);
        }
        if (count2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }

}
