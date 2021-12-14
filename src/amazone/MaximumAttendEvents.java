package amazone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumAttendEvents {
    //    // 1353
    public int maxEvents(int[][] events) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int[] event : events) {
            min = Math.min(min, event[0]);
            max = Math.max(max, event[1]);
        }
        List<Integer>[] store = new List[max - min + 2];
        for (int[] event : events) {
            if (store[event[0] - min + 1] == null) {
                store[event[0] - min + 1] = new ArrayList<>();
            }
            store[event[0] - min + 1].add(event[1]);
        }

        for (int i = min; i <= max; ++i) {
            if (store[i - min + 1] != null) {
                for (int item : store[i - min + 1]) {
                    pq.offer(item);
                }
            }
            if (!pq.isEmpty() && pq.peek() >= i) {
                pq.poll();
                ans++;
            }
            // delete the old days
            while (!pq.isEmpty() && pq.peek() == i) {
                pq.poll();
            }
        }
        return ans;
    }
}
