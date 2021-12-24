package other;

import java.util.PriorityQueue;

public class MaximumNumberEatenApples {
    // 1705
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0, day = 0;
        // the first stores the day will rot, and the second stores number of apple
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        while(day < days.length ||  !pq.isEmpty()){
            if( day < days.length && apples[day] > 0){
                pq.add(new int[]{day + days[day],apples[day]});
            }
            while(!pq.isEmpty() && (pq.peek()[0] <= day || pq.peek()[1] == 0)){
                pq.poll();
            }
            if(!pq.isEmpty()){
                ans++;
                --pq.peek()[1];
            }
            day++;
        }
        return ans;
    }
}
