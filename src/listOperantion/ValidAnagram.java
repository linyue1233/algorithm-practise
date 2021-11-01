package listOperantion;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    // 242
    public boolean isAnagram(String s, String t) {
        if( s.length() != t.length()) return false;
        int[] store= new int[26];
        for(int i = 0;i < s.length();++i){
            store[s.charAt(i) -  'a']++;
        }

        for(int i = 0;i<t.length();++i){
            char temp = t.charAt(i);
            if(store[temp - 'a'] ==0){
                return false;
            }
            store[temp - 'a']--;
        }
        return true;
    }
}
