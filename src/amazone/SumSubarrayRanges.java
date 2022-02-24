package amazone;

import java.util.Deque;
import java.util.LinkedList;

public class SumSubarrayRanges {
    // 2104 monotonic
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        long ans = 0;
        // find the left and right parts which are bigger than index I
        int[] left = new int[n];
        int[] right = new int[n];

        // find the left which are less than nums[i]
        for (int i = 0; i < n; ++i) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            if (deque.isEmpty()) {
                left[i] = -1;
            } else {
                // it means find the index which is > nums[i]
                left[i] = deque.peekLast();
            }
            deque.offerLast(i);
        }
        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            if (deque.isEmpty()) {
                right[i] = n;
            } else {
                // it means find the index which is > nums[i]
                right[i] = deque.peekLast();
            }
            deque.offerLast(i);
        }
        for (int i = 0; i < n; ++i) {
            ans += (long) nums[i] * (i - left[i]) * (right[i] - i);
        }
        deque.clear();
        for (int i = 0; i < n; ++i) {
            while (!deque.isEmpty() && nums[deque.peekLast()] >= nums[i]) {
                deque.pollLast();
            }
            if (deque.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = deque.peekLast();
            }
            deque.offerLast(i);
        }
        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) {
                deque.pollLast();
            }
            if (deque.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = deque.peekLast();
            }
            deque.offerLast(i);
        }
        for (int i = 0; i < n; ++i) {
            ans -= (long) nums[i] * (i - left[i]) * (right[i] - i);
        }
        return ans;
    }
}
