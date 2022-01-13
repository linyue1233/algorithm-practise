package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsSums {
    // 373
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(nums1[a[0]]+nums2[a[1]]) -( nums1[b[0]]+nums2[b[1]] ));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<Math.min(nums1.length,k);++i){
            pq.offer(new int[]{i,0});
        }
        // pq stores the idnex of two array
        while( k>0 && !pq.isEmpty()){
            int[] temp = pq.poll();
            ans.add(Arrays.asList(nums1[temp[0]],nums2[temp[1]]));
            if( temp[1] + 1 < nums2.length){
                pq.offer(new int[]{temp[0],temp[1]+1});
            }
            k--;
        }
        return ans;
    }
}
