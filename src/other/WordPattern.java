package other;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    // 290
    public boolean wordPattern(String pattern, String s) {
        String[] store = s.split(" ");
        int len = store.length;
        if(len != pattern.length()){
            return false;
        }
        int[] letters = new int[26];
        Map<String,Character> map =new HashMap<>();
        for(int i = 0;i<len;++i){
            String temp = store[i];
            if( !map.containsKey(temp) ){
                if( letters[pattern.charAt(i) - 'a'] > 0){
                    return false;
                }
                letters[pattern.charAt(i) - 'a']++;
                map.put(temp, pattern.charAt(i));
            }else{
                if( map.get(temp) != pattern.charAt(i) ){
                    return false;
                }
            }
        }
        return true;
    }
}
