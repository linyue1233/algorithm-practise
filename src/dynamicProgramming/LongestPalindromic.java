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
        return s.substring(start,end+1);
    }

    private int maxPalindrome(String s, int r, int c){
        while(r>=0 && r < s.length() && s.charAt(r) == s.charAt(c)){
            r--;
            c++;
        }
        return c - r - 1;
    }

//    public String longestPalindrome(String s) {
//        int len = s.length();
//        int maxSize = 0,left = 0;
//        String ans = "";
//        while( len - left > maxSize){
//            int right = len - 1;
//            while( left <= right){
//                if(s.charAt(left) == s.charAt(right)){
//                    if( isPalindromic(s.substring(left,right + 1))){
//                        if( right - left + 1 > maxSize){
//                            maxSize = right - left + 1;
//                            ans = s.substring(left,right + 1);
//                            break;
//                        }
//                    }
//                }
//                right--;
//            }
//            left++;
//        }
//        return ans;
//    }
//
//    private  boolean isPalindromic(String s){
//        int left = 0, right = s.length()-1;
//        while(left <= right){
//            if( !Character.isLetterOrDigit(s.charAt(left))){
//                left++;
//            }else if( !Character.isLetterOrDigit(s.charAt(right))){
//                right--;
//            }else{
//                if( Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)) ){
//                    return false;
//                }else{
//                    left++;
//                    right--;
//                }
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("cbbd"));
    }
}
