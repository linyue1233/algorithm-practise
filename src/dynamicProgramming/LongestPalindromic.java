package dynamicProgramming;

public class LongestPalindromic {
    // 5
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0;i<s.length();++i){
            int len_odd  = maxPalindrome(s,i,i);
            int len_even = maxPalindrome(s,i,i+1);
            int len = Math.max(len_odd, len_even);
            if(len > end - start + 1){
                start = i - (len - 1) / 2;
                end = i + len/2;
            }
        }
        // 注意：这里的end+1是因为 java自带的左闭右开的原因
        return s.substring(start,end+1);
    }

    private int maxPalindrome(String s, int r, int c){
        while(r>=0 && r < s.length() && s.charAt(r) == s.charAt(c)){
            r--;
            c++;
        }
        // 回文串的长度是right-left+1-2 = right - left - 1
        return c - r - 1;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("cbbd"));
    }
}
