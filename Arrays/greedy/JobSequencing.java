package greedy;


// Function to find the maximum profit that can be earned by scheduling jobs within their deadlines
// The function takes two arrays as input: profit and deadline, which represent the profit and deadline of the jobs respectively
// The function returns an integer representing the maximum profit that can be earned by scheduling the jobs within their deadlines
// The function uses a greedy approach to solve the problem by sorting the jobs based on their profit and iterating through them to schedule the jobs within their deadlines while maximizing the profit
// The time complexity of the function is O(n log n) due to the sorting step, where n is the number of jobs. The space complexity is O(n) due to the creation of the 2D array to hold the profit and deadline of the jobs.  

//Approach: Sort the jobs in descending order of profit. 
// Iterate through the sorted jobs and for each job, find a time slot from its deadline to 1.
// If a time slot is found, schedule the job and add its profit to the total profit.


public class JobSequencing {

    public static void main(String[] args) {
        JobSequencing js = new JobSequencing();
        int[] profit = {20, 15, 10, 5, 1};
        int[] deadline = {2, 2, 1, 3, 3};
        System.out.println(js.jobScheduling(profit, deadline)); // Output: 40
    }


    public int jobScheduling(int[] profit, int[] deadline) {
        int n = profit.length;
        // Create a 2D array to hold the profit and deadline of jobs
        int[][] jobs = new int[n][2];

        // Create an array of jobs with profit and deadline
        for (int i = 0; i < n; i++) {
            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];
        }

        // Sort the jobs in descending order of profit
        java.util.Arrays.sort(jobs, (a, b) -> b[0] - a[0]);

        // Find the maximum deadline to determine the size of the time slot array
        int maxDeadline = 0;
        // Iterate through the jobs to find the maximum deadline
        for (int i = 0; i < n; i++) {
            if (jobs[i][1] > maxDeadline) {
                maxDeadline = jobs[i][1];
            }
        }
// Create a boolean array to keep track of occupied time slots up to the maximum deadline 

        boolean[] timeSlot = new boolean[maxDeadline + 1]; // To keep track of occupied time slots
        int totalProfit = 0;

        // Iterate through the sorted jobs and schedule them
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(maxDeadline, jobs[i][1]); j > 0; j--) { // Find a time slot from deadline to 1
                if (!timeSlot[j]) { // If the time slot is free
                    timeSlot[j] = true; // Mark the time slot as occupied
                    totalProfit += jobs[i][0]; // Add the profit of the job to total profit
                    break; // Move to the next job
                }
            }
        }

        return totalProfit;
    }


    
}
