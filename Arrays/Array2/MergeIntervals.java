package Array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mi.merge(intervals);
        // Output the merged intervals
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }

    // Function to merge overlapping intervals
    // The function takes a 2D array of intervals as input and returns a 2D array of merged intervals
    // The function uses a greedy approach to solve the problem by sorting the intervals based on their start times and merging overlapping intervals
    // The time complexity of the function is O(n log n) due to the sorting step, where n is the number of intervals. The space complexity is O(n) to store the merged intervals.

    // Approach: Sort the intervals by their start time.
    // Iterate through the sorted intervals and if the current interval overlaps with the last merged interval,
    // merge them by updating the end time of the last merged interval.
    // If it does not overlap, add the current interval as a new merged interval.
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) { // If there are no intervals or only one interval, return as is
            return intervals;
        }

        // Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>(); // List to store merged intervals
        int[] currentInterval = intervals[0]; // Start with the first interval
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) { // If the current interval overlaps with the next interval
                currentInterval[1] = Math.max(currentEnd, nextEnd); // Merge by updating the end time
            } else { // If the intervals do not overlap
                currentInterval = interval; // Move to the next interval
                merged.add(currentInterval); // Add it as a new merged interval
            }
        }

        return merged.toArray(new int[merged.size()][]); // Convert the list to a 2D array and return
    }

}
