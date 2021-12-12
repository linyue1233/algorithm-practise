package amazone;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class LeastNumberKthRemove {
    //1481
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int item : arr){
            map.put(item, map.getOrDefault(item,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> entry : set){
            pq.offer(entry);
        }
        int ans = pq.size();
        while(pq.size() != 0 && k > 0){
            int count = pq.peek().getValue();
            if(k >= count){
                ans--;
                k = k- count;
                pq.poll();
            }else{
                return ans;
            }
        }
        return ans;
    }
}
