package Array1;

public class NextPermuttion {

    public static void main(String[] args) {
        NextPermuttion np = new NextPermuttion();
        int[] nums = { 1, 2, 3 };
        np.nextPermutation(nums);
        // Output the modified array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // Function to find the next permutation of an array of integers
    // The function takes an array of integers as input and modifies it in place to
    // the next permutation
    // The function uses a greedy approach to find the next permutation by
    // identifying the first decreasing element from the end of the array and
    // swapping it with the next larger element, then reversing the elements
    // The time complexity of the function is O(n), where n is the length of the
    // array. The space complexity is O(1) as we are using a constant amount of
    // extra space

    // Approach: We iterate from the end of the array to find the first decreasing
    // element.
    // Once we find this element, we iterate again from the end to find the next
    // larger element to swap with it. After swapping, we reverse the elements after
    // the original position of the first decreasing element to get the next
    // permutation in lexicographical order.
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) { // If we found a decreasing element
            int j = n - 1;
            // Find the next larger element to swap with
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j); // Swap the elements
        }

        reverse(nums, i + 1, n - 1); // Reverse the elements after the original position of the first decreasing
                                     // element
    }

    // Helper function to swap two elements in an array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse elements in an array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
