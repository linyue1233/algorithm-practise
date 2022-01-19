import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagrams {
    public  static int lengthOfLongestSubstring (String s) {
        // write code here
        // slide window
        int len = s.length();
        int maxLength = 0;
        Map<Character,Integer> map = new HashMap<>();
        int end  = 0;
        while( end < len){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                maxLength = Math.max(maxLength, end - map.get(c));
            }
            map.put(c,end);
            end++;
        }
        return maxLength;
    }

//010 010
//    011
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
