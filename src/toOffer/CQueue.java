package toOffer;

import java.util.Stack;

public class CQueue {
    Stack<Integer> nums;
    Stack<Integer> store;
    public CQueue() {
         nums = new Stack<>();
         store = new Stack<>();
    }

    public void appendTail(int value) {
        nums.push(value);
    }

    public int deleteHead() {
        if(store.isEmpty()){
            while(!nums.isEmpty()){
                store.push(nums.pop());
            }
        }
        if(store.isEmpty()) return -1;
        return store.pop();
    }
}
