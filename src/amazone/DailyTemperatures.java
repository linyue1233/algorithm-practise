package amazone;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    // 739
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[n];
        // make sure the deque is monotonic decrease
        for(int i = 0;i<n;++i){
            while( !deque.isEmpty() && temperatures[i] > temperatures[deque.peekLast()]){
                int tempIndex = deque.pollLast();
                ans[tempIndex] = i - tempIndex;
            }
            deque.offerLast(i);
        }
        return ans;
    }
}
