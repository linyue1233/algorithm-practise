package dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSub {
    // 300
    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        int[] dp =new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0;i<nums.length;++i){
            for(int j = 0;j<i;++j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
