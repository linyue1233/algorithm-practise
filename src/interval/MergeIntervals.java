package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    // 56
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]>  ans = new ArrayList<>();
        int left = intervals[0][0],pre = intervals[0][1];
        for(int i = 1;i<intervals.length;++i){
            if( pre < intervals[i][0]){
                ans.add(new int[]{left,pre});
                left = intervals[i][0];
            }
            if(pre > intervals[i][1]){
                continue;
            }
            pre = intervals[i][1];
        }
        ans.add(new int[]{left,pre});
        return ans.toArray(new int[ans.size()][2]);
    }
}
