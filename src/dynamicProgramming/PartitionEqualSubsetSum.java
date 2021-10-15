package dynamicProgramming;


import java.util.Arrays;

// 416  i代表第几个数，j代表和，dp代表到第i-1个下表的数是否能达到j
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum , len = nums.length;
        boolean[] ans = new boolean[len];
        sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[len+1][sum+1];
        for(int i= 1;i<=len;++i){
            dp[i][0] = true;
            for(int j = 1;j<=sum;++j){
                if(j-nums[i-1] >=0 ){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][sum];
    }

    public boolean canPartition1(int[] nums) {
        int sum , len = nums.length;
        boolean[] ans = new boolean[len];
        sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= num; --j) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }
}
