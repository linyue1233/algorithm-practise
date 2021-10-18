package toOffer;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> help;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        help = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(help.isEmpty() || help.peek() >= x){
            help.push(x);
        }
    }

    public void pop() {
        if(stack.peek().equals(help.peek())) help.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return help.peek();
    }
}
