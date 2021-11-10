package sort;

import java.util.HashMap;
import java.util.Map;

public class SumOfUnique {
    // 1748
    public int sumOfUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0;i<nums.length;++i){
            ans += nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > 1){
                ans -= key * map.get(key);
            }
        }
        return ans;
    }
}
