package twoPointer;

import java.util.HashMap;
import java.util.Map;

public class MinWindows {
    //lintcode 32
    public String minWindow(String source , String target) {
        // write your code here
        if(source.length() < target.length()){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character,Integer> subCount = new HashMap<>();

        for(int i = 0;i<target.length();++i){
            char c = target.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int start = 0, j = 0;
        int maxLength = Integer.MAX_VALUE;
        int correspondCount = 0;

        for(int i = 0;i<source.length();++i){
            char begin = source.charAt(i);
            while(j<source.length() && correspondCount < map.size()){
                char end = source.charAt(j);
                subCount.put(end, subCount.getOrDefault(end, 0)+1);
                if(subCount.get(end).equals(map.get(end))){
                    correspondCount++;
                }
                j++;
            }

            if(correspondCount == map.size()){
                if(maxLength > j-i){
                    maxLength = j-i;
                    start = i;
                }
            }

            subCount.put(begin,subCount.get(begin)-1);
            if(subCount.get(begin).equals(map.getOrDefault(begin,0)-1)){
                correspondCount--;
            }
        }
        if(maxLength == Integer.MAX_VALUE){
            return "";
        }
        return source.substring(start,start+maxLength);
    }
}
