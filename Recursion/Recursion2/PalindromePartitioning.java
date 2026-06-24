package Recursion.Recursion2;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> result = pp.partition(s);
        System.out.println("Palindrome partitions: " + result);
    }

    // Function to partition a string into substrings such that
    // every substring is a palindrome.
    // Time complexity: O(n * 2^n), Space complexity: O(n).

    // Approach: Use backtracking. At each step, try to take a
    // substring starting from the current index. If the substring
    // is a palindrome, add it to the current partition and recurse
    // for the remaining string.
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result,
                           List<String> tempList,
                           String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                tempList.add(substring);
                backtrack(result, tempList, s, end);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
