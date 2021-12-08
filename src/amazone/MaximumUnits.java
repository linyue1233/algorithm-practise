package amazone;

import java.util.PriorityQueue;

public class MaximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // build max-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        for(int[] item : boxTypes){
            pq.offer(item);
        }
        int ans = 0;
        while(pq.size() != 0 && truckSize > 0){
            int num = pq.peek()[0];
            int value = pq.peek()[1];
            pq.poll();
            if( num <= truckSize){
                ans += num * value;
                truckSize = truckSize - num;
            }else{
                ans += truckSize * value;
                return ans;
            }
        }
        return ans;
    }
}
