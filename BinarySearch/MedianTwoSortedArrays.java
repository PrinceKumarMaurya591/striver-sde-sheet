package BinarySearch;

public class MedianTwoSortedArrays {

    public static void main(String[] args) {
        MedianTwoSortedArrays ms = new MedianTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(ms.findMedianSortedArrays(nums1, nums2)); // Output: 2.0
    }

    // Function to find the median of two sorted arrays
    // The function takes two sorted arrays as input and returns the median value
    // The function uses a binary search approach on the smaller array to solve the problem efficiently
    // The time complexity of the function is O(log(min(n, m))), where n and m are the lengths of the two arrays. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Perform binary search on the smaller array to partition both arrays into left and right halves.
    // The partition is valid if maxLeft1 <= minRight2 and maxLeft2 <= minRight1.
    // If the partition is valid, calculate the median based on whether the total number of elements is even or odd.
    // If not valid, adjust the partition using binary search.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for efficient binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;
        int left = 0;
        int right = n;

        while (left <= right) {
            int partition1 = left + (right - left) / 2; // Partition point in nums1
            int partition2 = (n + m + 1) / 2 - partition1; // Partition point in nums2

            // Handle edge cases where partition is at the boundary
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == n) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == m) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Valid partition found
                if ((n + m) % 2 == 0) {
                    // If total length is even, median is the average of the max of left and min of right
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // If total length is odd, median is the max of the left half
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // nums1's left half is too large, move partition to the left
                right = partition1 - 1;
            } else {
                // nums2's left half is too large, move partition to the right
                left = partition1 + 1;
            }
        }

        return 0.0; // Should never reach here
    }

}
