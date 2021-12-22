package twoPointer;

public class PalindromeSubstring {
    // 647
    public int countSubstrings(String s) {
        // center spread
        int ans = 0, len = s.length();
        for(int i = 0;i<len;++i){
            // the number is odd
            int l = i, r = i;
            while(l >=0 && r < len && s.charAt(l--) == s.charAt(r++)){
                ans++;
            }

            l = i;
            r = i+1;
            while(l >=0 && r < len && s.charAt(l--) == s.charAt(r++)){
                ans++;
            }
        }
        return ans;
    }
}
