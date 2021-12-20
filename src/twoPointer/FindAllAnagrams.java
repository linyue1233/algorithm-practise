package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
    // 438
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), m = p.length();
        if(n<m){
            return ans;
        }
        int[] storeS = new int[26];
        int[] storeP = new int[26];
        for(int i = 0;i<m;++i){
            storeS[s.charAt(i)-'a']++;
            storeP[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(storeS,storeP)){
            ans.add(0);
        }
        for(int i = m;i<n;++i){
            storeS[s.charAt(i-m)-'a']--;
            storeS[s.charAt(i)-'a']++;
            if(Arrays.equals(storeS,storeP)){
                ans.add(i-m+1);
            }
        }
        return ans;
    }
//    public static List<Integer> findAnagrams(String s, String p) {
//        int[] letters = new int[26];
//        for (int i = 0; i < p.length(); ++i) {
//            char c = p.charAt(i);
//            letters[c - 'a']++;
//        }
//
//        List<Integer> ans = new ArrayList<>();
//        int left;
//        int[] tempStore = new int[26];
//        int len = p.length();
//        for (int end = len - 1; end < s.length(); ++end) {
//            for (left = end - len + 1; left <= end; ++left) {
//                char c = s.charAt(left);
//                tempStore[c - 'a']++;
//                if (letters[c - 'a'] < tempStore[c - 'a']) {
//                    break;
//                }
//            }
//            if (left <= s.length() && left == end+1 && tempStore[s.charAt(end) -'a'] == letters[s.charAt(end) -'a']) {
//                ans.add(end - len + 1);
//            }
//            tempStore = new int[26];
//        }
//        return ans;
//    }

    // 1 2 3 5
}
