package other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandStraights {
    // 846
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if( n % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);
        int index = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;++i){
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }
        while(index < n){
            int begin = hand[index];
            for(int i = 0;i<groupSize;++i){
                if(!map.containsKey(begin+i)){
                    return false;
                }
                int count = map.get(begin+i);
                if(count < 1){
                    return  false;
                }
                map.put(begin+i,count-1);
            }
            while(index < n && map.getOrDefault(hand[index],0) < 1){
                index++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3);
    }
}
