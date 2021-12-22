package twoPointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    // 3
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();++i){
            if(map.containsKey(s.charAt(i))){
                // update new start, jump the repeated letter
                // make sure the right of start has no repeated letter
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            ans = Math.max(ans,i - start + 1);
            map.put(s.charAt(i),i);
        }
        return ans;
    }
}
