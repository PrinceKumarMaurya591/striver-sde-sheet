package BinarySearch;

public class PeakElement {

    public static void main(String[] args) {
        PeakElement pe = new PeakElement();
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(pe.findPeakElement(nums)); // Output: 2 (index of peak element 3)
    }

    // Function to find a peak element in an array (element that is greater than its
    // neighbors)
    // The function takes an array of integers as input and returns the index of any
    // peak element
    // The function uses a binary search approach to solve the problem
    // The time complexity of the function is O(log n), where n is the length of the
    // array. The space complexity is O(1) as we are using a constant amount of
    // extra space.

    // Approach: Use binary search. Compare the mid element with its right neighbor.
    // If nums[mid] > nums[mid + 1], there is a peak in the left half (including
    // mid).
    // If nums[mid] < nums[mid + 1], there is a peak in the right half.
    // This works because the array boundaries are considered as -infinity, so a
    // peak always exists.
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // If mid is greater than its right neighbor, the peak is in the left half
                // (including mid)
                right = mid;
            } else {
                // If mid is less than its right neighbor, the peak is in the right half
                left = mid + 1;
            }
        }

        return left; // left and right converge to the peak index
    }

}
