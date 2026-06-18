package Array3;

public class MajorityElement1 {

    public static void main(String[] args) {
        MajorityElement1 me = new MajorityElement1();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(me.majorityElement(nums)); // Output: 2
    }

    // Function to find the majority element in an array (element that appears more than n/2 times)
    // The function takes an array of integers as input and returns the majority element
    // The function uses Boyer-Moore Voting Algorithm to solve the problem
    // The time complexity of the function is O(n), where n is the length of the array. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Use Boyer-Moore Voting Algorithm.
    // Maintain a candidate and a count. Iterate through the array.
    // If count is 0, set the current element as the candidate.
    // If the current element is equal to the candidate, increment count; otherwise, decrement count.
    // The candidate at the end is the majority element (guaranteed to exist as per problem statement).
    public int majorityElement(int[] nums) {
        int candidate = nums[0]; // Initialize candidate with the first element
        int count = 1; // Initialize count as 1

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) { // If count becomes 0, set the current element as the new candidate
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) { // If the current element matches the candidate, increment count
                count++;
            } else { // If the current element is different, decrement count
                count--;
            }
        }

        return candidate; // The candidate is the majority element
    }

}
