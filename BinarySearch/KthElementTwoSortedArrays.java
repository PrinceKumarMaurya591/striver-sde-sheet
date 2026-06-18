package BinarySearch;

public class KthElementTwoSortedArrays {

    public static void main(String[] args) {
        KthElementTwoSortedArrays ke = new KthElementTwoSortedArrays();
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(ke.kthElement(arr1, arr2, k)); // Output: 6
    }

    // Function to find the kth element in the union of two sorted arrays
    // The function takes two sorted arrays and an integer k as input and returns the kth smallest element
    // The function uses a binary search approach on the smaller array to solve the problem
    // The time complexity of the function is O(log(min(n, m))), where n and m are the lengths of the two arrays. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Similar to finding median of two sorted arrays.
    // Perform binary search on the smaller array to partition both arrays.
    // The partition is valid if maxLeft1 <= minRight2 and maxLeft2 <= minRight1.
    // If valid, the kth element is the max of the left halves.
    // If not valid, adjust the partition.
    public int kthElement(int[] arr1, int[] arr2, int k) {
        // Ensure arr1 is the smaller array
        if (arr1.length > arr2.length) {
            return kthElement(arr2, arr1, k);
        }

        int n = arr1.length;
        int m = arr2.length;
        int left = Math.max(0, k - m); // Minimum elements we can take from arr1
        int right = Math.min(k, n); // Maximum elements we can take from arr1

        while (left <= right) {
            int partition1 = left + (right - left) / 2; // Elements taken from arr1
            int partition2 = k - partition1; // Elements taken from arr2

            // Handle edge cases
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int minRight1 = (partition1 == n) ? Integer.MAX_VALUE : arr1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : arr2[partition2 - 1];
            int minRight2 = (partition2 == m) ? Integer.MAX_VALUE : arr2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Valid partition found, return the max of the left halves as the kth element
                return Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2) {
                // arr1's left half is too large, take fewer elements from arr1
                right = partition1 - 1;
            } else {
                // arr2's left half is too large, take more elements from arr1
                left = partition1 + 1;
            }
        }

        return -1; // Should never reach here
    }

}
