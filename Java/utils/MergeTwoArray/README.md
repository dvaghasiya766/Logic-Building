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
# Merge Two Sorted Arrays

## 📋 Problem Statement

You are given two arrays, `arr1` and `arr2`, with sizes `m` and `n` respectively:

- `arr1` is sorted in non-decreasing (ascending) order and has size `m + n` where the first `m` elements are the valid data and the rest are empty slots to accommodate `arr2`.
- `arr2` is sorted in non-increasing (descending) order and has size `n`.

Task: Merge `arr2` into `arr1` in-place so that `arr1` becomes fully sorted in non-decreasing order.

Constraint: Do not use extra space (i.e., merge without allocating another array).

### Example

```

Input:
arr1 = [1, 3, 5, 7, 0, 0, 0, 0] (m = 4)
arr2 = [8, 6, 4, 2] (n = 4)

Output:
arr1 = [1, 2, 3, 4, 5, 6, 7, 8]

````

---

## 💡 Explanation

Because `arr1` has extra space at the end and `arr2` is reverse-sorted, the safe approach is to fill `arr1` from the back. Compare the largest candidates from both arrays and place the larger one at the end of `arr1`. This prevents overwriting elements in `arr1` that haven't been processed yet.

---

## 🧠 Logic (Step-by-step)

1. Set pointers:
   - `i = m - 1` (end of valid data in `arr1`)
   - `j = 0` (start of `arr2`, which contains largest elements first)
   - `k = m + n - 1` (last index of `arr1`)

2. While `i >= 0` and `j < n`:
   - If `arr1[i] > arr2[j]`, set `arr1[k] = arr1[i]` and decrement `i` and `k`.
   - Else, set `arr1[k] = arr2[j]` and increment `j`, decrement `k`.

3. If any elements remain in `arr2` (i.e., `j < n`), copy them into `arr1`.
   Elements remaining in `arr1` (if any) are already in correct positions.

---

## 💻 Code Implementation

```java
package utils.MergeTwoArray;

public class MergeTwoArray {

    /**
     * Merge arr2 into arr1 in-place. Assumes arr1 has size m+n and first m elements are valid.
     * arr1: sorted ascending, arr2: sorted descending
     */
    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int i = m - 1;      // last valid in arr1
        int j = 0;          // first (largest) in arr2 (desc order)
        int k = m + n - 1;  // last index in arr1

        while (i >= 0 && j < n) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j++];
            }
        }

        while (j < n) { // remaining from arr2
            arr1[k--] = arr2[j++];
        }
    }

    // Simple test
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 0, 0, 0, 0};
        int[] arr2 = {8, 6, 4, 2};
        merge(arr1, arr2, 4, 4);
        System.out.println(java.util.Arrays.toString(arr1)); // [1,2,3,4,5,6,7,8]
    }
}
````

---

## ⏱ Complexity

- Time: O(m + n) — each element is processed at most once
- Space: O(1) — in-place merge, no extra arrays

---

## Example Walkthrough

Given the input above, we compare `arr1[3]=7` with `arr2[0]=8`, place 8 at the end, and continue until all elements are merged.

---

## Tips for Students

- Always check the sorting order of both arrays before choosing pointer directions.
- When merging in-place, prefer filling from the side with free space to avoid overwrites.
- Draw a quick diagram and simulate a few steps to confirm your pointer movements.
