package interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    // 57
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        List<int[]> res = new ArrayList<>();
        boolean placed = false;
        for(int[] item : intervals){
            if(right < item[0]){
                if(!placed){
                    placed = true;
                    res.add(new int[]{left,right});
                }
                res.add(item);
            }else if(left > item[1]){
                res.add(item);
            }else{
                left = Math.min(left,item[0]);
                right = Math.max(right,item[1]);
            }
        }

        if(!placed){
            res.add(new int[]{left,right});
        }
        int[][] ans = new int[res.size()][2];
        for(int i = 0 ;i<res.size();++i){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
