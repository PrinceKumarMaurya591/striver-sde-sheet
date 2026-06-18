package Array3;

public class ReversePairs {

    public static void main(String[] args) {
        ReversePairs rp = new ReversePairs();
        int[] nums = {1, 3, 2, 3, 1};
        System.out.println(rp.reversePairs(nums)); // Output: 2
    }

    // Function to count the number of reverse pairs in an array
    // A reverse pair is a pair (i, j) such that i < j and nums[i] > 2 * nums[j]
    // The function takes an array of integers as input and returns the total number of reverse pairs
    // The function uses a divide and conquer approach (modified merge sort) to solve the problem
    // The time complexity of the function is O(n log n), where n is the length of the array. The space complexity is O(n) due to the temporary array used during the merge step.

    // Approach: Use the merge sort algorithm to count reverse pairs.
    // Before merging two sorted halves, count the number of reverse pairs where the first element is in the left half and the second element is in the right half.
    // Since both halves are sorted, for each element in the left half, we can find the first element in the right half where nums[i] > 2 * nums[j] using two pointers.
    // After counting, merge the two halves as in standard merge sort.
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        return mergeSort(nums, temp, 0, n - 1);
    }

    // Recursive merge sort function to count reverse pairs
    private int mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = 0;

        count += mergeSort(nums, temp, left, mid); // Count reverse pairs in the left half
        count += mergeSort(nums, temp, mid + 1, right); // Count reverse pairs in the right half
        count += merge(nums, temp, left, mid, right); // Count cross reverse pairs while merging

        return count;
    }

    // Merge function to merge two sorted halves and count cross reverse pairs
    private int merge(int[] nums, int[] temp, int left, int mid, int right) {
        int count = 0;

        // Count reverse pairs: nums[i] > 2 * nums[j] where i is in left half and j is in right half
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            // For each element in the left half, find the first element in the right half where nums[i] <= 2 * nums[j]
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            // All elements from mid+1 to j-1 form reverse pairs with nums[i]
            count += (j - (mid + 1));
        }

        // Standard merge step
        int i = left; // Starting index for the left subarray
        j = mid + 1; // Starting index for the right subarray
        int k = left; // Starting index for the temporary array

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) { // If the left element is smaller or equal, copy it to temp
                temp[k++] = nums[i++];
            } else { // If the right element is smaller, copy it to temp
                temp[k++] = nums[j++];
            }
        }

        // Copy remaining elements from the left subarray
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Copy remaining elements from the right subarray
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy the merged elements back to the original array
        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }

        return count;
    }

}
