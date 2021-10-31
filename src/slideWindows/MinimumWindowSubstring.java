package slideWindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {
    // 76
    public static String minWindow(String s, String t) {
        int len = s.length(), left = 0;
        int minSize = len+1, minLeft = 0, count = 0;
        boolean[] flag = new boolean[128];
        int[] chars = new int[128];
        for(int i = 0;i<t.length();i++){
            flag[t.charAt(i)] = true;
            chars[t.charAt(i)]++;
        }

        for(int i = 0;i<len;++i){
            if(flag[s.charAt(i)]){
                if(--chars[(s.charAt(i))] >= 0){
                    count++;
                }

                while(count == t.length()){
                    if(i - left + 1 < minSize ){
                        minSize = i - left + 1;
                        minLeft = left;
                    }
                    // -n多少表示当前子序列存在n个多余字母
                    if (flag[s.charAt(left)] && ++chars[s.charAt(left)] > 0) {
                        count--;
                    }
                    left++;
                }
            }
        }
        return minSize > s.length() ? "" : s.substring(minLeft, minLeft + minSize);
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC","ABC");
    }
}
