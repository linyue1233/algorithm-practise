package dynamicProgramming;

public class JumpGame {
    // 55
    public static boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int maxPaths = 0;
        for(int i = 0;i<nums.length;++i){
            if(i<=maxPaths){
                maxPaths = Math.max(maxPaths, nums[i] + i);
            }
            if( maxPaths >= nums.length-1) return true;
        }
        return false;
    }
}
