package utils.MergeTwoArray;

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

        // Need to copy remaining arr2 elements
        if (array2LastIndex >= 0) {
            for (int i = 0; i <= array2LastIndex; i++) {
                arr1[i] = arr2[i];
            }
        }

        // No need to copy remaining arr1 elements - they're already in place
        System.out.println(java.util.Arrays.toString(arr1));
    }
}
