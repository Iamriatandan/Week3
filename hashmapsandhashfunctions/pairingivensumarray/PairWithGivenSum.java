package hashmapsandhashfunctions.pairingivensumarray;
import java.util.*;

public class PairWithGivenSum {

    // Function to check if a pair with the given sum exists
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            // Check if the complement exists in the set
            if (seenNumbers.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }

            // Add the current number to the set
            seenNumbers.add(num);
        }

        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 2, 9, 5};
        int target = 11;

        if (!hasPairWithSum(arr, target)) {
            System.out.println("No pair with sum " + target + " found.");
        }
    }
}

