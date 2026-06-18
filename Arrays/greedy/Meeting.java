package greedy;

import java.util.Arrays;

public class Meeting {


    public static void main(String[] args) {
        Meeting meeting = new Meeting();
        int [] start = {0, 5, 15};
        int [] end = {30, 10, 20};
        System.out.println(meeting.countMeeting(start, end)); // Output: false
    }

// Function to count the maximum number of meetings that can be held in one room
// The function takes two arrays as input: start and end, which represent the start and end times of the meetings respectively
// The function returns an integer representing the maximum number of meetings that can be held in one room
// The function uses a greedy approach to solve the problem by sorting the meetings based on their end times and iterating through them to count the maximum number of meetings that can be held without overlapping
// The time complexity of the function is O(n log n) due to the sorting step, where n is the number of meetings. The space complexity is O(n) due to the creation of the 2D array to hold the start and end times of the meetings.

    //N meeting in one room
    public int countMeeting(int[] start, int[] end) {
        
        
        int n = start.length;
        // Create a 2D array to hold the start and end times of meetings
        int[][] meetings = new int[n][2];

        // Create an array of meetings with start and end times
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        // Sort the meetings based on their end times
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 1; // At least one meeting can be held
        int lastEndTime = meetings[0][1];// Initialize the end time of the last meeting

        // Iterate through the sorted meetings and count the maximum number of meetings that can be held
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] >= lastEndTime) {// If the start time of the current meeting is greater than or equal to the end time of the last meeting
                count++;   
                lastEndTime = meetings[i][1]; // Update the end time of the last meeting to the end time of the current meeting
            }
        }

        return count;
       

       
    }
    
}
