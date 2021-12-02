package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class FindRelativeRanks {
    // 506
    public String[] findRelativeRanks(int[] score) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<score.length;++i){
            map.put(i,score[i]);
        }
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((o1,o2)->o2.getValue()- o1.getValue());

        int count = 1;
        for(Map.Entry<Integer,Integer> entry:entries){
            pq.offer(entry);
        }

        String[] ans = new String[score.length];
        while( !pq.isEmpty() ){
            if(count <=3){
                if(count == 1){
                    ans[pq.peek().getKey()] = "Gold Medal";
                }else if(count == 2){
                    ans[pq.peek().getKey()] = "Silver Medal";
                }else{
                    ans[pq.peek().getKey()] = "Bronze Medal";

                }
                count++;
                pq.poll();
            }else{
                ans[pq.peek().getKey()] = count+"";
                pq.poll();
            }
        }
        return ans;

    }
}
