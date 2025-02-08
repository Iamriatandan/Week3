package com.day6.fibonachhiandrecursion;

public class Fibonachhi {

        public static void main(String[] args) {
            int[] testCases = {10, 30, 50}; // Different values of N for comparison

            System.out.printf("%-15s %-20s %-20s\n", "Fibonacci (N)", "Recursive (ms)", "Iterative (ms)");
            System.out.println("---------------------------------------------------------");

            for (int n : testCases) {
                // Measure recursive Fibonacci time (Skip for large N)
                long recursiveTime = (n > 30) ? -1 : measureTime(() -> fibonacciRecursive(n));

                // Measure iterative Fibonacci time
                long iterativeTime = measureTime(() -> fibonacciIterative(n));

                // Print results
                System.out.printf("%-15d %-20s %-20.3f\n",
                        n,
                        (recursiveTime == -1 ? "Unfeasible" : recursiveTime / 1_000_000.0),
                        iterativeTime / 1_000_000.0);
            }
        }

        // Recursive Fibonacci (O(2ⁿ))
        public static int fibonacciRecursive(int n) {
            if (n <= 1) return n;
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }

        // Iterative Fibonacci (O(N))
        public static int fibonacciIterative(int n) {
            if (n <= 1) return n;
            int a = 0, b = 1, sum;
            for (int i = 2; i <= n; i++) {
                sum = a + b;
                a = b;
                b = sum;
            }
            return b;
        }

        // Method to measure execution time
        public static long measureTime(Runnable method) {
            long startTime = System.nanoTime();
            method.run();
            return System.nanoTime() - startTime;
        }
    }

