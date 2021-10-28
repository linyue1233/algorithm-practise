package dynamicProgramming;

public class HouseRobber {
    // 198
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }

        int ans = Integer.MIN_VALUE;
        int a = nums[0], b = Math.max(nums[0],nums[1]);
        for(int i = 2;i<n;++i){
            ans = Math.max(a + nums[i],b);
            a = b;
            b = ans;
        }
        return ans;
    }
}
