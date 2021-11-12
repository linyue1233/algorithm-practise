package other;

import java.util.*;

public class SortArrayIncreasingOrder {
    //1636
    public static int[] frequencySort(int[] nums) {
        int[] ans = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int item : nums){
            map.put(item, map.getOrDefault(item,0)+1);
        }
        // build heap
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();;
        PriorityQueue< Map.Entry<Integer,Integer> > pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.getValue().equals(o2.getValue())){
                return o2.getKey() - o1.getKey();
            }else{
                return o1.getValue()-o2.getValue();
            }
        });

        for(Map.Entry<Integer,Integer> entry:entries){
            pq.offer(entry);
        }
        int count = 0;
        while(!pq.isEmpty()){
            int times = pq.peek().getValue();
            for(int i = 0;i<times;i++){
                ans[count++] = pq.peek().getKey();
            }
            pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1});
    }
}
