package BinarySearch;

public class AllocatePages {

    public static void main(String[] args) {
        AllocatePages ap = new AllocatePages();
        int[] books = {12, 34, 67, 90};
        int students = 2;
        System.out.println(ap.allocateBooks(books, students)); // Output: 113
    }

    // Function to find the minimum possible maximum number of pages allocated to a student
    // The function takes an array of book pages and a number of students as input and returns the minimum possible maximum pages
    // The function uses a binary search approach on the answer to solve the problem
    // The time complexity of the function is O(n log sum), where n is the number of books and sum is the total number of pages. The space complexity is O(1) as we are using a constant amount of extra space.

    // Approach: The answer lies between max(books) and sum(books).
    // Use binary search to find the minimum possible maximum pages.
    // For each mid value, check if it is feasible to allocate books to all students such that no student gets more than mid pages.
    // If feasible, try a smaller maximum (move right = mid - 1). Otherwise, try a larger maximum (move left = mid + 1).
    public int allocateBooks(int[] books, int students) {
        if (students > books.length) { // If there are more students than books, allocation is impossible
            return -1;
        }

        int low = 0; // Minimum possible max pages (at least the largest book)
        int high = 0; // Maximum possible max pages (sum of all pages)

        for (int pages : books) {
            low = Math.max(low, pages); // At least one student must read the largest book
            high += pages; // One student could read all books
        }

        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Guess for the maximum pages a student can read

            if (isFeasible(books, students, mid)) {
                result = mid; // This is a possible answer, try a smaller maximum
                high = mid - 1;
            } else {
                low = mid + 1; // Need a larger maximum
            }
        }

        return result;
    }

    // Helper function to check if it is feasible to allocate books with a given maximum pages per student
    private boolean isFeasible(int[] books, int students, int maxPages) {
        int studentCount = 1; // Start with the first student
        int currentPages = 0; // Pages assigned to the current student

        for (int pages : books) {
            if (currentPages + pages > maxPages) {
                // Assign the remaining books to the next student
                studentCount++;
                currentPages = pages;

                if (studentCount > students) { // If we need more students than available, not feasible
                    return false;
                }
            } else {
                currentPages += pages; // Add pages to the current student
            }
        }

        return true; // Allocation is feasible
    }

}
