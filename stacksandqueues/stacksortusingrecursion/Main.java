package stacksandqueues.stacksortusingrecursion;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);

        System.out.println("Original Stack: " + stack);

        StackSorter sorter = new StackSorter();
        sorter.sort(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
