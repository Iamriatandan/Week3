package stacksandqueues.stockspan;

import java.util.*;

public class StockSpan {

    // Function to calculate span for each day
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // Result array to store spans
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        // Process each day's price
        for (int i = 0; i < n; i++) {
            // Remove all indices with prices less than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // Calculate span:
            // If stack is empty, all previous prices were smaller => span = i + 1
            // Else, span = current index - previous higher price's index
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push current index onto the stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        System.out.println("Stock Prices:  " + Arrays.toString(prices));
        System.out.println("Stock Spans:   " + Arrays.toString(span));
    }
}
