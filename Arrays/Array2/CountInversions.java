package Array2;

public class CountInversions {

    public static void main(String[] args) {
        CountInversions ci = new CountInversions();
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(ci.countInversions(arr)); // Output: 10
    }

    // Function to count the number of inversions in an array
    // The function takes an array of integers as input and returns the total number of inversions
    // An inversion is a pair (i, j) such that i < j and arr[i] > arr[j]
    // The function uses a divide and conquer approach (modified merge sort) to solve the problem
    // The time complexity of the function is O(n log n), where n is the length of the array. The space complexity is O(n) due to the temporary array used during the merge step.

    // Approach: Use the merge sort algorithm to count inversions while sorting the array.
    // During the merge step, if an element from the right half is smaller than an element from the left half,
    // then all remaining elements in the left half are greater than this element, forming inversions.
    // Count these inversions and add them to the total count.
    public int countInversions(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n]; // Temporary array for merge step
        return mergeSort(arr, temp, 0, n - 1); // Call merge sort to count inversions
    }

    // Recursive merge sort function to count inversions
    private int mergeSort(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2; // Find the middle point to divide the array

            invCount += mergeSort(arr, temp, left, mid); // Count inversions in the left half
            invCount += mergeSort(arr, temp, mid + 1, right); // Count inversions in the right half
            invCount += merge(arr, temp, left, mid, right); // Count cross inversions while merging
        }
        return invCount;
    }

    // Merge function to merge two sorted halves and count cross inversions
    private int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // Starting index for the left subarray
        int j = mid + 1; // Starting index for the right subarray
        int k = left; // Starting index for the temporary array
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) { // If the left element is smaller or equal, no inversion
                temp[k++] = arr[i++];
            } else { // If the right element is smaller, all remaining left elements form inversions with this element
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // Count inversions: all elements from i to mid are greater than arr[j]
            }
        }

        // Copy remaining elements from the left subarray (if any)
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the right subarray (if any)
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the merged elements back to the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

}
