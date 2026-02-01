# Merge Two Sorted Arrays

## 📋 Problem Statement

You are given two arrays, `arr1` and `arr2`, with sizes `m` and `n` respectively:

- `arr1` is sorted in non-decreasing (ascending) order and has size `m + n` where the first `m` elements are valid and the rest are empty slots to accommodate `arr2`.
- `arr2` is sorted in non-decreasing (ascending) order and has size `n`.

Task: Merge `arr2` into `arr1` in-place so that `arr1` becomes fully sorted in non-decreasing order.

Constraint: Do not use extra space (merge without allocating another array).

---

## 💡 Key Idea

Fill `arr1` from the back. Compare the largest elements from the ends of both arrays and place the larger one at the end of `arr1`. This avoids overwriting unprocessed values.

---

## 🧠 Implementation Details (matches `MergeTwoArray.java`)

- Pointers used:
  - `array1LastIndex = m - 1` (last valid element in `arr1`)
  - `array2LastIndex = n - 1` (last element in `arr2`)
  - `sortedArrayLastIndex = m + n - 1` (position to fill in `arr1`)

- While both arrays have elements, place the larger of `arr1[array1LastIndex]` and `arr2[array2LastIndex]` at `arr1[sortedArrayLastIndex]`, then move the corresponding pointer and decrement `sortedArrayLastIndex`.

- After the loop, if `array2LastIndex >= 0`, copy remaining `arr2` elements into the beginning of `arr1`.

---

## 💻 Code (from `MergeTwoArray.java`)

```java
package utils.MergeTwoArray;

public class MergeTwoArray {

    /**
     * Merges arr2 into arr1 in-place. Assumes arr1 length = m + n and
     * first m elements of arr1 are valid. Both arrays are sorted ascending.
     */
    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int array1LastIndex = m - 1;
        int array2LastIndex = n - 1;
        int sortedArrayLastIndex = m + n - 1;

        while (array1LastIndex >= 0 && array2LastIndex >= 0) {
            if (arr1[array1LastIndex] > arr2[array2LastIndex]) {
                arr1[sortedArrayLastIndex] = arr1[array1LastIndex];
                array1LastIndex--;
            } else {
                arr1[sortedArrayLastIndex] = arr2[array2LastIndex];
                array2LastIndex--;
            }
            sortedArrayLastIndex--;
        }

        // Copy remaining arr2 elements (if any) to the start of arr1
        if (array2LastIndex >= 0) {
            for (int i = 0; i <= array2LastIndex; i++) {
                arr1[i] = arr2[i];
            }
        }
    }
}
```

---

## ✅ Example

Input:

```
arr1 = [1, 3, 5, 7, 0, 0, 0, 0]  // m = 4
arr2 = [2, 4, 6, 8]              // n = 4
```

After `merge(arr1, arr2, 4, 4)`:

```
arr1 = [1, 2, 3, 4, 5, 6, 7, 8]
```

---

## ⏱ Complexity

- Time: O(m + n)
- Space: O(1)

---

## 💡 Tips for Students

- Verify the sort order of both arrays before choosing pointer directions.
- Fill from the side with free space to avoid overwrites when merging in-place.

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

````java
# Merge Two Sorted Arrays

## 📋 Problem Statement

You are given two arrays, `arr1` and `arr2`, with sizes `m` and `n` respectively:

- `arr1` is sorted in non-decreasing (ascending) order and has size `m + n` where the first `m` elements are valid and the rest are empty slots to accommodate `arr2`.
- `arr2` is sorted in non-decreasing (ascending) order and has size `n`.

Task: Merge `arr2` into `arr1` in-place so that `arr1` becomes fully sorted in non-decreasing order.

Constraint: Do not use extra space (merge without allocating another array).

---

## 💡 Key Idea

Fill `arr1` from the back. Compare the largest candidates from the ends of both arrays and place the larger one at the end of `arr1`. This prevents overwriting unprocessed elements.

---

## 🧠 Implementation Details (matches `MergeTwoArray.java`)

- Pointers used in the implementation:
  - `array1LastIndex = m - 1` (last valid element in `arr1`)
  - `array2LastIndex = n - 1` (last element in `arr2`)
  - `sortedArrayLastIndex = m + n - 1` (position to fill in `arr1`)

- Loop while both arrays have elements. Place the larger of `arr1[array1LastIndex]` and `arr2[array2LastIndex]` at `arr1[sortedArrayLastIndex]`, then move the corresponding pointer and decrement `sortedArrayLastIndex`.

- After the loop, if `array2LastIndex >= 0`, copy remaining `arr2` elements into the beginning of `arr1`.

---

## 💻 Code (from `MergeTwoArray.java`)

```java
package utils.MergeTwoArray;

public class MergeTwoArray {

    /**
     * Merges arr2 into arr1 in-place. Assumes arr1 length = m + n and
     * first m elements of arr1 are valid. Both arrays are assumed sorted ascending.
     */
    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int array1LastIndex = m - 1;
        int array2LastIndex = n - 1;
        int sortedArrayLastIndex = m + n - 1;

        while (array1LastIndex >= 0 && array2LastIndex >= 0) {
            if (arr1[array1LastIndex] > arr2[array2LastIndex]) {
                arr1[sortedArrayLastIndex] = arr1[array1LastIndex];
                array1LastIndex--;
            } else {
                arr1[sortedArrayLastIndex] = arr2[array2LastIndex];
                array2LastIndex--;
            }
            sortedArrayLastIndex--;
        }

        // Copy remaining arr2 elements (if any) to the start of arr1
        if (array2LastIndex >= 0) {
            for (int i = 0; i <= array2LastIndex; i++) {
                arr1[i] = arr2[i];
            }
        }
    }
}
````

---

## ✅ Example

Input:

```
arr1 = [1, 3, 5, 7, 0, 0, 0, 0]  // m = 4
arr2 = [2, 4, 6, 8]              // n = 4
```

After `merge(arr1, arr2, 4, 4)`:

```
arr1 = [1, 2, 3, 4, 5, 6, 7, 8]
```

---

## ⏱ Complexity

- Time: O(m + n) — each element processed at most once
- Space: O(1) — in-place merge, no extra arrays

---

## 💡 Tips for Students

- Verify the sort order of both arrays before choosing pointer directions.
- When merging in-place, fill from the side with available space to avoid overwrites.
- Walk through a small example on paper to check pointer movements before coding.

---

## Tips for Students

- Always check the sorting order of both arrays before choosing pointer directions.
- When merging in-place, prefer filling from the side with free space to avoid overwrites.
- Draw a quick diagram and simulate a few steps to confirm your pointer movements.
