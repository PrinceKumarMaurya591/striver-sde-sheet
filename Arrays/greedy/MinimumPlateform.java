package greedy;


// Function to find the minimum number of platforms required for the trains to arrive and depart without any delay
// The function takes two arrays as input: arrival and departure, which represent the arrival and departure times of the trains respectively
// The function returns an integer representing the minimum number of platforms required
// The function uses a greedy approach to solve the problem by sorting the arrival and departure times and iterating through them to count the number of platforms required at any given time
// The time complexity of the function is O(n log n) due to the sorting step, where n is the number of trains. The space complexity is O(1) as we are using a constant amount of extra space.

//Approch: Sort the arrival and departure times of the trains. 
// Use two pointers to traverse the arrival and departure arrays. 
// If the next event is an arrival, increment the count of platforms needed. 
// If the next event is a departure, decrement the count of platforms needed. 
// Keep track of the maximum count of platforms needed at any time.
public class MinimumPlateform {

    public static void main(String[] args) {
        MinimumPlateform mp = new MinimumPlateform();
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(mp.findPlatform(arrival, departure));
    }


    public int findPlatform(int[] arrival, int[] departure) {
        int n = arrival.length;
        // Sort the arrival and departure times
        java.util.Arrays.sort(arrival);
        java.util.Arrays.sort(departure);

        int platform_needed = 1, result = 1;
        int i = 1, j = 0;

        // Iterate through the arrival and departure arrays
        while (i < n && j < n) {
            // If next event is an arrival, increment count of platforms needed
            if (arrival[i] <= departure[j]) {
                platform_needed++;
                i++;
            } else { // If next event is a departure, decrement count of platforms needed
                platform_needed--;
                j++;
            }
            // Update result if needed
            if (platform_needed > result) {
                result = platform_needed;
            }
        }

        return result;
    }
    
}
