package BinarySearch;

public class SingleElementSortedArray {

    public static void main(String[] args) {
        SingleElementSortedArray se = new SingleElementSortedArray();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(se.singleNonDuplicate(nums)); // Output: 2
    }

    // Function to find the single element that appears only once in a sorted array where every other element appears twice
    // The function takes a sorted array as input and returns the single element
    // The function uses a binary search approach based on the parity of indices to solve the problem
    // The time complexity of the function is O(log n), where n is the length of the array. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Before the single element, pairs are at (even, odd) indices.
    // After the single element, pairs are at (odd, even) indices.
    // Use binary search to find the point where this pattern breaks.
    // At mid, check the pairing. If mid is even, compare nums[mid] with nums[mid+1].
    // If they are equal, the single element is to the right; otherwise, it's to the left.
    // If mid is odd, compare nums[mid] with nums[mid-1].
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is odd, make it even by decrementing it, so we always check the pair (even, odd)
            if (mid % 2 == 1) {
                mid--;
            }

            // Check if the pair (mid, mid+1) is a valid pair
            if (nums[mid] == nums[mid + 1]) {
                // If they are equal, the single element is in the right half
                left = mid + 2;
            } else {
                // If they are not equal, the single element is in the left half
                right = mid;
            }
        }

        return nums[left]; // left and right converge to the single element
    }

}
