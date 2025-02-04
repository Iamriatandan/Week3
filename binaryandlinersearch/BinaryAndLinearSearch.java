package binaryandlinersearch;
import java.util.Arrays;
public class BinaryAndLinearSearch {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1, 5, 2}; // Unsorted list with missing positive numbers
        int target = 4;

        // Finding the first missing positive integer
        int missingPositive = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + missingPositive);

        // Sorting the array before performing binary search
        Arrays.sort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));

        // Performing binary search for the target
        int index = binarySearch(nums, target);
        System.out.println("Index of target " + target + ": " + index);
    }

    // Function to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Mark out-of-range and negative numbers as n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Mark visited numbers using negative marking
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n && nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1]; // Mark as visited
            }
        }

        // Step 3: Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1; // If all numbers are present, return n+1
    }

    // Function to perform Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1; // Target not found
    }
}
