package interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonIntervals {
    // 435
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int ans = 0,pre = intervals[0][1];
        for(int i = 1;i<intervals.length;++i){
            if(pre > intervals[i][0]){
                ans++;
            }else{
                pre = intervals[i][1];
            }
        }
        return ans;
    }
}
