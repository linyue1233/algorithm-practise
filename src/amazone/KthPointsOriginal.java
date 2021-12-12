package amazone;

import java.util.PriorityQueue;

public class KthPointsOriginal {
    // 973
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]) );
        for(int[] item : points){
            pq.offer(item);
        }
        int[][] ans = new int[k][2];
        int count = 0;
        while(k>0){
            ans[count++] = pq.poll();
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        kClosest(new int[][]{{3,3},{5,-1},{-2,4}},2);
    }
}
