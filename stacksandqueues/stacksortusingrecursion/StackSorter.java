package stacksandqueues.stacksortusingrecursion;
import java.util.*;
public class StackSorter {
    // Public method to start sorting
    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = removeAndSort(stack);
            insertInSortedStack(stack, temp);
        }
    }

    // Recursively remove elements and return last element
    private int removeAndSort(Stack<Integer> stack) {
        int top = stack.pop();
        if (!stack.isEmpty()) {
            int lastRemoved = removeAndSort(stack); // Recursive call to remove next element
            insertInSortedStack(stack, lastRemoved); // Insert last removed element correctly
        }
        return top; // Return last removed element to be inserted back
    }

    // Insert element in sorted position
    private void insertInSortedStack(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insertInSortedStack(stack, value);
            stack.push(temp); // Put back the removed element
        }
    }
}
