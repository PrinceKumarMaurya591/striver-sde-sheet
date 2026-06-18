package Heap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class KMostFrequentWords {

    public static void main(String[] args) {
        KMostFrequentWords kw = new KMostFrequentWords();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> result = kw.topKFrequent(words, k);
        System.out.println(result); // Output: [i, love]
    }

    // Function to find the k most frequent words in an array of strings
    // The function takes an array of strings and an integer k as input and returns a list of the k most frequent words
    // The function uses a hashmap to count frequencies and a min-heap to keep track of the top k words
    // The time complexity of the function is O(n log k), where n is the total number of words. The space complexity is O(n) for the hashmap and the heap.

    // Approach: Count the frequency of each word using a hashmap.
    // Use a min-heap to store the words based on their frequency (and lexicographical order for ties).
    // For each word in the hashmap, add it to the heap. If the heap size exceeds k, remove the word with the smallest frequency (or lexicographically larger if frequencies are equal).
    // After processing all words, extract the words from the heap and return them in reverse order (most frequent first).
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a min-heap to keep the k most frequent words
        // If frequencies are different, compare by frequency (smaller frequency = higher priority to remove)
        // If frequencies are equal, compare by word in reverse order (lexicographically larger word = higher priority to remove)
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (a, b) -> {
                int freqCompare = frequencyMap.get(a) - frequencyMap.get(b);
                if (freqCompare == 0) {
                    return b.compareTo(a); // For tie, larger word has higher priority to be removed (since we want smaller word in result)
                }
                return freqCompare;
            }
        );

        for (String word : frequencyMap.keySet()) {
            minHeap.offer(word); // Add the current word to the heap

            if (minHeap.size() > k) { // If the heap size exceeds k, remove the word with the smallest frequency
                minHeap.poll();
            }
        }

        // Step 3: Extract the words from the heap and return them in descending order of frequency
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll()); // Add words from the heap to the result list
        }

        // Reverse the list to get the most frequent words first (since min-heap gives smallest frequency first)
        java.util.Collections.reverse(result);

        return result;
    }

}
