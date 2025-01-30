package stacksandqueues.implementqueueusingstacks;
import java.util.*;
public class CustomStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //creating 2 empty stacks
        Stack<Integer> enqueueStack = new Stack<>();
        Stack<Integer> dequeueStack = new Stack<>();

        //taking input from user
        System.out.println("Enter no of elements ");
        int n = sc.nextInt();
        for(int i =1;i<=n;i++){
            System.out.println("enter element");
            int x = sc.nextInt();
            enqueueStack.push(x);
        }

        //enter elements of stack 1 into stack 2
        while(enqueueStack.size()>0){
            dequeueStack.push(enqueueStack.pop());
        }

        //inserting elements of stack2 into queue
        while(dequeueStack.size()>0){
            enqueueStack.push(dequeueStack.pop());
        }
        System.out.println(enqueueStack);
    }

}
