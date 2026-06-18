package Array2;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        MergeSortedArrays msa = new MergeSortedArrays();
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        msa.merge(arr1, arr2);
        // Output the merged arrays
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }

    // Function to merge two sorted arrays without using any extra space
    // The function takes two sorted arrays as input and modifies them in place so that the first array contains the smallest elements and the second array contains the largest elements
    // The function uses a greedy approach with the gap method (Shell sort technique) to solve the problem
    // The time complexity of the function is O((n + m) log(n + m)), where n and m are the lengths of the two arrays. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: Use the gap method (inspired by Shell sort).
    // Start with a gap of (n + m + 1) / 2 and reduce the gap by half each iteration.
    // Compare elements that are 'gap' distance apart and swap them if they are in the wrong order.
    // Continue until the gap becomes 0, at which point both arrays are sorted.
    public void merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int total = n + m;
        int gap = (total + 1) / 2; // Initial gap value (ceil of half the total length)

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < total) {
                // Case 1: Both elements are in arr1
                if (j < n && arr1[i] > arr1[j]) {
                    swap(arr1, arr1, i, j);
                }
                // Case 2: i is in arr1 and j is in arr2
                else if (i < n && j >= n && arr1[i] > arr2[j - n]) {
                    swap(arr1, arr2, i, j - n);
                }
                // Case 3: Both elements are in arr2
                else if (i >= n && arr2[i - n] > arr2[j - n]) {
                    swap(arr2, arr2, i - n, j - n);
                }
                i++;
                j++;
            }

            if (gap == 1) { // If gap is 1, we are done
                break;
            }
            gap = (gap + 1) / 2; // Reduce the gap for the next iteration (ceil of half)
        }
    }

    // Helper function to swap elements between two arrays (or within the same array)
    private void swap(int[] a, int[] b, int i, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

}
