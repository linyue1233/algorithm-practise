package amazone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    //56
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        int pre = intervals[0][0];
        int last = intervals[0][1];
        List<int[]> ans = new LinkedList<>();
        for(int i = 1;i<intervals.length;++i){
            if(last < intervals[i][0]){
                ans.add(new int[]{pre,last});
                pre = intervals[i][0];
            }
            if(last <= intervals[i][1]){
                last = intervals[i][1];
            }
        }
        ans.add(new int[]{pre,last});
        return ans.toArray(new int[ans.size()][2]);
    }
}
