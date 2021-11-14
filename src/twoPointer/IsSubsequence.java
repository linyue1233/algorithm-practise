package twoPointer;

import java.util.HashMap;
import java.util.Map;

public class IsSubsequence {
    // 392
    public boolean isSubsequence(String s, String t) {
        Map<Integer,Integer> map = new HashMap<>();
        if(s.length() == 0){
            return true;
        }
        int index = 0;
        for(int i = 0;i<t.length();++i){
            if( t.charAt(i) == s.charAt(index)){
                index++;
                if(index == s.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
