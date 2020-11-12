package offer;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> sMin;

    public MinStack() {
        s = new Stack<>();
        sMin = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        if (sMin.empty() || sMin.peek() >= x) sMin.push(x);
    }

    public void pop() {
        if (s.peek().equals(sMin.peek())) sMin.pop();
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return sMin.peek();
    }
}
