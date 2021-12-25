import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagrams {
    public int findKthLargest(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int item : nums){
            map.put(item, map.getOrDefault(item,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getKey()-a.getKey());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        return 0;
    }
}
