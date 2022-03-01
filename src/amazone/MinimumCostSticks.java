package amazone;

import java.util.PriorityQueue;

public class MinimumCostSticks {
    //1167
    public int connectSticks(int[] sticks) {
        if(sticks.length == 1) return 0;
        // build min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = sticks.length;
        int ans = 0;
        for (int stick : sticks) {
            pq.add(stick);
        }
        while( pq.size() -1 != 0){
            int temp = pq.poll() + pq.poll();
            ans += temp;
            pq.add(temp);
        }
        return ans;
    }
}
