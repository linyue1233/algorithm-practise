package dynamicProgramming;

public class TargetSum {
    // 494
    public int findTargetSumWays(int[] nums, int target) {
        //可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号
//                           sum(P) - sum(N) = target
// sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
//                        2 * sum(P) = target + sum(nums)
        int sum = 0;
        for(int item:nums){
            sum += item;
        }
        if( sum < target || (sum+target)%2==1 || sum+target < 0){
            return 0;
        }
        int wanted = (sum+target)/2;
        int[] dp = new int[wanted+1];
        dp[0] = 1;
        for(int i = 0;i<nums.length;++i){
            for(int j = wanted;j>=nums[i];--j){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[wanted];
    }
}
