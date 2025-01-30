package hashmapsandhashfunctions.twosumproblem;

import java.util.HashMap;

public class TwoSum {

    // Function to find two indices that add up to the target sum
    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the index of each element
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                // If found, return the indices (current index and the index of the complement)
                return new int[] {numMap.get(complement), i};
            }

            // Store the current number and its index in the map
            numMap.put(nums[i], i);
        }

        // Return an empty array if no pair is found
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        // Get the result of two indices
        int[] result = twoSum(arr, target);

        if (result.length == 0) {
            System.out.println("No two sum solution.");
        } else {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        }
    }
}

