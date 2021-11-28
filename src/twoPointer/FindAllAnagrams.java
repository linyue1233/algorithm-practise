package twoPointer;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    // 438
    public static List<Integer> findAnagrams(String s, String p) {
        int[] letters = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            char c = p.charAt(i);
            letters[c - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        int left;
        int[] tempStore = new int[26];
        int len = p.length();
        for (int end = len - 1; end < s.length(); ++end) {
            for (left = end - len + 1; left <= end; ++left) {
                char c = s.charAt(left);
                tempStore[c - 'a']++;
                if (letters[c - 'a'] < tempStore[c - 'a']) {
                    break;
                }
            }
            if (left <= s.length() && left == end+1 && tempStore[s.charAt(end) -'a'] == letters[s.charAt(end) -'a']) {
                ans.add(end - len + 1);
            }
            tempStore = new int[26];
        }
        return ans;
    }

    // 1 2 3 5
    public static void main(String[] args) {
        System.out.println(findAnagrams("abacbabc", "abc"));
    }
}
