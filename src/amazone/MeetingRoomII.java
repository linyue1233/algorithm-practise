package amazone;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {
    // 253
    //  intervals = [[0,30],[5,10],[15,20]]
    //  2
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int ans = 0;
        // build min-heap according end day
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (int i = 0; i < intervals.length; ++i) {
            if (pq.isEmpty()) {
                ans++;
                pq.offer(intervals[i]);
            } else {
                if (pq.peek()[1] <= intervals[i][0]) {
                    pq.poll();
                    pq.offer(intervals[i]);
                } else {
                    ans++;
                    pq.offer(intervals[i]);
                }
            }
        }
        return ans;

    }
}
