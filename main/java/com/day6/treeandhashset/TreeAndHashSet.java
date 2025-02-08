package com.day6.treeandhashset;
import java.util.*;
public class TreeAndHashSet {
    public static void main(String[] args) {
        Random random = new Random();
        int[] sizes = {1000, 100000, 1000000}; // Different dataset sizes

        System.out.printf("%-15s %-20s %-20s %-20s\n", "Dataset Size", "Array Search (ms)", "HashSet Search (ms)", "TreeSet Search (ms)");
        System.out.println("------------------------------------------------------------------------------------");

        for (int size : sizes) {
            // Generate dataset
            int[] arrayData = new int[size];
            HashSet<Integer> hashSetData = new HashSet<>();
            TreeSet<Integer> treeSetData = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int num = random.nextInt(size);
                arrayData[i] = num;
                hashSetData.add(num);
                treeSetData.add(num);
            }

            // Pick a random target to search
            int target = random.nextInt(size);

            // Measure search times
            long arrayTime = measureTime(() -> linearSearch(arrayData, target));
            long hashSetTime = measureTime(() -> hashSetData.contains(target));
            long treeSetTime = measureTime(() -> treeSetData.contains(target));

            // Print results
            System.out.printf("%-15d %-20.3f %-20.3f %-20.3f\n",
                    size,
                    arrayTime / 1_000_000.0,
                    hashSetTime / 1_000_000.0,
                    treeSetTime / 1_000_000.0);
        }
    }

    // Linear Search in Array (O(N))
    public static boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // Method to measure execution time
    public static long measureTime(Runnable searchMethod) {
        long startTime = System.nanoTime();
        searchMethod.run();
        return System.nanoTime() - startTime;
    }
}
