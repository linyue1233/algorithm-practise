package other;

import java.util.HashMap;
import java.util.Map;

public class FindHS {
    // 594
    public int findLHS(int[] nums) {
        int maxCount = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer item : nums){
            map.put(item, map.getOrDefault(item,0)+1);
            if( map.getOrDefault(item+1,0) == 0 && map.getOrDefault(item-1,0) == 0){
                continue;
            }
            maxCount = Math.max(maxCount,map.get(item) + map.getOrDefault(item+1,0));
            maxCount = Math.max(maxCount,map.get(item) + map.getOrDefault(item-1,0));
        }
        return maxCount;
    }
}
