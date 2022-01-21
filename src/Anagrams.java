import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagrams {
    public  static int lengthOfLongestSubstring (String s) {
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

//010 010
//    011
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
