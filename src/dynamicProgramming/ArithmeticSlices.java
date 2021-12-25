package dynamicProgramming;

public class ArithmeticSlices {
    // 413
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for(int i = 2;i<len;++i){
            if(nums[i] - nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i] = 1 + dp[i-1];
            }
        }
        int sum = 0;
        for(int item : dp){
            sum += item;
        }
        return sum;
    }
}
