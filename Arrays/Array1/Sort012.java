package Array1;

public class Sort012 {

    public static void main(String[] args) {
        Sort012 sorter = new Sort012();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sorter.sortColors(nums);
        // Output the sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Function to sort an array of 0's, 1's, and 2's in-place
    // The function takes an array of integers (containing only 0, 1, and 2) as input
    // and sorts it in ascending order using the Dutch National Flag Algorithm
    // The time complexity of the function is O(n), where n is the length of the array.
    // The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: We use three pointers: low, mid, and high.
    // - nums[0...low-1] contains all 0's
    // - nums[low...mid-1] contains all 1's
    // - nums[high+1...n-1] contains all 2's
    // We iterate through the array using the mid pointer and swap elements to their
    // correct positions based on their values until mid crosses high.
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    // Swap nums[low] and nums[mid], increment both low and mid
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    // Element is in the correct region, just move mid forward
                    mid++;
                    break;
                case 2:
                    // Swap nums[mid] and nums[high], decrement high
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    // Helper function to swap two elements in an array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
