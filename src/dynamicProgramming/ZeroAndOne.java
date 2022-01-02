package dynamicProgramming;

public class ZeroAndOne {
    // 474
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i<len;++i){
            int[] count = countZeroAndOne(strs[i]);
            for(int j = m;j>=count[0];--j){
                for(int k = n;k>=count[1];--k){
                    dp[j][k] = Math.max(dp[j][k], dp[j-count[0]][k-count[1]]+1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] countZeroAndOne(String str) {
        int[] ans = new int[2];
        int one  = 0, zero = 0;
        for(int i = 0;i<str.length();++i){
            char c = str.charAt(i);
            if( c == '0') {
                zero++;
            }else{
                one++;
            }
        }
        ans[0] = zero;
        ans[1] = one;
        return ans;
    }
}
