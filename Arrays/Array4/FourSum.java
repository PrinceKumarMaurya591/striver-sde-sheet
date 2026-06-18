package Array4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fs.fourSum(nums, target);
        // Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    // Function to find all unique quadruplets that sum up to a target value
    // The function takes an array of integers and a target integer as input and returns a list of unique quadruplets
    // The function uses a two-pointer approach with sorting to solve the problem
    // The time complexity of the function is O(n^3), where n is the length of the array. The space complexity is O(1) (excluding the space for the output list).

    // Approach: Sort the array to use the two-pointer technique and avoid duplicates.
    // Fix the first two elements using two nested loops.
    // Use two pointers (left and right) to find the remaining two elements that sum to the target.
    // Skip duplicate elements at each level to ensure unique quadruplets.
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) { // If there are less than 4 elements, no quadruplet is possible
            return result;
        }

        Arrays.sort(nums); // Sort the array to use the two-pointer technique
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate elements for the first position
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate elements for the second position
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1; // Left pointer for the third element
                int right = n - 1; // Right pointer for the fourth element

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right]; // Use long to avoid integer overflow

                    if (sum == target) { // If the sum matches the target, add the quadruplet to the result
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicate elements for the third position
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Skip duplicate elements for the fourth position
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++; // Move the left pointer forward
                        right--; // Move the right pointer backward
                    } else if (sum < target) { // If the sum is less than the target, move the left pointer to increase the sum
                        left++;
                    } else { // If the sum is greater than the target, move the right pointer to decrease the sum
                        right--;
                    }
                }
            }
        }

        return result;
    }

}
