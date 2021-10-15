package dynamicProgramming;

public class OnesZeros {

    // 474 p[i][j][k] 表示在前 ii 个字符串中，使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量。假设数组 str 的长度为 ll，则最终答案为 \textit{dp}[l][m][n]dp[l][m][n]。
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int[] countAns = countZeroAndOne(str);
            for(int i = m;i>=countAns[0];i--){
                for(int j = n;j>=countAns[1];j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-countAns[0]][j-countAns[1]]+1);
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
