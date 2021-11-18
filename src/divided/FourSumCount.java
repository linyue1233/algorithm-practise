package divided;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    //454
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0,n=nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;++i){
            for(int j=0;j<n;++j){
                int sum = nums1[i] + nums2[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        for(int i =0;i<n;++i){
            for(int j = 0;j<n;j++){
                int temp = 0 - (nums3[i]+nums4[j]);
                if(map.containsKey(temp)){
                    ans += map.get(temp);
                }
            }
        }
        return ans;
    }
}
