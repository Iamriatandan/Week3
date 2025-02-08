package com.day6.stringconcatenationperformance;

public class StringConcatenation {
        public static void main(String[] args) {
            int[] sizes = {1000, 10000, 1000000};

            System.out.printf("%-20s %-15s %-15s %-15s\n", "Operations Count (N)", "String (ms)", "StringBuilder (ms)", "StringBuffer (ms)");
            System.out.println("---------------------------------------------------------------------");

            for (int size : sizes) {
                long stringTime = (size > 10000) ? -1 : measureTime(() -> concatenateUsingString(size));
                long stringBuilderTime = measureTime(() -> concatenateUsingStringBuilder(size));
                long stringBufferTime = measureTime(() -> concatenateUsingStringBuffer(size));

                System.out.printf("%-20d %-15s %-15d %-15d\n",
                        size,
                        (stringTime == -1 ? "Unfeasible" : stringTime / 1_000_000),
                        stringBuilderTime / 1_000_000,
                        stringBufferTime / 1_000_000);
            }
        }

        // Method to concatenate strings using String (O(N²))
        public static void concatenateUsingString(int n) {
            String str = "";
            for (int i = 0; i < n; i++) {
                str += "a"; // Creates a new object each time
            }
        }

        // Method to concatenate using StringBuilder (O(N))
        public static void concatenateUsingStringBuilder(int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        }

        // Method to concatenate using StringBuffer (O(N))
        public static void concatenateUsingStringBuffer(int n) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        }

        // Method to measure execution time
        public static long measureTime(Runnable method) {
            long startTime = System.nanoTime();
            method.run();
            return System.nanoTime() - startTime;
        }
    }
