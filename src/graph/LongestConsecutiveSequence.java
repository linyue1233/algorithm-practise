package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // 128
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int item : nums){
            map.add(item);
        }
        int ans = 0;
        for(int item : map){
            if( map.contains( item - 1 )){
                continue;
            }else{
                int curNumber = item;
                int curLenght = 1;
                while( map.contains( curNumber + 1 ) ){
                    curLenght++;
                    curNumber++;
                }
                ans = Math.max(ans, curLenght);
            }
        }
        return ans;
    }
}
