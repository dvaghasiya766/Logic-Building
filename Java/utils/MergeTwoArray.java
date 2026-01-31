package utils;

// MergeTwoArray class to handle merging of two arrays
// You are given 2 arrays, arr1 and arr2 of sizes m and n respectively.
// arr1 is sorted in non-decreasing order and arr2 is sorted in non-increasing order.
// arr1 has enough space (size m + n) to hold all elements from both arrays.
// Your task is to merge into arr1 so the result is sorted in non-decreasing order.
// Note: You are not allowed to use extra space.
public class MergeTwoArray {

    /**
     * Merges arr2 into arr1 in-place.
     *
     * @param arr1 - sorted ascending, size = m + n (first m elements are data,
     * rest are empty/0)
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
}
