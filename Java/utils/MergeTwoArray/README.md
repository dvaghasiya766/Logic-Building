# Merge Two Sorted Arrays

## 📋 Problem Statement

You are given **two arrays**, `arr1` and `arr2` of sizes `m` and `n` respectively:

- `arr1` is sorted in **non-decreasing order** (ascending)
- `arr2` is sorted in **non-increasing order** (descending)
- `arr1` has enough space (size = `m + n`) to hold all elements from both arrays

**Task:** Merge `arr2` into `arr1` so that the result is sorted in **non-decreasing order**.

**Constraint:** You are **NOT allowed to use extra space** (in-place merge).

### Example

```
Input:
arr1 = [1, 3, 5, 7, 0, 0, 0, 0]  (m = 4, actual elements: 1, 3, 5, 7)
arr2 = [8, 6, 4, 2]              (n = 4, sorted descending)

Output:
arr1 = [1, 2, 3, 4, 5, 6, 7, 8]  (merged and sorted ascending)
```

---

## 💡 Explanation

The key insight here is:

1. **arr1** is sorted in ascending order → smallest at the beginning, largest at the end
2. **arr2** is sorted in descending order → largest at the beginning, smallest at the end
3. **arr1** has empty slots at the end to accommodate all elements

Since we cannot use extra space, we need to **fill arr1 from the back** (from the last position). This way, we don't overwrite any existing elements that we still need to compare.

### Why fill from the back?

- The largest elements are at:
  - **End of arr1** (position `m-1`)
  - **Beginning of arr2** (position `0`)
- By comparing these two and placing the larger one at the **last position** of arr1, we ensure no data is lost.

---

## 🧠 Logic (Step-by-Step)

### Algorithm

1. **Initialize three pointers:**
   - `i = m - 1` → Points to the last valid element in arr1
   - `j = 0` → Points to the first (largest) element in arr2
   - `k = m + n - 1` → Points to the last position in arr1 (where we'll place elements)

2. **Compare and place the larger element at position k:**
   - If `arr1[i] > arr2[j]` → Place `arr1[i]` at position `k`, then decrement `i` and `k`
   - Else → Place `arr2[j]` at position `k`, then increment `j` and decrement `k`

3. **Continue until one of the arrays is exhausted:**
   - If arr1 elements are exhausted (`i < 0`), copy remaining arr2 elements
   - If arr2 elements are exhausted (`j >= n`), arr1 elements are already in place

### Visual Walkthrough

```
Initial State:
arr1 = [1, 3, 5, 7, 0, 0, 0, 0]    i=3, k=7
arr2 = [8, 6, 4, 2]                j=0

Step 1: Compare arr1[3]=7 vs arr2[0]=8 → 8 is larger
arr1 = [1, 3, 5, 7, 0, 0, 0, 8]    i=3, j=1, k=6

Step 2: Compare arr1[3]=7 vs arr2[1]=6 → 7 is larger
arr1 = [1, 3, 5, 7, 0, 0, 7, 8]    i=2, j=1, k=5

Step 3: Compare arr1[2]=5 vs arr2[1]=6 → 6 is larger
arr1 = [1, 3, 5, 7, 0, 6, 7, 8]    i=2, j=2, k=4

Step 4: Compare arr1[2]=5 vs arr2[2]=4 → 5 is larger
arr1 = [1, 3, 5, 7, 5, 6, 7, 8]    i=1, j=2, k=3

Step 5: Compare arr1[1]=3 vs arr2[2]=4 → 4 is larger
arr1 = [1, 3, 5, 4, 5, 6, 7, 8]    i=1, j=3, k=2

Step 6: Compare arr1[1]=3 vs arr2[3]=2 → 3 is larger
arr1 = [1, 3, 3, 4, 5, 6, 7, 8]    i=0, j=3, k=1

Step 7: Compare arr1[0]=1 vs arr2[3]=2 → 2 is larger
arr1 = [1, 2, 3, 4, 5, 6, 7, 8]    i=0, j=4, k=0

Loop ends (j >= n), arr1 is now fully merged!
```

---

## 💻 Code Implementation

```java
package utils;

public class MergeTwoArray {

    /**
     * Merges arr2 into arr1 in-place.
     *
     * @param arr1 - sorted ascending, size = m + n (first m elements are data, rest are empty/0)
     * @param arr2 - sorted descending, size = n
     * @param m - number of actual elements in arr1
     * @param n - number of elements in arr2
     */
    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int i = m - 1;      // Last valid element in arr1
        int j = 0;          // First element in arr2 (largest, since arr2 is descending)
        int k = m + n - 1;  // Last position in arr1

        // Compare from largest elements and fill arr1 from the end
        while (i >= 0 && j < n) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j++];
            }
        }

        // Copy remaining elements from arr2 (if any)
        while (j < n) {
            arr1[k--] = arr2[j++];
        }

        // No need to copy remaining arr1 elements - they're already in place
        System.out.println(java.util.Arrays.toString(arr1));
    }

    // Main method to test the merge function
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 0, 0, 0, 0};
        int[] arr2 = {8, 6, 4, 2};
        int m = 4;
        int n = 4;

        merge(arr1, arr2, m, n);
        // Output: [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
```

---

## ⏱️ Time and Space Complexity

| Complexity | Value    | Explanation                                          |
| ---------- | -------- | ---------------------------------------------------- |
| **Time**   | O(m + n) | We traverse each element of both arrays exactly once |
| **Space**  | O(1)     | No extra space used (in-place merge)                 |

---

## 🔑 Key Takeaways

1. **Merge from the back** when one array has extra space at the end
2. **Pointer technique** is essential for in-place operations
3. Understanding the **sorting order** of both arrays helps determine pointer directions
4. This is a variation of the classic **Merge Two Sorted Arrays** problem

---

## 📚 Related Problems

- Merge Sorted Array (LeetCode #88)
- Merge Two Sorted Lists
- Sort Colors (Dutch National Flag Problem)
