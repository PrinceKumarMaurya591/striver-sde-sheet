package BinarySearch;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        SearchRotatedSortedArray srs = new SearchRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(srs.search(nums, target)); // Output: 4
    }

    // Function to search for a target in a rotated sorted array
    // The function takes a rotated sorted array and a target as input and returns the index of the target, or -1 if not found
    // The function uses a modified binary search approach to solve the problem
    // The time complexity of the function is O(log n), where n is the length of the array. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Use binary search. At each step, at least one half (left or right) will be sorted.
    // Check which half is sorted by comparing nums[left] with nums[mid].
    // If the left half is sorted (nums[left] <= nums[mid]), check if the target lies in this half.
    // If yes, search in the left half; otherwise, search in the right half.
    // Similarly for the right half if it is sorted.
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) { // If the mid element is the target, return its index
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if the target lies in the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Search in the right half
                }
            } else { // The right half is sorted
                // Check if the target lies in the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }

        return -1; // Target not found
    }

}
