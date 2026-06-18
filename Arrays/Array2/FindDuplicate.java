package Array2;

public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate fd = new FindDuplicate();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(fd.findDuplicate(nums)); // Output: 2
    }

    // Function to find the duplicate number in an array where elements are in the range [1, n]
    // The function takes an array of integers as input and returns the duplicate integer
    // The function uses a linked list cycle detection approach (Floyd's Tortoise and Hare) to solve the problem
    // The time complexity of the function is O(n), where n is the length of the array. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Treat the array as a linked list where the value at each index points to the next index.
    // Since there is a duplicate number, there will be a cycle in this linked list.
    // Use Floyd's Tortoise and Hare algorithm to detect the cycle and find the starting point of the cycle, which is the duplicate number.
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Find the intersection point of the two pointers (detect cycle)
        do {
            slow = nums[slow]; // Move slow by one step
            fast = nums[nums[fast]]; // Move fast by two steps
        } while (slow != fast); // Continue until they meet

        // Phase 2: Find the starting point of the cycle (the duplicate number)
        fast = nums[0]; // Reset fast to the start
        while (slow != fast) { // Move both pointers at the same speed until they meet
            slow = nums[slow]; // Move slow by one step
            fast = nums[fast]; // Move fast by one step
        }

        return slow; // The meeting point is the duplicate number
    }

}
