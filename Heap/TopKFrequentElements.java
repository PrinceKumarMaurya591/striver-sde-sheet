package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements tfe = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = tfe.topKFrequent(nums, k);
        // Output the k most frequent elements
        for (int num : result) {
            System.out.print(num + " "); // Output: 1 2
        }
    }

    // Function to find the k most frequent elements in an array
    // The function takes an array of integers and an integer k as input and returns an array of the k most frequent elements
    // The function uses a hashmap to count frequencies and a min-heap to keep track of the top k elements
    // The time complexity of the function is O(n log k), where n is the length of the array. The space complexity is O(n) for the hashmap and the heap.

    // Approach: First, count the frequency of each element using a hashmap.
    // Then, use a min-heap of size k to store the entries with the highest frequencies.
    // For each entry in the hashmap, add it to the heap. If the heap size exceeds k, remove the entry with the smallest frequency.
    // Finally, extract the elements from the heap and return them.
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a min-heap to keep the k most frequent elements
        // The heap stores map entries, sorted by frequency in ascending order
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry); // Add the current entry to the heap

            if (minHeap.size() > k) { // If the heap size exceeds k, remove the entry with the smallest frequency
                minHeap.poll();
            }
        }

        // Step 3: Extract the elements from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey(); // Get the key (element) from the entry
        }

        return result;
    }

}
