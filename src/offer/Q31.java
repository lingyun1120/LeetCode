package offer;

import java.util.Stack;

public class Q31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i = 0; i < pushed.length; i ++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty()
                    && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
