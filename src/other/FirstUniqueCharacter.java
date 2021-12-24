package other;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    // 387
    public int firstUniqChar(String s) {
        int[] letters = new int[26];

        for(int i = 0;i<s.length();++i){
            letters[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i<s.length();++i){
            char c = s.charAt(i);
            if( letters[c -'a'] < 2){
                return i;
            }
        }
        return -1;
    }
}
