package dynamicProgramming;

public class DecodeWays {
    //91
    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i <= len; ++i) {
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                if (s.charAt(i - 1) == '0') {
                    dp[i] = dp[i-2];
                }else if(s.charAt(i-2) == '1'){
                    dp[i] = dp[i-1] + dp[i-2];
                }else if(s.charAt(i-2) == '2' && s.charAt(i-1) > '0' && s.charAt(i-1) <= '6'){
                    dp[i] = dp[i-1] + dp[i-2];
                }else{
                    dp[i] = dp[i-1];
                }
            }else{
                if(s.charAt(i-1) == '0') return 0;
                dp[i] = dp[i-1];
            }
        }
        return dp[len];
    }
}
