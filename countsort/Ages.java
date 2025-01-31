package countsort;
import java.util.*;
public class Ages {
    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 14, 13, 17, 16, 11, 15, 10, 12};
        countingSort(ages, 10, 18);
        System.out.println("Sorted student ages: " + Arrays.toString(ages));

    }
    //method to do count sort
    public static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Count occurrences of each age
        for (int num : arr) {
            count[num - min]++;
        }

        // Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in sorted order
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy sorted values back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
