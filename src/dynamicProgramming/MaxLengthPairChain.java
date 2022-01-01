package dynamicProgramming;

import java.util.Arrays;

public class MaxLengthPairChain {
    // 646
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        int maxLength = 0;
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        Arrays.fill(dp,1);
        for(int i = 0;i<n;++i){
            for(int j = 0;j<i;++j){
                if( pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
