package hashmapsandhashfunctions.findallsubarrayswithzerosum;
import java.util.*;

public class ZeroSumSubarrays {

    // Function to find all zero-sum subarrays
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>(); // List to store subarrays
        Map<Integer, List<Integer>> sumMap = new HashMap<>(); // HashMap to store sum and its indices
        int sum = 0; // Cumulative sum

        // Initialize HashMap with sum 0 at index -1 (for subarrays starting from index 0)
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update cumulative sum

            // If sum exists in HashMap, there are subarrays with zero sum
            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i}); // Store subarray indices
                }
            }

            // Add current index to HashMap for this sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6, -3, 1, 1, -2, 5, 2, -1, -4};
        List<int[]> zeroSumSubarrays = findZeroSumSubarrays(arr);

        if (zeroSumSubarrays.isEmpty()) {
            System.out.println("No zero-sum subarrays found.");
        } else {
            System.out.println("Zero-sum subarrays:");
            for (int[] subarray : zeroSumSubarrays) {
                System.out.println("From index " + subarray[0] + " to " + subarray[1]);
            }
        }
    }
}

