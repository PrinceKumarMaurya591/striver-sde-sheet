package greedy;

public class AssignCookies {

    public static void main(String[] args) {
        AssignCookies ac = new AssignCookies();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(ac.findContentChildren(g, s)); // Output: 1
    }

    // Function to find the maximum number of children that can be content with the given cookies
    // The function takes two arrays as input: g and s, which represent the greed factor of the children and the size of the cookies respectively
    // The function returns an integer representing the maximum number of children that can be content with the given cookies
    // The function uses a greedy approach to solve the problem by sorting both arrays and iterating through them to count the number of children that can be content with the given cookies
    // The time complexity of the function is O(n log n) due to the sorting step, where n is the number of children or cookies. The space complexity is O(1) as we are using a constant amount of extra space.  

    //Approach: Sort both the greed factor array and the cookie size array.
    // Use two pointers to iterate through both arrays.
    // If the current cookie can satisfy the current child, increment the count of content children and move both pointers to the next child and cookie.
    // If the current cookie cannot satisfy the current child, move the cookie pointer to the next cookie to try to satisfy the same child.
    // Continue this process until we have iterated through all the children or all the cookies.

    public int findContentChildren(int[] g, int[] s) {
        // Sort the greed factor array and the cookie size array
        java.util.Arrays.sort(g);
        java.util.Arrays.sort(s);

        int count = 0; // To count the number of content children
        int i = 0, j = 0; // Pointers for children and cookies

        // Iterate through both arrays
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // If the current cookie can satisfy the current child
                count++; // Increment the count of content children
                i++; // Move to the next child
                j++; // Move to the next cookie
            } else { // If the current cookie cannot satisfy the current child
                j++; // Move to the next cookie to try to satisfy the same child
            }
        }

        return count; // Return the total count of content children
    }   
    
}
