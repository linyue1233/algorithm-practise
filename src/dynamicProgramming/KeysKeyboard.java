package dynamicProgramming;

public class KeysKeyboard {
    // 650
    public int minSteps(int n) {
        if (n == 1) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; ++i) {
            dp[i] = i;
            for (int j = 2; j * j <= i; ++j) {
                if( i % j == 0){
                    dp[i] = Math.min(dp[i],dp[j]+i/j);
                    dp[i] = Math.min(dp[i],dp[i/j] + j);
                }
            }
        }
        return dp[n];
    }
}
