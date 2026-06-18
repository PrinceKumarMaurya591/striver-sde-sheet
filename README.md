# 🚀 Striver SDE Sheet — Java Solutions

> A curated collection of solutions to the **Striver SDE Sheet** problems, written in Java with interview-ready approach explanations.

---

## 📖 Table of Contents

- [Arrays — Part 1](#arrays---part-1)
- [Arrays — Part 2](#arrays---part-2)
- [Arrays — Part 3](#arrays---part-3)
- [Arrays — Part 4](#arrays---part-4)
- [Greedy Algorithms](#greedy-algorithms)
- [Heap / Priority Queue](#heap--priority-queue)

---

## Arrays — Part 1

### 1. Set Matrix Zeroes

| File | Time | Space |
|------|------|-------|
| [`SetMatrix0.java`](Arrays/Array1/SetMatrix0.java) | O(m × n) | O(1) |

**Tell the interviewer:** "I'll use the first row and first column as markers instead of using extra space. I'll first check if the first row/col have any zeros initially and store that in flags. Then I'll traverse the rest of the matrix, and whenever I find a zero, I'll mark the corresponding first row and first column elements as zero. Finally, I'll use these marks to set the actual cells to zero, and then handle the first row and column separately based on the flags."

### 2. Pascal's Triangle

| File | Time | Space |
|------|------|-------|
| [`PascalTriange.java`](Arrays/Array1/PascalTriange.java) | O(numRows²) | O(numRows²) |

**Tell the interviewer:** "I'll build the triangle row by row. For each row, the first and last elements are always 1. For middle elements, I'll compute the value as the sum of the two elements directly above it from the previous row. This is a straightforward DP approach where each row depends on the previous row."

### 3. Next Permutation

| File | Time | Space |
|------|------|-------|
| [`NextPermuttion.java`](Arrays/Array1/NextPermuttion.java) | O(n) | O(1) |

**Tell the interviewer:** "I'll find the first decreasing element from the right end, let's call it the 'break point'. If I find it, I'll swap it with the next larger element to its right. Then I'll reverse the portion to the right of the break point. This gives us the next lexicographically greater permutation. If no break point exists, I'll just reverse the entire array."

---

## Arrays — Part 2

### 4. Rotate Matrix (90° Clockwise)

| File | Time | Space |
|------|------|-------|
| [`RotateMatrix.java`](Arrays/Array2/RotateMatrix.java) | O(n²) | O(1) |

**Tell the interviewer:** "I'll do this in two steps. First, I'll **transpose** the matrix (swap `matrix[i][j]` with `matrix[j][i]`). Then, I'll **reverse each row** of the transposed matrix. This gives a 90° clockwise rotation. Both operations are done in-place without any extra space."

### 5. Merge Overlapping Intervals

| File | Time | Space |
|------|------|-------|
| [`MergeIntervals.java`](Arrays/Array2/MergeIntervals.java) | O(n log n) | O(n) |

**Tell the interviewer:** "I'll sort the intervals by their start times. Then I'll iterate through the sorted list. If the current interval's start is less than or equal to the last merged interval's end, they overlap, so I'll merge them by updating the end time to `max(currentEnd, nextEnd)`. Otherwise, I'll add the current interval as a new entry to the result list."

### 6. Merge Two Sorted Arrays (Without Extra Space)

| File | Time | Space |
|------|------|-------|
| [`MergeSortedArrays.java`](Arrays/Array2/MergeSortedArrays.java) | O((n+m) log(n+m)) | O(1) |

**Tell the interviewer:** "I'll use the **Gap Method** (inspired by Shell sort). I'll start with a gap of `ceil((n+m)/2)` and compare elements that are `gap` distance apart. If they're out of order, I'll swap them. I'll keep reducing the gap by half until it becomes 0. This ensures both arrays are sorted without any extra space."

### 7. Find the Duplicate Number

| File | Time | Space |
|------|------|-------|
| [`FindDuplicate.java`](Arrays/Array2/FindDuplicate.java) | O(n) | O(1) |

**Tell the interviewer:** "I'll treat the array as a linked list where each index points to the value at that index as the next node. Since there's a duplicate, there must be a cycle. I'll use **Floyd's Tortoise and Hare** algorithm — first detect the intersection point of slow and fast pointers, then find the start of the cycle. That starting point is the duplicate number."

### 8. Repeat and Missing Number

| File | Time | Space |
|------|------|-------|
| [`RepeatAndMissing.java`](Arrays/Array2/RepeatAndMissing.java) | O(n) | O(1) |

**Tell the interviewer:** "I'll use a mathematical approach. Let R be the repeating number and M be the missing number. I'll calculate the actual sum and sum of squares of the array. Then I'll compare them with the expected sum and sum of squares for numbers 1 to n. The difference in sums gives `R - M`, and the difference in sum of squares gives `R² - M² = (R-M)(R+M)`. Solving these two equations gives me both R and M."

### 9. Count Inversions

| File | Time | Space |
|------|------|-------|
| [`CountInversions.java`](Arrays/Array2/CountInversions.java) | O(n log n) | O(n) |

**Tell the interviewer:** "I'll use a **modified merge sort**. While merging two sorted halves, if an element from the right half is smaller than an element from the left half, then all remaining elements in the left half are greater than this element, forming inversions. I'll count these and add them to the total. This way, I count inversions while sorting."

---

## Arrays — Part 3

### 10. Search in a 2D Matrix

| File | Time | Space |
|------|------|-------|
| [`Search2DMatrix.java`](Arrays/Array3/Search2DMatrix.java) | O(log(m×n)) | O(1) |

**Tell the interviewer:** "I'll treat the matrix as a flattened sorted array and apply **binary search**. The mid index can be mapped to row and column using `row = mid / n` and `col = mid % n`. I'll compare the element at this position with the target and adjust the search range accordingly."

### 11. Pow(x, n)

| File | Time | Space |
|------|------|-------|
| [`PowXN.java`](Arrays/Array3/PowXN.java) | O(log n) | O(1) |

**Tell the interviewer:** "I'll use **binary exponentiation**. I'll handle negative exponents by taking the reciprocal of x and making n positive. Then, I'll keep squaring x and dividing n by 2. At each step, if the current bit of n is 1 (odd), I'll multiply the result by the current value of x. This gives O(log n) time complexity."

### 12. Majority Element (> n/2)

| File | Time | Space |
|------|------|-------|
| [`MajorityElement1.java`](Arrays/Array3/MajorityElement1.java) | O(n) | O(1) |

**Tell the interviewer:** "I'll use the **Boyer-Moore Voting Algorithm**. I'll maintain a candidate and a count. When I see the candidate again, I increment the count; when I see a different element, I decrement it. If count becomes 0, I pick the current element as the new candidate. The element left at the end is the majority element since it appears more than n/2 times."

### 13. Majority Element (> n/3)

| File | Time | Space |
|------|------|-------|
| [`MajorityElement2.java`](Arrays/Array3/MajorityElement2.java) | O(n) | O(1) |

**Tell the interviewer:** "At most 2 elements can appear more than n/3 times. I'll extend the **Boyer-Moore algorithm** to track 2 candidates. In the first pass, I'll find the top 2 potential candidates. In the second pass, I'll verify their actual counts. I'll add those exceeding the n/3 threshold to the result."

### 14. Grid Unique Paths

| File | Time | Space |
|------|------|-------|
| [`UniquePaths.java`](Arrays/Array3/UniquePaths.java) | O(min(m,n)) | O(1) |

**Tell the interviewer:** "This is a combinatorial problem. The robot needs `(m-1)` down moves and `(n-1)` right moves, totaling `(m+n-2)` moves. The number of unique paths is the number of ways to choose `(m-1)` down moves from the total, which is `C(m+n-2, m-1)`. I'll compute this efficiently by choosing the smaller of the two for the loop to avoid overflow."

### 15. Reverse Pairs

| File | Time | Space |
|------|------|-------|
| [`ReversePairs.java`](Arrays/Array3/ReversePairs.java) | O(n log n) | O(n) |

**Tell the interviewer:** "I'll use a **modified merge sort**. Before merging two sorted halves, I'll count the reverse pairs where `nums[i] > 2 * nums[j]`. Since both halves are sorted, I can use two pointers — for each element in the left half, I'll find how many elements in the right half satisfy the condition. After counting, I'll merge the halves as usual."

---

## Arrays — Part 4

### 16. Two Sum

| File | Time | Space |
|------|------|-------|
| [`TwoSum.java`](Arrays/Array4/TwoSum.java) | O(n) | O(n) |

**Tell the interviewer:** "I'll use a **HashMap** to store each element and its index as I traverse the array. For each element, I'll compute its complement (`target - current`). If the complement already exists in the map, I've found my pair and I'll return both indices. This gives O(1) lookup for each element."

### 17. Four Sum

| File | Time | Space |
|------|------|-------|
| [`FourSum.java`](Arrays/Array4/FourSum.java) | O(n³) | O(1) |

**Tell the interviewer:** "I'll sort the array first. I'll fix the first two elements using two nested loops, skipping duplicates at each level. Then I'll use **two pointers** (left and right) to find the remaining two elements. If the sum equals the target, I'll add the quadruplet and skip duplicates for the pointer positions. If the sum is less, I'll move the left pointer up; if more, I'll move the right pointer down."

### 18. Longest Consecutive Sequence

| File | Time | Space |
|------|------|-------|
| [`LongestConsecutiveSequence.java`](Arrays/Array4/LongestConsecutiveSequence.java) | O(n) | O(n) |

**Tell the interviewer:** "I'll add all elements to a **HashSet** for O(1) lookups. Then, I'll iterate through the array and only start counting when I find the start of a sequence (i.e., `num-1` is not in the set). From each start, I'll count consecutive numbers upward. I'll keep track of the maximum length found."

### 19. Largest Subarray with 0 Sum

| File | Time | Space |
|------|------|-------|
| [`LargestSubarrayZeroSum.java`](Arrays/Array4/LargestSubarrayZeroSum.java) | O(n) | O(n) |

**Tell the interviewer:** "I'll compute a running **prefix sum** as I traverse. I'll store the first occurrence of each prefix sum in a HashMap. If the same prefix sum appears again, the subarray between those two indices has a sum of 0. If the prefix sum itself becomes 0, the subarray from index 0 is a zero-sum subarray. I'll track the maximum length."

### 20. Count Subarrays with XOR = K

| File | Time | Space |
|------|------|-------|
| [`SubarraysXOR.java`](Arrays/Array4/SubarraysXOR.java) | O(n) | O(n) |

**Tell the interviewer:** "I'll maintain a running **prefix XOR** and a HashMap storing the frequency of each prefix XOR value. At each index, if `prefixXOR == target`, I'll increment the count. Additionally, if `prefixXOR ^ target` exists in the map, it means there are subarrays ending at this index whose XOR is equal to the target, so I'll add their frequency to the count."

### 21. Longest Substring Without Repeating Characters

| File | Time | Space |
|------|------|-------|
| [`LongestSubstringNoRepeat.java`](Arrays/Array4/LongestSubstringNoRepeat.java) | O(n) | O(min(n,m)) |

**Tell the interviewer:** "I'll use a **sliding window** with two pointers. I'll maintain a HashMap of characters and their most recent indices. As I expand the right pointer, if I encounter a character already in the window, I'll move the left pointer to the right of its previous occurrence. At each step, I'll update the maximum window length."

---

## Greedy Algorithms

### 22. N Meetings in One Room

| File | Time | Space |
|------|------|-------|
| [`Meeting.java`](Arrays/greedy/Meeting.java) | O(n log n) | O(n) |

**Tell the interviewer:** "I'll sort meetings by their **end times** (greedy choice: finish early = more room for others). I'll select the first meeting, then iterate through the rest. I'll select a meeting only if its start time is after or equal to the last selected meeting's end time. This maximizes the count."

### 23. Minimum Number of Platforms

| File | Time | Space |
|------|------|-------|
| [`MinimumPlateform.java`](Arrays/greedy/MinimumPlateform.java) | O(n log n) | O(1) |

**Tell the interviewer:** "I'll sort arrival and departure times separately. I'll use two pointers — one for arrivals and one for departures. If the next event is an arrival, I'll increment platform count; if it's a departure, I'll decrement it. I'll track the maximum platform count at any point, which is the answer."

### 24. Job Sequencing Problem

| File | Time | Space |
|------|------|-------|
| [`JobSequencing.java`](Arrays/greedy/JobSequencing.java) | O(n log n + n × d) | O(d) |

**Tell the interviewer:** "I'll sort jobs by profit in descending order. Then, for each job, I'll try to schedule it in the latest available time slot before its deadline. I'll use a boolean array to track occupied slots. This ensures maximum profit by prioritizing high-profit jobs."

### 25. Minimum Coins (Coin Change — Greedy)

| File | Time | Space |
|------|------|-------|
| [`MinCoins.java`](Arrays/greedy/MinCoins.java) | O(n) | O(1) |

**Tell the interviewer:** "I'll assume the coin denominations are sorted and the coin system is canonical (like Indian currency). I'll iterate from the largest denomination down to the smallest. For each denomination, I'll take as many coins as possible (greedy choice) and reduce the amount accordingly. This works for standard currency systems."

### 26. Assign Cookies

| File | Time | Space |
|------|------|-------|
| [`AssignCookies.java`](Arrays/greedy/AssignCookies.java) | O(n log n) | O(1) |

**Tell the interviewer:** "I'll sort both the children's greed factors and cookie sizes. I'll use two pointers — for each child, I'll try to assign the smallest cookie that satisfies their greed. If a cookie satisfies the child, I'll move both pointers forward; otherwise, I'll try a larger cookie. This maximizes the number of content children."

---

## Heap / Priority Queue

### 27. Kth Largest Element in an Array

| File | Time | Space |
|------|------|-------|
| [`KthLargestElement.java`](Heap/KthLargestElement.java) | O(n log k) | O(k) |

**Tell the interviewer:** "I'll use a **min-heap of size k**. I'll add elements to the heap one by one. Whenever the heap size exceeds k, I'll remove the smallest element. After processing all elements, the root of the heap is the kth largest element. This is efficient because we only keep track of the k largest elements."

### 28. Kth Smallest Element in an Array

| File | Time | Space |
|------|------|-------|
| [`KthSmallestElement.java`](Heap/KthSmallestElement.java) | O(n log k) | O(k) |

**Tell the interviewer:** "I'll use a **max-heap of size k**. I'll add elements to the heap one by one. If the heap size exceeds k, I'll remove the largest element. After processing all elements, the root of the max-heap is the kth smallest element, because we've kept only the k smallest elements and the largest among them is the answer."

### 29. Top K Frequent Elements

| File | Time | Space |
|------|------|-------|
| [`TopKFrequentElements.java`](Heap/TopKFrequentElements.java) | O(n log k) | O(n) |

**Tell the interviewer:** "First, I'll count frequencies using a HashMap. Then, I'll use a **min-heap** to keep track of the top k frequent elements. I'll add each entry to the heap, and if the heap exceeds k, I'll remove the one with the smallest frequency. Finally, I'll extract the keys from the heap. The heap ensures we always keep the k most frequent elements."

### 30. Find Median from Data Stream

| File | Time | Space |
|------|------|-------|
| [`MedianFromDataStream.java`](Heap/MedianFromDataStream.java) | O(log n) per add | O(n) |

**Tell the interviewer:** "I'll use **two heaps** — a **max-heap** for the left half (smaller numbers) and a **min-heap** for the right half (larger numbers). I'll maintain the invariant that the max-heap has at most one more element than the min-heap. The median is either the root of the max-heap (if sizes differ) or the average of both roots (if sizes are equal)."

### 31. Merge K Sorted Lists

| File | Time | Space |
|------|------|-------|
| [`MergeKSortedLists.java`](Heap/MergeKSortedLists.java) | O(n log k) | O(k) |

**Tell the interviewer:** "I'll use a **min-heap** and insert the head of each linked list. Then, I'll repeatedly poll the smallest node from the heap, add it to the result list, and if the polled node has a next node, I'll push it into the heap. This way, I always extract the smallest available element and maintain k heads in the heap."

### 32. Top K Frequent Words

| File | Time | Space |
|------|------|-------|
| [`KMostFrequentWords.java`](Heap/KMostFrequentWords.java) | O(n log k) | O(n) |

**Tell the interviewer:** "I'll count frequencies using a HashMap. Then, I'll use a **min-heap** with a custom comparator that sorts by frequency (ascending) and then lexicographically (descending for tie-breaking). I'll add words to the heap; if size exceeds k, I'll remove the top. After processing, I'll extract and reverse the heap to get words sorted by decreasing frequency."

---

## 📊 Quick Reference — Time & Space Complexities

| Problem | Time Complexity | Space Complexity | Key Technique |
|---------|:--------------:|:----------------:|:-------------:|
| Set Matrix Zeroes | O(m×n) | O(1) | In-place marking |
| Pascal's Triangle | O(n²) | O(n²) | DP row-by-row |
| Next Permutation | O(n) | O(1) | Break point + reverse |
| Rotate Matrix | O(n²) | O(1) | Transpose + reverse rows |
| Merge Intervals | O(n log n) | O(n) | Sort + greedy |
| Merge Sorted Arrays | O((n+m) log(n+m)) | O(1) | Gap method |
| Find Duplicate | O(n) | O(1) | Floyd's cycle detection |
| Repeat & Missing | O(n) | O(1) | Sum & sum of squares |
| Count Inversions | O(n log n) | O(n) | Modified merge sort |
| Search 2D Matrix | O(log(mn)) | O(1) | Binary search |
| Pow(x, n) | O(log n) | O(1) | Binary exponentiation |
| Majority Element (n/2) | O(n) | O(1) | Boyer-Moore voting |
| Majority Element (n/3) | O(n) | O(1) | Extended Boyer-Moore |
| Unique Paths | O(min(m,n)) | O(1) | Combinatorics (nCr) |
| Reverse Pairs | O(n log n) | O(n) | Modified merge sort |
| Two Sum | O(n) | O(n) | HashMap |
| Four Sum | O(n³) | O(1) | Sort + two pointers |
| Longest Consecutive Seq | O(n) | O(n) | HashSet |
| Largest Subarray 0 Sum | O(n) | O(n) | Prefix sum + HashMap |
| Subarrays XOR = K | O(n) | O(n) | Prefix XOR + HashMap |
| Longest Substring | O(n) | O(min(n,m)) | Sliding window |
| N Meetings | O(n log n) | O(n) | Sort by end time |
| Min Platforms | O(n log n) | O(1) | Two pointers |
| Job Sequencing | O(n log n) | O(d) | Sort by profit |
| Min Coins | O(n) | O(1) | Greedy denominations |
| Assign Cookies | O(n log n) | O(1) | Sort + two pointers |
| Kth Largest | O(n log k) | O(k) | Min-heap of size k |
| Kth Smallest | O(n log k) | O(k) | Max-heap of size k |
| Top K Frequent | O(n log k) | O(n) | Freq map + min-heap |
| Median from Stream | O(log n) | O(n) | Two heaps |
| Merge K Sorted Lists | O(n log k) | O(k) | Min-heap of heads |
| Top K Frequent Words | O(n log k) | O(n) | Freq map + min-heap |

---

> 💡 **Pro Tip:** When explaining to an interviewer, always start with the brute force approach, then optimize. The key is to communicate your **thought process** — mention the pattern you recognize, why you chose a particular data structure, and the trade-offs involved.
