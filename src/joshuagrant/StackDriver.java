package joshuagrant;

import java.util.Stack;

public class StackDriver {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(1);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.push(4));
    }
}
