package amazone;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingMaxWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 239 monotonic decrease
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // range :[i-k+1,i]    0-2   3
            if (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            if (i - k + 1 >= 0) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
