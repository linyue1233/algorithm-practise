package amazone;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingMaxWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        // store the index of nums
        // maintain the deque from big to small
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i<n;++i){
            // maintain the quality of deque
            while( !deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
            // range [i-k+1,i]
            if(deque.peek()<i-k+1){
                deque.poll();
            }
            if(i>=k-1){
                ans[i-k+1] = nums[deque.peek()];
            }
        }
        return ans;
    }
}
